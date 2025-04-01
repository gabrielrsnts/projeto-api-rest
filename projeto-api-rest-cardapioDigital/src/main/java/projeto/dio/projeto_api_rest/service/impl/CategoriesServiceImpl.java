package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.domain.model.Categories;
import projeto.dio.projeto_api_rest.domain.repository.CategoriesRepository;
import projeto.dio.projeto_api_rest.service.CategoriesService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<Categories> getAllCategoriess() {
        return categoriesRepository.findAll();
    }

    @Override
    public Optional<Categories> getCategoriesById(Long id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public Categories createCategories(Categories categories) {
        if(categoriesRepository.existsByName(categories.getName())){
            throw new IllegalArgumentException("Essa categoria já existe");
        }
        return categoriesRepository.save(categories);
    }

    @Override
    public Categories updateCategories(Long id, Categories categories) {
        if (categoriesRepository.existsById(id)) {
            categories.setId(id);
            return categoriesRepository.save(categories);
        }
        throw new IllegalArgumentException("Categoria não encontrada");
    }

    @Override
    public void deleteCategories(Long id) {
        if (categoriesRepository.existsById(id)) {
            categoriesRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Categoria não encontrada");
        }
    }
}
