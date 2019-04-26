package com.example.demo;

import com.example.demo.modelo.Book;
import com.example.demo.modelo.Car;
import io.vavr.collection.List;
import io.vavr.control.Try;
import lombok.*;
import org.junit.Assert;
import org.junit.Test;
import io.vavr.*;
import com.example.demo.modelo.Person;

import javax.validation.constraints.AssertTrue;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLombok {

    private String nameConvert( String name) {
        return "Nombre: " + name;
    }

    private String lastNameConvert(String apellido) {
        return "Apellido: " + apellido;
    }

    private Person validatePerson(@NonNull Person person) {return  person; }

    private int ageConvert(int edad) {
        return edad * 2;
    }

    @Test
    public void testWithVal() {

        val name = "christian";
        val lastName = "cortes";
        val age = 23;
        val id = "102121";
        val expected = new Person(
                id,
                "Nombre: " + name,
                "Apellido: " + lastName,
                age * 2);

        val result = new Person(
                id,
                nameConvert(name),
                lastNameConvert(lastName),
                ageConvert(age)
        );
        assertEquals(expected.toString(), result.toString());
        assertEquals("validate val as argument of an function ",
                expected.getName(), result.getName()
        );
    }
    @Test
    public void testWithVar() {

        var name = "christian";
        var lastName = "cortes";
        var age = 23;
        var id = "102121";
        age = age * 2;

        var expected = new Person(
                id,
                "Nombre: " + name,
                "Apellido: " + lastName,
                age *  2);

        val result = new Person(
                id,
                nameConvert(name),
                lastNameConvert(lastName),
                ageConvert(age)
        );

        assertEquals(expected.toString(), result.toString());
        assertEquals("validate val as argument of an function ",
                expected.getAge(), result.getAge()
        );
    }
    @Test
    public void testWithNotNull() {
        Person person = null;
        val validate = Try.of(() -> validatePerson(person));
        assertTrue("failed - the object is null",
                validate.isFailure());
        val recovery = validate.recover(x ->
                new Person("1234",
                        "nameRecover",
                        "lastNameRecover",
                        2));
        assertTrue(recovery.isSuccess());
    }
    @Test
    public void testWithGet(){

        val expected = new Person(
                "1234",
                "Tony" ,
                "Stark :(" ,
                50);

        assertEquals
        ("Validate getter",
                expected.getName().toUpperCase() + " "  +
                        expected.getLastName().toUpperCase(), "TONY STARK :(");


    }
    @Test
    public void testWithSet(){

        // We aren't going to use this
        val expected = new Person(
                "1234",
                "nameTest" ,
                "lastNameTest" ,
                11);

        expected.setAge(22);
        expected.setLastName("setLastNameTest");
        expected.setName("setNameTest");

        assertEquals(expected.getAge(), 22);
        assertEquals(expected.getLastName(), "setLastNameTest");
        assertEquals(expected.getName(), "setNameTest");

        System.out.println(expected);

    }
    @Test
    public void testWithToStringNotIncludingFieldNames(){
        val expected = new Book(1,
                "Scala for the Impatient", 100);
        System.out.println(expected);
        assertEquals(expected.toString().toUpperCase(),
                "BOOK(SCALA FOR THE IMPATIENT, 100)");
    }
    @Test
    public void testWithToStringIncludingFieldNames(){
        val expected = new Person(
                "1234",
                "nameTest" ,
                "lastNameTest" ,
                11);
        assertEquals(expected.toString().toUpperCase(),
                "PERSON(ID=1234, NAME=NAMETEST, LASTNAME=LASTNAMETEST, AGE=11)");
    }


    @Test
    public void testWithData(){
        val newCar = new Car("Renault", "Logan", "2012");
        val newCar2 = new Car("Renault", "Logan", "2012");
        val carList = List.of(newCar, newCar2).toSet();
        assertEquals(newCar.toString(),
                "Car(marca=Renault, modelo=Logan, año=2012)");
        assertEquals(newCar.getAño().toString(),"2012");
        assertEquals(carList.size(),1);
    }



}
