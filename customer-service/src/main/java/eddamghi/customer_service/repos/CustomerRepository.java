package eddamghi.customer_service.repos;

import eddamghi.customer_service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
