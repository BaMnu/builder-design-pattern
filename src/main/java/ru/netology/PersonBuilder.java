package ru.netology;

import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age;
    private String address;
    private boolean hasAge;


    public PersonBuilder setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Person's name cannot be 'null'.");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null) {
            throw new IllegalArgumentException("Person's surname cannot be 'null'.");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int ageAsInt) {
        this.age = OptionalInt.of(ageAsInt);
        if (age.getAsInt() < 0) {
            throw new IllegalArgumentException("Age cannot be smaller than 0.");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) throws IllegalArgumentException {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Person cannot have no name and/or no surname");
        }

        return new Person(name, surname, age, address);
    }
}
