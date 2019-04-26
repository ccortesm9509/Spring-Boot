package com.example.demo.modelo;

import lombok.*;



@EqualsAndHashCode
@Getter
public class Student extends Person {
    private String semester;

    public Student(String id, String name, String lastName, int age, String semester) {
        super(id, name, lastName, age);
        this.semester = semester;
    }
}
