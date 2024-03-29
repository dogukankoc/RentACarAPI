package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.CustomerService;
import com.etiya.rentacar.business.dtos.requests.customer.CreateCustomerRequest;
import com.etiya.rentacar.business.dtos.requests.customer.UpdateCustomerRequest;
import com.etiya.rentacar.business.dtos.responses.brand.DeletedBrandResponse;
import com.etiya.rentacar.business.dtos.responses.city.DeletedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetListCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.UpdatedCityResponse;
import com.etiya.rentacar.business.dtos.responses.customer.*;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.CreatedRentalBranchResponse;
import com.etiya.rentacar.business.rules.CustomerBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.CustomerRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.City;
import com.etiya.rentacar.entities.Customer;
import com.etiya.rentacar.entities.RentalBranch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private ModelMapperService modelMapperService;
    private CustomerRepository customerRepository;
    private CustomerBusinessRules customerBusinessRules;
    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        customerBusinessRules.customerEmailCannotBeDuplicated(createCustomerRequest.getEmail());
        Customer mappedCustomer = modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        Customer createdCustomer = customerRepository.save(mappedCustomer);
        return modelMapperService.forResponse().map(createdCustomer, CreatedCustomerResponse.class);
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        customerBusinessRules.customerIdIsExist(updateCustomerRequest.getId());
        customerBusinessRules.customerEmailCannotBeDuplicated(updateCustomerRequest.getEmail());
        Customer customer = findById(updateCustomerRequest.getId());
        Customer mappedCustomer = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        mappedCustomer.setCreatedDate(customer.getCreatedDate());
        mappedCustomer.setUpdatedDate(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(mappedCustomer);
        return modelMapperService.forResponse().map(savedCustomer, UpdatedCustomerResponse.class);
    }

    @Override
    public GetCustomerResponse getById(int id) {
        customerBusinessRules.customerIdIsExist(id);
        customerBusinessRules.customerHasBeenDeleted(id);
        Customer customer = findById(id);
        return modelMapperService.forResponse().map(customer, GetCustomerResponse.class);
    }

    @Override
    public List<GetListCustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().filter(customer -> customer.getDeletedDate() == null)
                .map(customer -> modelMapperService.forResponse()
                        .map(customer, GetListCustomerResponse.class)).collect(Collectors.toList());
    }

    @Override
    public DeletedCustomerResponse delete(int id) {
        customerBusinessRules.customerIdIsExist(id);
        customerBusinessRules.customerHasBeenDeleted(id);
        Customer customer = findById(id);
        customer.setDeletedDate(LocalDateTime.now());
        Customer deletedCustomer = customerRepository.save(customer);
        return modelMapperService.forResponse().map(deletedCustomer, DeletedCustomerResponse.class);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
}
