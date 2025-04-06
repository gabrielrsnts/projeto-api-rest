package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.DTO.categories.CategoryResponseDTO;
import projeto.dio.projeto_api_rest.DTO.categories.CreateCategoryRequestDTO;
import projeto.dio.projeto_api_rest.DTO.categories.UpdateCategoryRequestDTO;
import projeto.dio.projeto_api_rest.domain.model.Categories;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoriesService {
    List<CategoryResponseDTO> getAllCategories();
    Optional<CategoryResponseDTO> getCategoriesById(Long id);
    Categories createCategories(CreateCategoryRequestDTO dto);
    Categories updateCategories(Long id, UpdateCategoryRequestDTO dto);
    void deleteCategories(Long id);
}
