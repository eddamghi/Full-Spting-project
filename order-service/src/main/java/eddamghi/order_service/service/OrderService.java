package eddamghi.order_service.service;

import eddamghi.order_service.domain.Order;
import eddamghi.order_service.model.OrderDTO;
import eddamghi.order_service.repos.OrderRepository;
import eddamghi.order_service.util.NotFoundException;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> findAll() {
        final List<Order> orders = orderRepository.findAll(Sort.by("id"));
        return orders.stream()
                .map(order -> mapToDTO(order, new OrderDTO()))
                .toList();
    }

    public OrderDTO get(final Long id) {
        return orderRepository.findById(id)
                .map(order -> mapToDTO(order, new OrderDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final OrderDTO orderDTO) {
        final Order order = new Order();
        mapToEntity(orderDTO, order);
        return orderRepository.save(order).getId();
    }

    public void update(final Long id, final OrderDTO orderDTO) {
        final Order order = orderRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(orderDTO, order);
        orderRepository.save(order);
    }

    public void delete(final Long id) {
        orderRepository.deleteById(id);
    }

    private OrderDTO mapToDTO(final Order order, final OrderDTO orderDTO) {
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setDeliveryDate(order.getDeliveryDate());
        orderDTO.setDeliveryAddress(order.getDeliveryAddress());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setCustomerId(order.getCustomerId());
        return orderDTO;
    }

    private Order mapToEntity(final OrderDTO orderDTO, final Order order) {
        order.setOrderDate(orderDTO.getOrderDate());
        order.setDeliveryDate(orderDTO.getDeliveryDate());
        order.setDeliveryAddress(orderDTO.getDeliveryAddress());
        order.setStatus(orderDTO.getStatus());
        order.setCustomerId(orderDTO.getCustomerId());
        return order;
    }

}
