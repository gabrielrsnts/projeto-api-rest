package projeto.dio.projeto_api_rest.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.dio.projeto_api_rest.DTO.order.*;
import projeto.dio.projeto_api_rest.domain.model.Item;
import projeto.dio.projeto_api_rest.domain.model.Order;
import projeto.dio.projeto_api_rest.domain.model.OrderItem;
import projeto.dio.projeto_api_rest.domain.repository.ItemRepository;
import projeto.dio.projeto_api_rest.domain.repository.OrderRepository;
import projeto.dio.projeto_api_rest.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    @Transactional
    public Optional<OrderResponseDTO> getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(this::mapToResponseDTO);
    }

    @Override
    public Order createOrder(CreateOrderRequestDTO dto) {
        Order order = new Order();
        order.setStatus(dto.getStatus());

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemRequestDTO itemDto : dto.getOrderItems()) {
            Item item = itemRepository.findById(itemDto.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item com ID " + itemDto.getItemId() + " não encontrado"));

            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setOrder(order);
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setUnitPrice(itemDto.getUnitPrice());

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);

        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateOrder(Long orderId, UpdateOrderRequestDTO dto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        order.setStatus(dto.getStatus());

        // Limpa os OrderItems antigos
        order.getOrderItems().clear();

        // Adiciona os novos OrderItems
        for (OrderItemRequestDTO itemDto : dto.getOrderItems()) {
            Item item = itemRepository.findById(itemDto.getItemId())
                    .orElseThrow(() -> new RuntimeException("Item com ID " + itemDto.getItemId() + " não encontrado"));

            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setOrder(order);
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setUnitPrice(itemDto.getUnitPrice());

            order.getOrderItems().add(orderItem);
        }

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    private OrderResponseDTO mapToResponseDTO(Order order) {
        List<OrderItemResponseDTO> itemDTOs = order.getOrderItems().stream().map(orderItem -> {
            return new OrderItemResponseDTO(
                    orderItem.getItem().getId(),
                    orderItem.getItem().getName(),
                    orderItem.getQuantity(),
                    orderItem.getUnitPrice()
            );
        }).toList();

        return new OrderResponseDTO(order.getId(), order.getStatus(), itemDTOs);
    }
}
