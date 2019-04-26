package com.example.demo.Transformers;

import com.example.demo.entity.Nota;
import com.example.demo.modelo.MNota;
import io.vavr.collection.List;
import org.springframework.stereotype.Component;

@Component("convertidor")
public class Transformers {

    public MNota notaFromMnota(Nota nota) {
        return new MNota(nota.getId(),
                nota.getNombre(),
                nota.getTitulo(),
                nota.getContenido());
    }

    public List<MNota> mNotaFromNota(List<Nota> listNota) {
        return listNota.map(nota -> notaFromMnota(nota));
    }

}