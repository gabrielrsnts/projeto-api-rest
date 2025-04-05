package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.DTO.item.CreateItemRequestDTO;
import projeto.dio.projeto_api_rest.DTO.item.ItemResponseDTO;
import projeto.dio.projeto_api_rest.domain.model.Item;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {
    List<ItemResponseDTO> getAllItems();
    Optional<ItemResponseDTO> getItemById(Long id);
    Item createItem(CreateItemRequestDTO dto);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
}
