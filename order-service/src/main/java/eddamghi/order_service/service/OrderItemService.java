package eddamghi.order_service.service;

import eddamghi.order_service.domain.Order;
import eddamghi.order_service.domain.OrderItem;
import eddamghi.order_service.model.OrderItemDTO;
import eddamghi.order_service.repos.OrderItemRepository;
import eddamghi.order_service.repos.OrderRepository;
import eddamghi.order_service.util.NotFoundException;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    public OrderItemService(final OrderItemRepository orderItemRepository,
            final OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
    }

    public List<OrderItemDTO> findAll() {
        final List<OrderItem> orderItems = orderItemRepository.findAll(Sort.by("id"));
        return orderItems.stream()
                .map(orderItem -> mapToDTO(orderItem, new OrderItemDTO()))
                .toList();
    }

    public OrderItemDTO get(final Long id) {
        return orderItemRepository.findById(id)
                .map(orderItem -> mapToDTO(orderItem, new OrderItemDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final OrderItemDTO orderItemDTO) {
        final OrderItem orderItem = new OrderItem();
        mapToEntity(orderItemDTO, orderItem);
        return orderItemRepository.save(orderItem).getId();
    }

    public void update(final Long id, final OrderItemDTO orderItemDTO) {
        final OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(orderItemDTO, orderItem);
        orderItemRepository.save(orderItem);
    }

    public void delete(final Long id) {
        orderItemRepository.deleteById(id);
    }

    private OrderItemDTO mapToDTO(final OrderItem orderItem, final OrderItemDTO orderItemDTO) {
        orderItemDTO.setId(orderItem.getId());
        orderItemDTO.setQuantity(orderItem.getQuantity());
        orderItemDTO.setUnitPrice(orderItem.getUnitPrice());
        orderItemDTO.setDiscount(orderItem.getDiscount());
        orderItemDTO.setProductId(orderItem.getProductId());
        orderItemDTO.setOrder(orderItem.getOrder() == null ? null : orderItem.getOrder().getId());
        return orderItemDTO;
    }

    private OrderItem mapToEntity(final OrderItemDTO orderItemDTO, final OrderItem orderItem) {
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setUnitPrice(orderItemDTO.getUnitPrice());
        orderItem.setDiscount(orderItemDTO.getDiscount());
        orderItem.setProductId(orderItemDTO.getProductId());
        final Order order = orderItemDTO.getOrder() == null ? null : orderRepository.findById(orderItemDTO.getOrder())
                .orElseThrow(() -> new NotFoundException("order not found"));
        orderItem.setOrder(order);
        return orderItem;
    }

}
