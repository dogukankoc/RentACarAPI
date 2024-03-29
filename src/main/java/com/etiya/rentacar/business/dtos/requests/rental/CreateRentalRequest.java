package com.etiya.rentacar.business.dtos.requests.rental;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {
    private int carId;
    private int customerId;
    private LocalDate rentStartDate;
    private LocalDate rentEndDate;
}
