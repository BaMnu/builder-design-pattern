package ru.netology;

import java.util.*;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;
    protected boolean hasAge;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    protected Person(String name, String surname, OptionalInt age) {
        this(name, surname);
        this.age = age;
    }

    protected Person(String name, String surname, OptionalInt age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    protected boolean hasAge() {
        PersonBuilder builder = new PersonBuilder();
        return builder.setAge(age.getAsInt()) != null;
    }

    protected void happyBirthday() {
        this.age = OptionalInt.of(age.getAsInt() + 1);
    }

    protected boolean hasAddress() {
        PersonBuilder builder = new PersonBuilder();
        return builder.setAddress(address) != null;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected String getName() {
        return name;
    }

    protected String getSurname() {
        return surname;
    }

    protected OptionalInt getAge() {
        return age;
    }

    protected String getAddress() {
        return address;
    }

    protected PersonBuilder newChildBuilder() {
        return new PersonBuilder().setName(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name)
                .append(" ")
                .append(surname);

        if (age != null && address != null) {
            sb.append(" (Возраст: ")
                    .append(age.getAsInt())
                    .append(", Адрес: ")
                    .append(address)
                    .append(")");

        } else if (address == null && age != null) {
            sb.append(" (Возраст: ")
                    .append(age.getAsInt())
                    .append(")");

        } else if (age == null && address != null) {
            sb.append(" (Адрес: ")
                    .append(address)
                    .append(")");
        }
        return String.valueOf(sb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }
}

