package com.udemy.spring.boot.Spring.boot.learning.versioning;

public class EmployeeV2 {

    private final Name name;

    public EmployeeV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
