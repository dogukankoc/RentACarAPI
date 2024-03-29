package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.RentalBranchService;
import com.etiya.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.model.UpdateModelRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.customer.DeletedCustomerResponse;
import com.etiya.rentacar.business.dtos.responses.model.UpdatedModelResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.*;
import com.etiya.rentacar.business.dtos.responses.transmission.GetTranmissionListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/rentalBranches")
public class RentalBranchesController {
    private RentalBranchService rentalBranchService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreatedRentalBranchResponse add(@Valid @RequestBody CreateRentalBranchRequest createRentalBranchRequest){

        return rentalBranchService.add(createRentalBranchRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    GetRentalBranchResponse getById(@PathVariable int id){

        return rentalBranchService.getById(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetRentalBranchListResponse> getAll(){

        return rentalBranchService.getAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedRentalBranchResponse update(@RequestBody UpdateRentalBranchRequest updateRentalBranchRequest){
        return rentalBranchService.update(updateRentalBranchRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeletedRentalBranchResponse delete(@PathVariable int id) {

        return rentalBranchService.delete(id);
    }
}
