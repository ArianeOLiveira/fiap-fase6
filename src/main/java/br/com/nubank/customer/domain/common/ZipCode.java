package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class ZipCode implements ValueObject<ZipCode> {
    @Column(name = "zipcode")
    private String value;

    protected ZipCode() {}

    private ZipCode(String value) {
        this.value = value;
    }

    public static ZipCode number(String value) {
        return new ZipCode(value.replace("-", ""));
    }

    public String formatted(){
        return value.contains("-") ? value : value.substring(0,5) + '-' + value.substring(5,8);
    }

    @Override
    public boolean sameValueAs(ZipCode other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return value;
    }
}

