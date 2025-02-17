package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.BrandService;
import com.etiya.rentacar.business.dtos.requests.brand.CreateBrandRequest;
import com.etiya.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.etiya.rentacar.business.dtos.responses.brand.*;
import com.etiya.rentacar.business.rules.BrandBusinessRules;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.BrandRepository;
import com.etiya.rentacar.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {

        brandBusinessRules.brandNameCannotBeDuplicated(createBrandRequest.getName());
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand savedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(savedBrand, CreatedBrandResponse.class);

    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        brandBusinessRules.brandNameCannotBeDuplicated(updateBrandRequest.getName());
        brandBusinessRules.brandIdIsExist(updateBrandRequest.getId());
        Brand brand = findById(updateBrandRequest.getId());

        Brand mappedBrand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class );
        mappedBrand.setUpdatedDate(LocalDateTime.now());
        mappedBrand.setCreatedDate(brand.getCreatedDate());
        Brand updatedBrand = brandRepository.save(mappedBrand);
        return modelMapperService.forResponse().map(updatedBrand, UpdatedBrandResponse.class);
    }

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().filter(brand -> brand.getDeletedDate() == null)
                .map(brand -> modelMapperService.forResponse()
                        .map(brand, GetBrandListResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetBrandResponse getById(int id) {
        brandBusinessRules.brandIdIsExist(id);
        brandBusinessRules.brandHasBeenDeleted(id);
        Brand brand = findById(id);
        return modelMapperService.forResponse().map(brand, GetBrandResponse.class);
    }
    @Override
    public DeletedBrandResponse delete(int id) {
        brandBusinessRules.brandIdIsExist(id);
        brandBusinessRules.brandHasBeenDeleted(id);
        Brand brand = findById(id);
        brand.setDeletedDate(LocalDateTime.now());
        Brand deletedBrand = brandRepository.save(brand);
        return modelMapperService.forResponse().map(deletedBrand, DeletedBrandResponse.class);
    }
    public Brand findById(int id) {
        brandBusinessRules.brandIdIsExist(id);
        return brandRepository.findById(id).get();
    }
}
