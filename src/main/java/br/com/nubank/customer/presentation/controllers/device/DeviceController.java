package br.com.nubank.customer.presentation.controllers.device;

import br.com.nubank.customer.application.device.DeviceService;
import br.com.nubank.customer.domain.device.Device;
import br.com.nubank.customer.presentation.controllers.device.request.RegisterDeviceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController()
@RequestMapping("/device")
public class DeviceController {
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Device> register(
            @RequestBody RegisterDeviceRequest request) {
        var dto = deviceService.create(request.getName(), request.getCustomer());

        var location = URI.create("/device/");

        return ResponseEntity
                .created(location)
                .body(dto);
    }

    @GetMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<Device> get(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(deviceService.get(id));
    }

    @DeleteMapping(value = "/id/{id}", produces = "application/json")
    public ResponseEntity<?> delete(
            @PathVariable("id") Long id) {
        deviceService.delete(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping(value = "/id/{id}/verify", produces = "application/json")
    public ResponseEntity<Device> verify(
            @PathVariable("id") Long id) {
        return ResponseEntity.ok(deviceService.verify(id));
    }
}
