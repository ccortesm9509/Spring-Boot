package com.example.demo.modelo;

import lombok.Data;
import lombok.NonNull;

@Data
public class Car {

  @NonNull  private String marca;
  @NonNull  private String modelo;
  @NonNull  private String año;
}
