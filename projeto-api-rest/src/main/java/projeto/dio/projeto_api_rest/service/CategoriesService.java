package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.model.Categories;
import projeto.dio.projeto_api_rest.model.Item;

@Service
public interface CategoriesService {
    Categories findById(long id);

    Categories categoriesCreate(Categories categoriesToCreate);
}
