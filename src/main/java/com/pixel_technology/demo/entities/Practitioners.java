package com.pixel_technology.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "PRACTITIONERS")
public class Practitioners {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "PRACTITIONERID")
    private int practitionersId;

    @Column(name = "SPECIALIZATION")
    private String specialization;

    public int getPractitionersId() {
        return practitionersId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Practitioners() {
    }

    private Practitioners(int practitionersId, String specialization) {
        this.practitionersId = practitionersId;
        this.specialization = specialization;
    }

    public static class PractitionersBuilder{
        private int practitionersId;
        private String specialization;

        public PractitionersBuilder setPractitionersId(int practitionersId) {
            this.practitionersId = practitionersId;
            return this;
        }

        public PractitionersBuilder setSpecialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public Practitioners build(){
            return new Practitioners(practitionersId,specialization);
        }
    }

}
