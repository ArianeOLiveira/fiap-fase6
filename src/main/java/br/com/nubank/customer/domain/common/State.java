package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class State implements ValueObject<State> {
    @Column(name = "state")
    private String value;

    protected State(){}

    private State(String value) {
        this.value = value;
    }

    public static State name(String value) {
        return new State(value);
    }

    @Override
    public boolean sameValueAs(State other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return value;
    }
}

