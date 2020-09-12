package br.com.nubank.customer.domain.common;

import br.com.nubank.customer.domain.shared.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@EqualsAndHashCode
@Embeddable
@Getter
public class BirthDate implements ValueObject<BirthDate> {
    public static final BirthDate fixed01011900 = new BirthDate(LocalDate.of(1900,1,1));
    public static final String PATTERN = "yyyy-MM-dd";

    @DateTimeFormat(pattern = PATTERN)
    @Column(name = "birthdate")
    private LocalDate value;

    protected BirthDate(){}

    private BirthDate(LocalDate value) {
        this.value = value;
    }

    public static BirthDate was(LocalDate value) {
        return new BirthDate(value);
    }

    @Override
    public boolean sameValueAs(BirthDate other) {
        return other != null && other.equals(this);
    }
    
    @Override
    public String toString() {
    	return getFormattedDate();
    }

    public String getFormattedDate() {
    	var formatter = DateTimeFormatter.ofPattern(PATTERN);
        return formatter.format(value);
    }

    public Date getDate(){
        return Date.valueOf(value);
    }
}

