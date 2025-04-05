package projeto.dio.projeto_api_rest.DTO;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CreateOrderRequestDTO {
    private String status;
    private List<OrderItemRequestDTO> orderItems;
}
