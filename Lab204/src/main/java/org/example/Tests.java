package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    private Person person1;
    private Person person2;
    private Person person3;
    private PersonList personList;

    @BeforeEach
    public void setUp() {
        person1 = new Person(1, "Pepito Pérez", 31, "Albañil");
        person2 = new Person(2, "Mengano López", 45, "Taxista");
        person3 = new Person(3, "Fulano Gómez", 70, "Jubilado");

        personList = new PersonList();
        personList.addPerson(person1);
        personList.addPerson(person2);
        personList.addPerson(person3);
    }


    @Test
    public void NegativeAge_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person1.setAge(-5);
        });

        assertEquals("Esta persona aún no ha nacido", exception.getMessage());
    }

    @Test
    void findByName_ReturnsCorrectPerson() {
        try {
            Person found = personList.findByName("Pepito Pérez");
            assertEquals(person1, found);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByName_InvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            personList.findByName("PepitoPérez"); // improper format
        });

        assertEquals("El nombre debe estar en formato firstName, lastName", exception.getMessage());
    }

    @Test
    void Cloned_SamePropertiesExceptId() {
        Person clonedPerson = personList.clone(person1, 100);

        assertNotEquals(clonedPerson.getId(), person1.getId());
        assertEquals(clonedPerson.getName(), person1.getName());
        assertEquals(clonedPerson.getAge(), person1.getAge());
        assertEquals(clonedPerson.getOccupation(), person1.getOccupation());
    }

}
