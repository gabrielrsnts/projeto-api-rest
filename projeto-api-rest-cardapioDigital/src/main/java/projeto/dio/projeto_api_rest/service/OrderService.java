package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.DTO.CreateOrderRequestDTO;
import projeto.dio.projeto_api_rest.DTO.OrderResponseDTO;
import projeto.dio.projeto_api_rest.DTO.UpdateOrderRequestDTO;
import projeto.dio.projeto_api_rest.domain.model.Order;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<OrderResponseDTO> getAllOrders();
    Optional<OrderResponseDTO> getOrderById(Long id);
    Order createOrder(CreateOrderRequestDTO dto);
    Order updateOrder(Long orderId, UpdateOrderRequestDTO dto);
    void deleteOrder(Long id);
    List<Order> getOrdersByStatus(String status);
}
