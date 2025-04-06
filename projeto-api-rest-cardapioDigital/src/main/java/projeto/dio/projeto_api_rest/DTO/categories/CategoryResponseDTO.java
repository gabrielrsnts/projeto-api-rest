package projeto.dio.projeto_api_rest.DTO.categories;

import lombok.*;
import projeto.dio.projeto_api_rest.domain.model.Categories;

@Data
public class CategoryResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String icon;

    // Construtor que recebe a entidade Categories
    public CategoryResponseDTO(Categories category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
        this.icon = category.getIcon();
    }
}