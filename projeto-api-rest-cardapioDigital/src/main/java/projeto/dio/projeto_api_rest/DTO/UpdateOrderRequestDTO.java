package projeto.dio.projeto_api_rest.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateOrderRequestDTO {

    private String status;
    private List<OrderItemRequestDTO> orderItems;

    public UpdateOrderRequestDTO() {
    }

    public UpdateOrderRequestDTO(String status, List<OrderItemRequestDTO> orderItems) {
        this.status = status;
        this.orderItems = orderItems;
    }
}
