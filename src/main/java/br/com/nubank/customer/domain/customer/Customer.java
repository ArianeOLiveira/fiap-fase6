package br.com.nubank.customer.domain.customer;

import br.com.nubank.customer.domain.common.*;
import br.com.nubank.customer.domain.customer.events.CustomerRegistered;
import br.com.nubank.customer.domain.customer.events.CustomerVerified;
import br.com.nubank.customer.domain.shared.AggregateRootBase;
import br.com.nubank.customer.presentation.controllers.customer.request.RegisterCustomerRequest;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Entity(name = "customer")
public class Customer extends AggregateRootBase<Customer> {
    @Id
    @GeneratedValue
    private Long id;
    private FullName name;
    private LocalDateTime createdAt;
    private Boolean verified;
    private LocalDateTime updateAt;
    private String cpf;
    private Email email;
    private BirthDate birthDate;
    private Phone phone;
    private Address address;

    protected Customer() { }

    private Customer(FullName name,
                     String cpf,
                     Email email,
                     BirthDate birthDate,
                     Phone phone,
                     Address address) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.createdAt = LocalDateTime.now();
        this.verified = false;
        this.updateAt = LocalDateTime.now();
        registerEvent(new CustomerRegistered(this));
    }

    public static Customer of(RegisterCustomerRequest request) {
        return new Customer(request.getName(), request.getCpf(), request.getEmail(),
                request.getBirthDate(), request.getPhone(), request.getAddress());
    }

    public void verify() {
        if(!canVerify())
            throw new RuntimeException("Can't verify this device");

        this.verified = true;
        registerEvent(new CustomerVerified(this));
    }

    public Boolean canVerify(){
        return this.verified.equals(false);
    }

    @Override
    public boolean sameIdentityAs(Customer other) {
        return this.equals(other);
    }
}
