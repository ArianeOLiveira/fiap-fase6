package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class Year implements ValueObject<Year> {
    @Column(name = "year")
    private int value;

    protected Year() {}

    private Year(int value) {
        this.value = value;
    }

    public static Year is(int value) {
        var valueString = String.valueOf(value);

        if (valueString.length() != 2)
            throw new IllegalArgumentException("Year is invalid. Ex: 22");

        return new Year(value);
    }

    public static Year is(String value) {
        return is(Integer.valueOf(value));
    }

    @Override
    public boolean sameValueAs(Year other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

