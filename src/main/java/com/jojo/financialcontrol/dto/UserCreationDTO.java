package com.jojo.financialcontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationDTO {

    @Size(min = 4, max = 255)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Size(min = 8, max = 255)
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Size(min = 8, max = 255)
    @NotBlank(message = "Email is mandatory")
    private String email;

}
