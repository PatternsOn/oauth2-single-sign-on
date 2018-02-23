package com.patternson.oauth2singlesignon;

public class Employee {

    private int employeeId;
    private String name;
    private int age;
    private String address;

    public Employee(int employeeId, String name, int age, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
