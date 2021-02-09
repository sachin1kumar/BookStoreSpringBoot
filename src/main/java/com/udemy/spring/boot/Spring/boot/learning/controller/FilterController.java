package com.udemy.spring.boot.Spring.boot.learning.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.udemy.spring.boot.Spring.boot.learning.model.SampleFilter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping("/filter")
    public MappingJacksonValue getFields() {
        SampleFilter sampleFilter = new SampleFilter("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("CustomFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(sampleFilter);
        mapping.setFilters(filters);
        return mapping;
    }
}
