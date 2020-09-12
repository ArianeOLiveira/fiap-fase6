package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class FullName implements ValueObject<FullName> {
    @Column(name = "fullname")
    private String value;

    protected FullName(){}

    private FullName(String value) {
        this.value = value;
    }

    public static FullName is(String value) {
        return new FullName(value);
    }

    @Override
    public boolean sameValueAs(FullName other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return value;
    }
}

