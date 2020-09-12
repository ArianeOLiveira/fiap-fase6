package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import com.google.common.collect.ImmutableSet;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Locale;
import java.util.Set;

@EqualsAndHashCode
@Embeddable
@Getter
public class Country implements ValueObject<Country> {
    public static final Set<String> ISO_COUNTRIES = ImmutableSet.copyOf(Locale.getISOCountries());

    @Column(name = "country")
    private String value;

    protected Country() {}

    private Country(String value) {
        this.value = value;
    }

    public static Country code(String value) {
        return new Country(value.trim().toUpperCase());
    }

    @Override
    public boolean sameValueAs(Country other) {
        return other != null && other.equals(this);
    }

    @Override
    public String toString() {
        return value;
    }
}

