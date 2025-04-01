package projeto.dio.projeto_api_rest.service;

import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.domain.model.Order;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
    List<Order> getOrdersByStatus(String status);
}
