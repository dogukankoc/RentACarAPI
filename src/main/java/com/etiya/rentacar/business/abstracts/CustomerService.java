package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.customer.*;
import com.etiya.rentacar.entities.Customer;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);
    GetCustomerResponse getById(int id);

    List<GetListCustomerResponse> getAll();

    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);

    DeletedCustomerResponse delete(int id);

    public Customer findById (int id);
}
