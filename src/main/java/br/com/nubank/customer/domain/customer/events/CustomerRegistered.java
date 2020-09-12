package br.com.nubank.customer.domain.customer.events;

import br.com.nubank.customer.domain.customer.Customer;
import br.com.nubank.customer.domain.shared.DomainEvent;
import lombok.Getter;

@Getter
public class CustomerRegistered extends DomainEvent {
    private Customer customer;

    public CustomerRegistered(Customer customer) {
        super(customer);
        this.customer = customer;
    }
}
