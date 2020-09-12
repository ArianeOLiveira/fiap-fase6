package br.com.nubank.customer.domain.customer.events;

import br.com.nubank.customer.domain.customer.Customer;
import br.com.nubank.customer.domain.shared.DomainEvent;
import lombok.Getter;

@Getter
public class CustomerVerified extends DomainEvent {
    private Customer customer;

    public CustomerVerified(Customer customer) {
        super(customer);
        this.customer = customer;
    }
}
