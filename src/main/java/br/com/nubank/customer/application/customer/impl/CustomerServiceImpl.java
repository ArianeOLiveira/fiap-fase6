package br.com.nubank.customer.application.customer.impl;

import br.com.nubank.customer.application.customer.CustomerService;
import br.com.nubank.customer.domain.customer.Customer;
import br.com.nubank.customer.domain.customer.CustomerRepository;
import br.com.nubank.customer.infrastructure.http.NotFoundException;
import br.com.nubank.customer.presentation.controllers.customer.request.RegisterCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer get(Long id) {
        var customerExistis = customerRepository.findById(id);

        if (!customerExistis.isPresent())
            throw new NotFoundException();

        return customerExistis.get();
    }

    @Override
    public Customer verify(Long id) {
        var customerExistis = customerRepository.findById(id);

        if (!customerExistis.isPresent())
            throw new NotFoundException();

        var customer = customerExistis.get();
        customer.verify();
        customerRepository.save(customer);

        return customer;
    }

    @Override
    public Customer create(RegisterCustomerRequest request) {
        var customer = Customer.of(request);
        customerRepository.save(customer);

        return customer;
    }

    @Override
    public void delete(Long id) {
        var customerExistis = customerRepository.findById(id);

        if(!customerExistis.isPresent())
            throw new NotFoundException();

        var customer = customerExistis.get();
        customerRepository.delete(customer);
    }
}
