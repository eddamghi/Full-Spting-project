package eddamghi.order_service.repos;

import eddamghi.order_service.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
