package br.com.nubank.customer.domain.device.events;

import br.com.nubank.customer.domain.device.Device;
import br.com.nubank.customer.domain.shared.DomainEvent;
import lombok.Getter;

@Getter
public class DeviceVerified extends DomainEvent {
    private Device device;

    public DeviceVerified(Device device) {
        super(device);
        this.device = device;
    }
}
