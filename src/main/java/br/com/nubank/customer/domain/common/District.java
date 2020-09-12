package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class District implements ValueObject<District> {
    @Column(name = "district")
    private String value;

    protected District() {}

    private District(String value) {
        this.value = value;
    }

    public static District name(String value) {
        return new District(value);
    }

    @Override
    public boolean sameValueAs(District other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return value;
    }
}

