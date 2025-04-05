package projeto.dio.projeto_api_rest.DTO.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemResponseDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String icon;
    private String categoryName;
}
