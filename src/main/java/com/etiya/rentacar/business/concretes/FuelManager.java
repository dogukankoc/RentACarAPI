package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuel.*;
import com.etiya.rentacar.business.rules.FuelBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private FuelRepository fuelRepository;
    private ModelMapperService modelMapperService;
    private FuelBusinessRules fuelBusinessRules;

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.fuelNameCannotBeDuplicated(createFuelRequest.getName());
        Fuel mappedFuel = modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
        mappedFuel.setCreatedDate(LocalDateTime.now());
        Fuel createdFuel = fuelRepository.save(mappedFuel);
        return modelMapperService.forResponse().map(createdFuel, CreatedFuelResponse.class);
    }

    @Override
    public UpdatedFuelResponse update(UpdateFuelRequest updateFuelRequest) {
        fuelBusinessRules.fuelIdIsExist(updateFuelRequest.getId());
        fuelBusinessRules.fuelNameCannotBeDuplicated(updateFuelRequest.getName());
        Fuel mappedFuel = findById(updateFuelRequest.getId());
        mappedFuel.setName(updateFuelRequest.getName());
        mappedFuel.setUpdatedDate(LocalDateTime.now());
        Fuel updatedFuel = fuelRepository.save(mappedFuel);
        return modelMapperService.forResponse().map(updatedFuel, UpdatedFuelResponse.class);
    }

    @Override
    public GetFuelResponse getById(int id) {
        fuelBusinessRules.fuelIdIsExist(id);
        fuelBusinessRules.fuelHasBeenDeleted(id);
        Fuel fuel = findById(id);
        return modelMapperService.forResponse().map(fuel, GetFuelResponse.class);
    }

    @Override
    public List<GetFuelListResponse> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        return fuels.stream().filter(fuel -> fuel.getDeletedDate() == null)
                .map(fuel -> modelMapperService.forResponse()
                        .map(fuel, GetFuelListResponse.class)).collect(Collectors.toList());
    }


    @Override
    public DeletedFuelResponse delete(int id) {
        fuelBusinessRules.fuelIdIsExist(id);
        fuelBusinessRules.fuelHasBeenDeleted(id);
        Fuel fuel = findById(id);
        fuel.setDeletedDate(LocalDateTime.now());
        Fuel deletedFuel = fuelRepository.save(fuel);
        return modelMapperService.forResponse().map(deletedFuel, DeletedFuelResponse.class);
    }

    @Override
    public Fuel findById(int id) {
        fuelBusinessRules.fuelIdIsExist(id);
        return fuelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Fuel not found"));
    }
}
