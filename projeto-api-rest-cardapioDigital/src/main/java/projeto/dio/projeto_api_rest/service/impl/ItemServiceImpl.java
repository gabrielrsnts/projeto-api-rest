package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.DTO.item.CreateItemRequestDTO;
import projeto.dio.projeto_api_rest.DTO.item.ItemResponseDTO;
import projeto.dio.projeto_api_rest.domain.model.Categories;
import projeto.dio.projeto_api_rest.domain.model.Item;
import projeto.dio.projeto_api_rest.domain.repository.CategoriesRepository;
import projeto.dio.projeto_api_rest.domain.repository.ItemRepository;
import projeto.dio.projeto_api_rest.service.ItemService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoriesRepository categoriesRepository) {
        this.itemRepository = itemRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        return itemRepository.findAll().stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ItemResponseDTO> getItemById(Long id) {
        return itemRepository.findById(id).map(this::convertToResponseDTO);
    }


    @Override
    public Item createItem(CreateItemRequestDTO dto) {
        if (itemRepository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Esse item já existe");
        }

        Categories category = categoriesRepository.findById(dto.getCategoriesId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria com ID " + dto.getCategoriesId() + " não encontrada"));

        Item item = new Item();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        item.setDescription(dto.getDescription());
        item.setIcon(dto.getIcon());
        item.setCategories(category);

        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        if (itemRepository.existsById(id)) {
            item.setId(id);
            return itemRepository.save(item);
        }
        throw new IllegalArgumentException("Item não encontrado");
    }

    @Override
    public void deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Item não encontrado");
        }
    }

    private ItemResponseDTO convertToResponseDTO(Item item) {
        return new ItemResponseDTO(
                item.getId(),
                item.getName(),
                item.getPrice(),
                item.getDescription(),
                item.getIcon(),
                item.getCategories() != null ? item.getCategories().getName() : null
        );
    }
}
