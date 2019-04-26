package com.example.demo.repository;

import com.example.demo.entity.Nota;
import io.vavr.collection.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("repositorio")
public interface NotasRepository extends JpaRepository<Nota, Serializable> {
    public abstract Nota findByNombre(String nombre);
    public abstract List<Nota> findByTitulo(String titulo);
    public abstract Nota findByTituloAndNombre(String nombre, String titulo );
}
