package projeto.dio.projeto_api_rest.DTO.categories;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryRequestDTO {
    private String name;
    private String description;
    private String icon;
}