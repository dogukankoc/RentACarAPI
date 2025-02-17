package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brand.*;
import com.etiya.rentacar.entities.Brand;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest brand);
    UpdatedBrandResponse update(UpdateBrandRequest brand);
    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    DeletedBrandResponse delete(int id);
}
