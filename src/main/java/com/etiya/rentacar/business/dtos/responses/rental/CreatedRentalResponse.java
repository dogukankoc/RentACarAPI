package com.etiya.rentacar.business.dtos.responses.rental;

import com.etiya.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedRentalResponse {
    private int carId;
    private String plate;
    private String brandName;
    private String modelName;
    private String modelYear;
    private String transmissionName;
    private String fuelName;
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
    private int rentStartKilometer;
    private LocalDateTime createdDate;
}
