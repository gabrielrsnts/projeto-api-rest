package projeto.dio.projeto_api_rest.DTO.item;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemRequestDTO {
    private String name;
    private Double price;
    private String description;
    private String icon;
    private Long categoriesId;
}