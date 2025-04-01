package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.model.Categories;
import projeto.dio.projeto_api_rest.model.Categories;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoriesService {
    List<Categories> getAllCategoriess();
    Optional<Categories> getCategoriesById(Long id);
    Categories createCategories(Categories categories);
    Categories updateCategories(Long id, Categories categories);
    void deleteCategories(Long id);
}
