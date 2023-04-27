package com.example.backend.dto;



import com.example.backend.validator.UniqueUserName;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserCreateDTO {

    @NotNull(message = "{backend.constraints.ruc.NotNull.message}")
    @Size(min = 4, max = 24, message = "{backend.constraints.username.Size.message}")
    @UniqueUserName
    private String ruc;

    @NotNull(message = "{backend.constraints.razonSocial.NotNull.message}")
    @Size(min = 2, max = 32, message = "{backend.constraints.firstname.Size.message}")
    private String razonSocial;

    @NotNull(message = "{backend.constraints.direccion.NotNull.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.lastname.Size.message}")
    private String direccion;

    private Boolean estado;
}
