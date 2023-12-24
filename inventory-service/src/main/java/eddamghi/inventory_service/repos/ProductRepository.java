package eddamghi.inventory_service.repos;

import eddamghi.inventory_service.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
