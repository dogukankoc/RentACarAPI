package com.etiya.rentacar.business.dtos.requests.car;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    @NotNull
    private int id;
    @NotNull
    private int modelYear;
    @NotNull
    private String plate;
    @NotNull
    private int state;
    @NotNull
    private double dailyPrice;
    @NotNull
    private int modelId;
    @NotNull
    private double kilometer;
}
