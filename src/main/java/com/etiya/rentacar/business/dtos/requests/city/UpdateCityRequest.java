package com.etiya.rentacar.business.dtos.requests.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCityRequest {

    private int id;

    @NotBlank(message = "City name cannot be blank")
    @NotEmpty(message = "City name cannot be empty")
    @Size(min = 2, max = 30)
    private String name;
}
