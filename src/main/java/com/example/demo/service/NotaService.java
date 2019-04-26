package com.example.demo.service;

import com.example.demo.entity.Nota;
import com.example.demo.repository.NotasRepository;
import io.vavr.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicio")
public class NotaService {
    @Autowired
    @Qualifier("repositorio")
    private NotasRepository repository;

    public Nota crear (Nota nota) {
       return repository.save(nota);
    }

    public List<Nota> obtenerTodos() {
        return List.ofAll(repository.findAll());
    }

}
