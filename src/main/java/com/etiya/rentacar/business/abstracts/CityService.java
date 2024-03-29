package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.car.UpdateCarRequest;
import com.etiya.rentacar.business.dtos.requests.city.CreateCityRequest;
import com.etiya.rentacar.business.dtos.requests.city.UpdateCityRequest;
import com.etiya.rentacar.business.dtos.responses.car.UpdatedCarResponse;
import com.etiya.rentacar.business.dtos.responses.city.*;

import java.util.List;

public interface CityService {

    GetCityResponse getById(int id);
    List<GetListCityResponse> findAll();
    CreatedCityResponse add(CreateCityRequest createCityRequest);
    UpdatedCityResponse update(UpdateCityRequest updateCarRequest);
    DeletedCityResponse delete(int id);

}
