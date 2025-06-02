package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonList {
    private ArrayList<Person> people;

    public PersonList() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public Person findByName(String name) throws Exception {
        String[] nameCheck = name.split(" ");
        if (nameCheck.length != 2) {
            throw new IllegalArgumentException("El nombre debe estar en formato firstName, lastName");
        }
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        throw new Exception("No se encontraron personas con ese nombre");
    }

    public Person clone(Person original, int newId) {
        return new Person(newId, original.name, original.age, original.occupation);
    }

    public void writeToFile(Person person) {
        try {
            File file = new File("person.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(person.toString());
            writer.close();
            ;
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo" + e);
        }
    }
}