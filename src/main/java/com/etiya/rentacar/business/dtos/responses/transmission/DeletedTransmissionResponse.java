package com.etiya.rentacar.business.dtos.responses.transmission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletedTransmissionResponse {
    private int id;

    private String name;

    private LocalDateTime deletedDate;
}
