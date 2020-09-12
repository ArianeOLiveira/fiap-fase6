package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@EqualsAndHashCode
@Embeddable
@Getter
@ToString
public class Address implements ValueObject<Address> {
    private String street;
    private String streetNumber;
    private String complement;

    @Embedded
    private District district;

    @Embedded
    private City city;

    @Embedded
    private State state;

    @Embedded
    private Country country;

    @Embedded
    private ZipCode zipCode;

    protected Address(){}

    private Address(String street,
                    String streetNumber,
                    String complement,
                    District district,
                    City city,
                    State state,
                    Country country,
                    ZipCode zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public static Address create(String street,
                                 String streetNumber,
                                 String complement,
                                 District district,
                                 City city,
                                 State state,
                                 Country country,
                                 ZipCode zipCode) {
        return new Address(
                street,
                streetNumber,
                complement,
                district,
                city,
                state,
                country,
                zipCode
        );
    }

    @Override
    public boolean sameValueAs(Address other) {
        return other != null && other.equals(this);
    }
}
