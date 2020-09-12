package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class City implements ValueObject<City> {
    @Column(name = "city")
    private String value;

    protected City(){}

    private City(String value) {
        this.value = value;
    }

    public static City name(String value) {
        return new City(value);
    }

    @Override
    public boolean sameValueAs(City other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return value;
    }
}

