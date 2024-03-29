package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.rental.CreateRentalRequest;
import com.etiya.rentacar.business.dtos.requests.rental.UpdateRentalRequest;
import com.etiya.rentacar.business.dtos.responses.rental.*;
import com.etiya.rentacar.entities.Rental;

import java.util.List;

public interface RentalService {
    CreatedRentalResponse add(CreateRentalRequest createRentalRequest);
    UpdatedRentalResponse update(UpdateRentalRequest updateRentalRequest);
    GetRentalResponse getById(int id);
    List<GetListRentalResponse> getAll();
    public DeletedRentalResponse delete(int id);
    public Rental findById(int id);
    public void checkIfCarState(int carId);
}
