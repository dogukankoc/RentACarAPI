package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.transmission.CreateTranmissionRequest;
import com.etiya.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.brand.*;
import com.etiya.rentacar.business.dtos.responses.transmission.*;
import com.etiya.rentacar.business.rules.TransmissionBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    private TransmissionBusinessRules transmissionBusinessRules;

    @Override
    public CreatedTransmissionResponse add(CreateTranmissionRequest createTransmissionRequest) {
        transmissionBusinessRules.transmissionNameCannotBeDuplicated(createTransmissionRequest.getName());
        Transmission transmission = modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        Transmission savedTransmission = transmissionRepository.save(transmission);
        return modelMapperService.forResponse().map(savedTransmission, CreatedTransmissionResponse.class);
    }

    @Override
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        transmissionBusinessRules.transmissionNameCannotBeDuplicated(updateTransmissionRequest.getName());
        transmissionBusinessRules.transmissionIdIsExist(updateTransmissionRequest.getId());
        Transmission transmission = findById(updateTransmissionRequest.getId());
        Transmission mappedTransmission = modelMapperService.forRequest().map(updateTransmissionRequest, Transmission.class);
        mappedTransmission.setCreatedDate(transmission.getCreatedDate());
        mappedTransmission.setUpdatedDate(LocalDateTime.now());
        Transmission updatedTransmission = transmissionRepository.save(mappedTransmission);
        return modelMapperService.forResponse().map(updatedTransmission, UpdatedTransmissionResponse.class);
    }

    @Override
    public List<GetTranmissionListResponse> getAll() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        return transmissions.stream().filter(transmission -> transmission.getDeletedDate() == null)
                .map(transmission -> modelMapperService.forResponse()
                        .map(transmission, GetTranmissionListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetTranmissionResponse getById(int id) {
        transmissionBusinessRules.transmissionIdIsExist(id);
        transmissionBusinessRules.transmissionHasBeenDeleted(id);
        Transmission transmission = findById(id);
        return modelMapperService.forResponse().map(transmission, GetTranmissionResponse.class);
    }


    @Override
    public DeletedTransmissionResponse delete(int id) {
        transmissionBusinessRules.transmissionIdIsExist(id);
        transmissionBusinessRules.transmissionHasBeenDeleted(id);
        Transmission transmission = findById(id);
        transmission.setDeletedDate(LocalDateTime.now());
        Transmission deletedTransmission = transmissionRepository.save(transmission);
        return modelMapperService.forResponse().map(deletedTransmission, DeletedTransmissionResponse.class);
    }

    private Transmission findById(int id) {
        transmissionBusinessRules.transmissionIdIsExist(id);
        return transmissionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transmission not found"));
    }
}


