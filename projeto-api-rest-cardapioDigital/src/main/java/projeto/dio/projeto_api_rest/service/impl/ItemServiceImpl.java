package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.domain.model.Item;
import projeto.dio.projeto_api_rest.domain.repository.ItemRepository;
import projeto.dio.projeto_api_rest.service.ItemService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
        if(itemRepository.existsByName(item.getName())){
            throw new IllegalArgumentException("Esse item já existe");
        }
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
}
