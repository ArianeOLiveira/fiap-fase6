package br.com.nubank.customer.domain.device.events;

import br.com.nubank.customer.domain.device.Device;
import br.com.nubank.customer.domain.shared.DomainEvent;
import lombok.Getter;

@Getter
public class DeviceRegistered extends DomainEvent {
    private Device device;

    public DeviceRegistered(Device device) {
        super(device);
        this.device = device;
    }
}
