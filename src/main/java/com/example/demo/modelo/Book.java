package com.example.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
public class Book {
    @Getter
    private int id;
    @Getter
    private @ToString.Include String nameBook;
    @Getter
    private @ToString.Include
    int TotalPages;
}
