package br.com.nubank.customer.application.device;

import br.com.nubank.customer.domain.device.Device;

public interface DeviceService {
    Device get(Long id);
    Device verify(Long id);
    Device create(String name, Long customer);
    void delete(Long id);
}
