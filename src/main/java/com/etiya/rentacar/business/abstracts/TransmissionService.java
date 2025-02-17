package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.transmission.CreateTranmissionRequest;
import com.etiya.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.transmission.*;
import com.etiya.rentacar.entities.Transmission;

import java.util.List;

public interface TransmissionService {

    CreatedTransmissionResponse add(CreateTranmissionRequest createTransmissionRequest);

    UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest);

    List<GetTranmissionListResponse> getAll();

    GetTranmissionResponse getById(int id);

    DeletedTransmissionResponse delete(int id);
}
