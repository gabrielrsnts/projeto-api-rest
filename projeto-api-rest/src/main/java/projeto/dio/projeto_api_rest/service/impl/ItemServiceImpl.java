package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import projeto.dio.projeto_api_rest.model.Item;
import projeto.dio.projeto_api_rest.repository.ItemRepository;
import projeto.dio.projeto_api_rest.service.ItemService;

import java.util.NoSuchElementException;

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item findById(long id) {
        return itemRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Item itemCreate(Item itemToCreate) {
        if(itemRepository.existsByItem(itemToCreate.getName())){
            throw new IllegalArgumentException("Esse Item já existe");
        }
        return itemRepository.save(itemToCreate);
    }
}
