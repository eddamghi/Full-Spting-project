package eddamghi.customer_service.rest;

import eddamghi.customer_service.model.CustomerDTO;
import eddamghi.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(customerService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createCustomer(@RequestBody @Valid final CustomerDTO customerDTO) {
        final Long createdId = customerService.create(customerDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateCustomer(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final CustomerDTO customerDTO) {
        customerService.update(id, customerDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "id") final Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
