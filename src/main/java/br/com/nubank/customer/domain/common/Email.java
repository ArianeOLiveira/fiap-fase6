package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class Email implements ValueObject<Email> {
    @Column(name = "email")
    private String address;

    protected Email() {}

    private Email(String address) {
        this.address = address;
    }

    public static Email create(String address) {
        return new Email(address);
    }

    @Override
    public boolean sameValueAs(Email other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return address;
    }
}

