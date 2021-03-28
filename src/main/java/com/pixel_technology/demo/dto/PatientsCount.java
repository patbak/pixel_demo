package com.pixel_technology.demo.dto;

public class PatientsCount {
    private String firstName;
    private String lastName;
    private Long countVisits;

    public PatientsCount(String firstName, String lastName, Long count) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countVisits = count;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getCountVisits() {
        return countVisits;
    }
}
