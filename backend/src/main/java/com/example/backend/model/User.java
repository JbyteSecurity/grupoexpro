package com.example.backend.model;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @Column(name = "ruc",nullable = false,length = 50,unique = true)
    private String ruc;

    @Column(name = "razonSocial",nullable = false,length = 50)
    private String razonSocial;

    @Column(name = "direccion",nullable = false,length = 50)
    private String direccion;

    @Column(name = "estado",nullable = false,length = 50)
    private Boolean estado;

    public User(String ruc,String razonSocial, String direccion, Boolean estado) {
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.ruc=ruc;
        this.estado = estado;
    }
}
