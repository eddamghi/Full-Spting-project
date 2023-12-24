package eddamghi.order_service.repos;

import eddamghi.order_service.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
