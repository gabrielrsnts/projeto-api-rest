package projeto.dio.projeto_api_rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.DTO.categories.CategoryResponseDTO;
import projeto.dio.projeto_api_rest.DTO.categories.CreateCategoryRequestDTO;
import projeto.dio.projeto_api_rest.DTO.categories.UpdateCategoryRequestDTO;
import projeto.dio.projeto_api_rest.domain.model.Categories;
import projeto.dio.projeto_api_rest.domain.repository.CategoriesRepository;
import projeto.dio.projeto_api_rest.service.CategoriesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoriesRepository.findAll().stream()
                .map(CategoryResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryResponseDTO> getCategoriesById(Long id) {
        return categoriesRepository.findById(id).map(CategoryResponseDTO::new);
    }

    @Override
    public Categories createCategories(CreateCategoryRequestDTO dto) {
        if (categoriesRepository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Essa categoria já existe");
        }
        Categories categories = new Categories();
        categories.setName(dto.getName());
        categories.setDescription(dto.getDescription());
        categories.setIcon(dto.getIcon());
        return categoriesRepository.save(categories);
    }

    @Override
    public Categories updateCategories(Long id, UpdateCategoryRequestDTO dto) {
        Categories existingCategory = categoriesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        existingCategory.setName(dto.getName());
        existingCategory.setDescription(dto.getDescription());
        existingCategory.setIcon(dto.getIcon());

        return categoriesRepository.save(existingCategory);
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
