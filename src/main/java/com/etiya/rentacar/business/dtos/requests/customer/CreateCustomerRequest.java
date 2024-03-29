package com.etiya.rentacar.business.dtos.requests.customer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerRequest {
    @NotBlank(message = "Customer user name cannot be only spaces")
    @NotEmpty(message = "Customer user name cannot be empty")
    @Size(min = 2, max = 30, message = "Size out of range")
    private String userName;
    @NotBlank(message = "Customer first name cannot be only spaces")
    @NotEmpty(message = "Customer first name cannot be empty")
    @Size(min = 2, max = 30, message = "Size out of range")
    private String firstName;
    @NotBlank(message = "Customer last name cannot be only spaces")
    @NotEmpty(message = "Customer last name cannot be empty")
    @Size(min = 2, max = 30, message = "Size out of range")
    private String lastName;
    @NotBlank(message = "Customer national identity cannot be only spaces")
    @NotEmpty(message = "Customer national identity name cannot be empty")
    @Size(min = 2, max = 30, message = "Size out of range")
    private String nationalId;
    @NotBlank(message = "Customer email cannot be only spaces")
    @NotEmpty(message = "Customer email cannot be empty")
    @Email(message = "Not a valid email address")
    private String email;
    @NotBlank(message = "Customer password cannot be only spaces")
    @NotEmpty(message = "Customer password cannot be empty")
    @Size(min = 4, max = 30, message = "Size out of range")
    private String password;
    @NotBlank(message = "Customer company name cannot be only spaces")
    @NotEmpty(message = "Customer company name cannot be empty")
    @Size(min = 2, max = 30, message = "Size out of range")
    private String companyName;
}
