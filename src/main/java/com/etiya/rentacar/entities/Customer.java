package com.etiya.rentacar.entities;

import com.etiya.rentacar.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customers")
public class Customer extends BaseEntity {

    @Column(name = "userName")
    private String userName;
    @Column(name = "nationalId")
    private String nationalId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email", unique = true) //Db kolonuna unique özelliği atadık,
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "companyName")
    private String companyName;

    @OneToMany(mappedBy="customer")
    private List<Rental> rentals;



}
