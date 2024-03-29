package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.BrandMessages;
import com.etiya.rentacar.business.messages.CustomerMessages;
import com.etiya.rentacar.core.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.CustomerRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
    public void customerEmailCannotBeDuplicated(String customerEmail){
        Optional<Customer> customer = customerRepository.findByEmailIgnoreCase(customerEmail.trim());

        if(customer.isPresent()){
            throw new BusinessException(CustomerMessages.duplicateEmail);
        }
    }

    public void customerIdIsExist(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new BusinessException(CustomerMessages.customerIdIsExist);
        }
    }

    public void customerHasBeenDeleted(int id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.get().getDeletedDate() != null) {
            throw new BusinessException(CustomerMessages.customerHasBeenDeleted);
        }
    }
}
