package com.example.demo.controller;

import com.example.demo.entity.Nota;
import com.example.demo.service.NotaService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class NotaController {

    private static final Log logger = LogFactory.getLog(NotaService.class);

    @Autowired
    @Qualifier("servicio")
    NotaService service;

    @PutMapping("/nota")
    public Nota agregarNota(@RequestBody @Valid Nota nota)
    {
        logger.info("La nota se esta guardando");
        return service.crear(nota);
    }

    @DeleteMapping("/nota/{id}/{nombre}")
    public Boolean borrarNota(@PathVariable("id") long id, @PathVariable("nombre") String nombre){
        return true;
    }
}
