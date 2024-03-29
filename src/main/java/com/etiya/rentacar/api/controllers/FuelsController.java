package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuel.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/fuels")
public class FuelsController {

    private FuelService fuelService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetFuelListResponse> getAll() {

        return fuelService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetFuelResponse getById(@PathVariable int id) {

        return fuelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelResponse add(@Valid @RequestBody CreateFuelRequest createFuelRequest) {
        return fuelService.add(createFuelRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedFuelResponse update(@Valid @RequestBody UpdateFuelRequest updateFuelRequest) {
        return fuelService.update(updateFuelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedFuelResponse delete(@PathVariable int id) {

        return fuelService.delete(id);
    }
}
