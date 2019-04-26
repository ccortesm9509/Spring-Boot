package com.example.demo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Table(name = "NOTA")
@Entity
public class Nota implements Serializable {
    @GeneratedValue
    @Id
    @Column(name = "idnota")
    @Getter @Setter
    private long id;
    @Column(name = "NombreNota")
    @Getter @Setter
    private String nombre;
    @Column(name = "TituloNota")
    @Getter @Setter
    private String titulo;
    @Column(name = "ContenidoNota")
    @Getter @Setter
    private String contenido;
}
