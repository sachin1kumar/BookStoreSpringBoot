package com.udemy.spring.boot.Spring.boot.learning.model;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("CustomFilter")
public class SampleFilter {

    private final String field1;
    private final String field2;
    private final String field3;

    public SampleFilter(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }
}
