package com.example.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Person {
   @Getter @Setter
   public String  id;
   @Getter @Setter
   private String name ;
   @Getter @Setter
   private String lastName;
   @Getter @Setter
   private int age;
}
