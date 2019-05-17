package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    @Setter @Getter
    private long id;
    @Column(name = "USUARIO")
    @Setter @Getter
    private String usuario;
    @Column(name = "CONTRASENA")
    @Setter @Getter
    private String contrasena;
    @Setter @Getter
    @Column(name = "ROL")
    private byte rol  ;
    @Setter @Getter
    @Column(name = "activo")
    private boolean activo;
}
