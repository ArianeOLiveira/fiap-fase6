package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;

@EqualsAndHashCode
@Embeddable
@Getter
public class Phone implements ValueObject<Phone> {
	private String countryCode;
	private String areaCode;
	private String number;

	protected Phone(){}

	private Phone(String countryCode,
				 String areaCode,
				 String number) {
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}

	public static Phone create(String countryCode,
							   String areaCode,
							   String number) {
		return new Phone(
				countryCode,
				areaCode,
				number
		);
	}

	@Override
	public boolean sameValueAs(Phone other) {
		return other != null && other.equals(this);
	}

	public String getFormattedPhone(){
		return "+" + countryCode + "(" + areaCode + ")" + number;
	}

	@Override
	public String toString() {
		return getFormattedPhone();
	}
}
