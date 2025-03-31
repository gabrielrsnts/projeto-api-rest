package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.model.Item;
import projeto.dio.projeto_api_rest.model.User;

@Service
public interface ItemService {
    Item findById(long id);

    Item itemCreate(Item itemToCreate);
}
