package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    protected Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        hasAge();
        hasAddress();
    }

    protected Person(String name, String surname, OptionalInt age) {
        this(name, surname);
        this.age = age;
        hasAge();
        hasAddress();
    }

    protected Person(String name, String surname, OptionalInt age, String address) {
        this(name, surname, age);
        this.address = address;
        hasAge();
        hasAddress();
    }

    protected boolean hasAge() {
        return this.age != null;
    }

    protected void happyBirthday() {
        this.age = OptionalInt.of(age.getAsInt() + 1);
    }

    protected boolean hasAddress() {
        return this.address != null;
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
        return new PersonBuilder().setName(name).setSurname(surname);
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
                    .append(", Адрес: ")
                    .append(hasAddress())
                    .append(")");

        } else if (age == null && address != null) {
            sb.append(" (Возраст: ")
                    .append(hasAge())
                    .append(", Адрес: ")
                    .append(address)
                    .append(")");
        } else {
            sb.append(" (Возраст: ")
                    .append(hasAge())
                    .append(", Адрес: ")
                    .append(hasAddress())
                    .append(")");
        }
        return String.valueOf(sb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }
}

