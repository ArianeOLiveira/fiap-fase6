package br.com.nubank.customer.domain.device;

import br.com.nubank.customer.domain.customer.Customer;
import br.com.nubank.customer.domain.device.events.DeviceRegistered;
import br.com.nubank.customer.domain.device.events.DeviceVerified;
import br.com.nubank.customer.domain.shared.AggregateRootBase;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Entity(name = "device")
public class Device extends AggregateRootBase<Device> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private Boolean verified;
    private LocalDateTime updateAt;

    @ManyToOne
    private Customer customer;

    protected Device(){}
    private Device(String name,
                   Customer customer) {
        this.name = name;
        this.customer = customer;
        this.createdAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.verified = false;
        registerEvent(new DeviceRegistered(this));
    }

    public static Device of(String name, Customer customer) {
        return new Device(name, customer);
    }

    public void verify() {
        if(!canVerify())
            throw new RuntimeException("Can't verify this device");

        this.verified = true;
        registerEvent(new DeviceVerified(this));
    }

    public Boolean canVerify(){
        return this.verified.equals(false);
    }

    @Override
    public boolean sameIdentityAs(Device other) {
        return this.equals(other);
    }
}
