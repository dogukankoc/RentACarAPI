package com.etiya.rentacar.business.dtos.requests.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

    @NotNull
    private String name;
    @NotNull
    private int brandId;
    @NotNull
    private int fuelId;
    @NotNull
    private int transmissionId;
}
