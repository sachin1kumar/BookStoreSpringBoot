package com.udemy.spring.boot.Spring.boot.learning.versioning;

public class Name {

    private final String firstName;
    private final String secondName;

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
