package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.BrandMessages;
import com.etiya.rentacar.business.messages.FuelMessages;
import com.etiya.rentacar.core.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.FuelRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FuelBusinessRules {
    private FuelRepository fuelRepository;

    public void fuelNameCannotBeDuplicated(String fuelName) {
        Optional<Fuel> fuel = fuelRepository.findByNameIgnoreCase(fuelName.trim());
        if (fuel.isPresent()) {
            throw new BusinessException(FuelMessages.duplicateName);
        }
    }
    public void fuelIdIsExist(int id) {
        Optional<Fuel> fuel = fuelRepository.findById(id);
        if (fuel.isEmpty()) {
            throw new BusinessException(FuelMessages.fuelIdIsExist);
        }
    }
    public void fuelHasBeenDeleted(int id){
        Optional<Fuel> fuel = fuelRepository.findById(id);
        if(fuel.get().getDeletedDate() != null) {
            throw new BusinessException(FuelMessages.fuelHasBeenDeleted);
        }
    }
}