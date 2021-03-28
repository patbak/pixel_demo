package com.pixel_technology.demo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "PATIENTS")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "PATIENTID")
    private int patientId;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "CREATEDAT")
    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "PATIENT2PRACTITIONER",
            joinColumns = @JoinColumn(name = "PATIENTID"),
            inverseJoinColumns = @JoinColumn(name = "PRACTITIONERID")
    )
    Set<Practitioners> practitionersSet;

    public Patients() {
    }

    private Patients(int patientId, String firstName, String lastName, String city, LocalDateTime createdAt, Set<Practitioners> practitionersSet) {
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

    public static class PatientsBuilder {
        private int patientId;
        private String firstName;
        private String lastName;
        private String city;
        private LocalDateTime createdAt;
        Set<Practitioners> practitionersSet;

        public PatientsBuilder setPatientId(int patientId) {
            this.patientId = patientId;
            return this;
        }

        public PatientsBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PatientsBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PatientsBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public PatientsBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PatientsBuilder setPractitionersSet(Set<Practitioners> practitionersSet) {
            this.practitionersSet = practitionersSet;
            return this;
        }

        public Patients build(){
            return new Patients(patientId, firstName, lastName, city, createdAt, practitionersSet);
        }
    }



}
