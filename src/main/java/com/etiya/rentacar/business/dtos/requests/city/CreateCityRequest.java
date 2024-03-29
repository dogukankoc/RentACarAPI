package com.etiya.rentacar.business.dtos.requests.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCityRequest {
    @NotEmpty(message = "name is not empty")
    @NotBlank(message = "name is not only spaces")
    private String name;
}
