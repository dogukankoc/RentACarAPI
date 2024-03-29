package com.etiya.rentacar.dataAccess.abstracts;

import com.etiya.rentacar.entities.Rental;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
