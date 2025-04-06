package projeto.dio.projeto_api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.dio.projeto_api_rest.DTO.categories.CategoryResponseDTO;
import projeto.dio.projeto_api_rest.DTO.categories.CreateCategoryRequestDTO;
import projeto.dio.projeto_api_rest.DTO.categories.UpdateCategoryRequestDTO;
import projeto.dio.projeto_api_rest.domain.model.Categories;
import projeto.dio.projeto_api_rest.service.CategoriesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public ResponseEntity<Categories> createCategory(@RequestBody CreateCategoryRequestDTO dto) {
        Categories createdCategory = categoriesService.createCategories(dto);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoryResponseDTO>> getCategoryById(@PathVariable Long id) {
        Optional<CategoryResponseDTO> category = categoriesService.getCategoriesById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<CategoryResponseDTO> categories = categoriesService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryRequestDTO dto) {
        Categories updatedCategory = categoriesService.updateCategories(id, dto);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategories(id);
        return ResponseEntity.noContent().build();
    }
}
