package projeto.dio.projeto_api_rest.DTO.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDTO {
    private Long itemId;
    private int quantity;
    private double unitPrice;
}

