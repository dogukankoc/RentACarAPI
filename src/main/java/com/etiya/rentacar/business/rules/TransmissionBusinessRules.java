package com.etiya.rentacar.business.rules;

import com.etiya.rentacar.business.messages.BrandMessages;
import com.etiya.rentacar.business.messages.TransmissionMessages;
import com.etiya.rentacar.core.exceptions.types.BusinessException;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionBusinessRules {
    private TransmissionRepository transmissionRepository;

    public void transmissionNameCannotBeDuplicated(String transmissionName) {
        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(transmissionName.trim());
        if (transmission.isPresent()) {
            throw new BusinessException(TransmissionMessages.duplicateName);
        }
    }

    public void transmissionIdIsExist(int id) {
        Optional<Transmission> transmission = transmissionRepository.findById(id);
        if (transmission.isEmpty()) {
            throw new BusinessException(TransmissionMessages.transmissionIdIsExist);
        }
    }

    public void transmissionHasBeenDeleted(int id){
        Optional<Transmission> transmission = transmissionRepository.findById(id);
        if(transmission.get().getDeletedDate() != null) {
            throw new BusinessException(TransmissionMessages.transmissionHasBeenDeleted);
        }
    }

}
