package br.com.nubank.customer.presentation.controllers.customer.request;

import br.com.nubank.customer.domain.common.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterCustomerRequest {
    private FullName name;
    private String cpf;
    private Email email;
    private BirthDate birthDate;
    private Phone phone;
    private Address address;
}
