package com.etiya.rentacar.business.dtos.requests.transmission;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTranmissionRequest {

    @NotBlank(message = "Transmission name cannot be only spaces")
    @NotEmpty(message = "Transmission name cannot be empty")
    @Size(min = 2, max = 30, message = "Size out of range")
    private String name;

}
