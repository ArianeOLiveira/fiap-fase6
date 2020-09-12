package br.com.nubank.customer.presentation.controllers.customer;

import br.com.nubank.customer.application.customer.CustomerService;
import br.com.nubank.customer.domain.customer.Customer;
import br.com.nubank.customer.presentation.controllers.customer.request.RegisterCustomerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController()
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Customer> register(
            @RequestBody RegisterCustomerRequest request) {
        var dto = customerService.create(request);

        var location = URI.create("/customer/");

        return ResponseEntity
                .created(location)
                .body(dto);
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<Customer> get(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.get(id));
    }

    @DeleteMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<?> delete(
            @PathVariable("id") Long id) {
        customerService.delete(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/id/{id}/verify", produces = "application/json")
    public ResponseEntity<Customer> verify(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(customerService.verify(id));
    }
}
