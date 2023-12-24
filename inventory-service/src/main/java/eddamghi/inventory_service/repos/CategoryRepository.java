package eddamghi.inventory_service.repos;

import eddamghi.inventory_service.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
