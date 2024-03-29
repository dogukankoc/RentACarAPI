package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.*;

import java.util.List;

public interface RentalBranchService {

    CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest);
    GetRentalBranchResponse getById(int id);
    List<GetRentalBranchListResponse> getAll();
    UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest);
    DeletedRentalBranchResponse delete(int id);
}
