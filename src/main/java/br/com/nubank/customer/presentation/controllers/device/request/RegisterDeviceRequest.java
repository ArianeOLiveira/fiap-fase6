package br.com.nubank.customer.presentation.controllers.device.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDeviceRequest {
    private String name;
    private Long customer;
}
