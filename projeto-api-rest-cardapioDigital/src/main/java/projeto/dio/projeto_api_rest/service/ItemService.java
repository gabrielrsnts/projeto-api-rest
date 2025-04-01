package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.domain.model.Item;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {
    List<Item> getAllItems();
    Optional<Item> getItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
}
