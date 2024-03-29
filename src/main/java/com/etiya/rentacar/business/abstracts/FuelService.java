package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuel.*;
import com.etiya.rentacar.entities.Fuel;

import java.util.List;

public interface FuelService {

    CreatedFuelResponse add(CreateFuelRequest createFuelRequest);

    UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest);
    GetFuelResponse getById(int id);

    List<GetFuelListResponse> getAll();
    DeletedFuelResponse delete(int id);
    public Fuel findById(int id);

}
