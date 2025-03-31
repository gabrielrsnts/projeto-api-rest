package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.model.Categories;
import projeto.dio.projeto_api_rest.model.Item;
import projeto.dio.projeto_api_rest.repository.CategoriesRepository;
import projeto.dio.projeto_api_rest.service.CategoriesService;

import java.util.NoSuchElementException;

@Service
public class CategoriesSeviceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesSeviceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Categories findById(long id) {
        return categoriesRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Categories categoriesCreate(Categories categoriesToCreate) {
        if(categoriesRepository.existsByCategories(categoriesToCreate.getName())){
            throw new IllegalArgumentException("Essa Categoria já existe");
        }
        return categoriesRepository.save(categoriesToCreate);
    }
}
