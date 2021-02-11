package com.udemy.spring.boot.Spring.boot.learning.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    //URI Versioning...
    @GetMapping("v1/employee")
    public EmployeeV1 employeeV1() {
        return new EmployeeV1("Sachin Kumar");
    }

    @GetMapping("v2/employee")
    public EmployeeV2 employeeV2() {
        return new EmployeeV2(new Name("Sachin", "Kumar"));
    }

    //Params Versioning
    @GetMapping(value = "employee/param", params = "version=1")
    public EmployeeV1 paramV1() {
        return new EmployeeV1("Sachin Kumar");
    }

    @GetMapping(value = "employee/param", params = "version=2")
    public EmployeeV2 paramV2() {
        return new EmployeeV2(new Name("Sachin", "Kumar"));
    }

    //Headers Versioning
    @GetMapping(value = "employee/header", headers = "X-API-VERSION=1")
    public EmployeeV1 headerV1() {
        return new EmployeeV1("Sachin Kumar");
    }

    @GetMapping(value = "employee/header", headers = "X-API-VERSION=2")
    public EmployeeV2 headerV2() {
        return new EmployeeV2(new Name("Sachin", "Kumar"));
    }

    //Media type/ content negotiation versioning
    @GetMapping(value = "employee/produces", produces = "application/vnd.company.app-v1+json")
    public EmployeeV1 producesV1() {
        return new EmployeeV1("Sachin Kumar");
    }

    @GetMapping(value = "employee/produces", produces = "application/vnd.company.app-v2+json")
    public EmployeeV2 producesV2() {
        return new EmployeeV2(new Name("Sachin", "Kumar"));
    }
}
