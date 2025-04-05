package projeto.dio.projeto_api_rest.DTO.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponseDTO {
    private Long itemId;
    private String itemName;
    private int quantity;
    private double unitPrice;
}