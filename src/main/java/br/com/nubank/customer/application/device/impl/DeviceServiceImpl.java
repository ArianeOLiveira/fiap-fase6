package br.com.nubank.customer.application.device.impl;

import br.com.nubank.customer.application.customer.CustomerService;
import br.com.nubank.customer.application.device.DeviceService;
import br.com.nubank.customer.domain.device.Device;
import br.com.nubank.customer.domain.device.DeviceRepository;
import br.com.nubank.customer.infrastructure.http.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;
    private final CustomerService customerService;

    public DeviceServiceImpl(DeviceRepository deviceRepository,
                             CustomerService customerService) {
        this.deviceRepository = deviceRepository;
        this.customerService = customerService;
    }

    @Override
    public Device get(Long id) {
        var deviceExists = deviceRepository.findById(id);

        if (!deviceExists.isPresent())
            throw new NotFoundException();

        return deviceExists.get();
    }

    @Override
    public Device verify(Long id) {
        var deviceExists = deviceRepository.findById(id);

        if (!deviceExists.isPresent())
            throw new NotFoundException();

        var device = deviceExists.get();
        device.verify();
        deviceRepository.save(device);

        return device;
    }

    @Override
    public Device create(String name, Long customerId) {
        var customer = customerService.get(customerId);

        var device = Device.of(name, customer);
        deviceRepository.save(device);

        return device;
    }

    @Override
    public void delete(Long id) {
        var deviceExists = deviceRepository.findById(id);

        if (!deviceExists.isPresent())
            throw new NotFoundException();

        var device = deviceExists.get();
        deviceRepository.delete(device);
    }
}
