package com.example.backend.dto;

import com.example.backend.model.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class UserViewDTO implements Serializable {

    private static final long serialVersionUID=1L;

    private final String ruc;
    private final String razonSocial;
    private final String direccion;
    private final Boolean estado;

    private UserViewDTO( String ruc,String razonSocial, String direccion, Boolean estado) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.estado = estado;

    }

    public static UserViewDTO of(User user){
        return new UserViewDTO( user.getRuc(),user.getRazonSocial(), user.getDireccion(), user.getEstado());
    }
}
