package com.pixel_technology.demo.dto;

import com.pixel_technology.demo.entities.Practitioners;

import java.time.LocalDateTime;
import java.util.Set;

public class PatientsDto {
    private int patientId;
    private String firstName;
    private String lastName;
    private String city;
    private LocalDateTime createdAt;
    Set<Practitioners> practitionersSet;

    private PatientsDto(int patientId, String firstName, String lastName, String city, LocalDateTime createdAt, Set<Practitioners> practitionersSet) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.createdAt = createdAt;
        this.practitionersSet = practitionersSet;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<Practitioners> getPractitionersSet() {
        return practitionersSet;
    }

    public static class PatientsDtoBuilder{
        private int patientId;
        private String firstName;
        private String lastName;
        private String city;
        private LocalDateTime createdAt;
        Set<Practitioners> practitionersSet;

        public PatientsDtoBuilder setPatientId(int patientId) {
            this.patientId = patientId;
            return this;
        }

        public PatientsDtoBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PatientsDtoBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PatientsDtoBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public PatientsDtoBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PatientsDtoBuilder setPractitionersSet(Set<Practitioners> practitionersSet) {
            this.practitionersSet = practitionersSet;
            return this;
        }

        public PatientsDto build(){
            return new PatientsDto(patientId,firstName,lastName,city,createdAt,practitionersSet);
        }
    }
}
