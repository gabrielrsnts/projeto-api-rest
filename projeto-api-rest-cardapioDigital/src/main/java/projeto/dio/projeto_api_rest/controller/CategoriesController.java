package projeto.dio.projeto_api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Categories> createCategory(@RequestBody Categories category) {
        Categories createdCategory = categoriesService.createCategories(category);
        return ResponseEntity.ok(createdCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categories>> getCategoryById(@PathVariable Long id) {
        Optional<Categories> category = categoriesService.getCategoriesById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = categoriesService.getAllCategoriess();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories category) {
        Categories updatedCategory = categoriesService.updateCategories(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriesService.deleteCategories(id);
        return ResponseEntity.noContent().build();
    }
}
