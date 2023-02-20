package com.jojo.financialcontrol.to;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Email is mandatory")
    private String email;

}
