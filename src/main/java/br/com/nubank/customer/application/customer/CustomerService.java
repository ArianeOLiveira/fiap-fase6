package br.com.nubank.customer.application.customer;

import br.com.nubank.customer.domain.customer.Customer;
import br.com.nubank.customer.presentation.controllers.customer.request.RegisterCustomerRequest;

public interface CustomerService {
    Customer get(Long id);
    Customer verify(Long id);
    Customer create(RegisterCustomerRequest request);
    void delete(Long id);
}
