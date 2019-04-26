package com.example.demo.modelo;

import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.Date;

@Getter
@AllArgsConstructor
public class Session {
    String teacher;
    Date sessioDate;
    List<Student> students;

}
