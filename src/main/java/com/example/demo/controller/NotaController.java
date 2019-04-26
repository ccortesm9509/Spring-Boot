package com.example.demo.controller;

import com.example.demo.entity.Nota;
import com.example.demo.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class NotaController {

    @Autowired
    @Qualifier("servicio")
    NotaService service;

    @PutMapping("/nota")
    public Nota agregarNota(@RequestBody @Valid Nota nota){
        return service.crear(nota);
    }
}
