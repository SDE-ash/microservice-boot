package com.child.customer_service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {

    @NotBlank(message = "field cannot be empty")
    private String firstName;

    @NotBlank(message = "field cannot be empty")
    private String lastName;

    @NotBlank(message = "email not be kept blank")
    @Email(message = "Email should be a valid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Invalid email format")
    private String email;
}
