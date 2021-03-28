package com.pixel_technology.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "VISITS")
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "VISITID")
    private int visitId;

    @ManyToOne
    @JoinColumn(name = "PRACTITIONERID")
    private Practitioners practitioners;

    @ManyToOne
    @JoinColumn(name = "PATIENTID")
    private Patients patients;

    public Visits() {
    }

    private Visits(int visitId, Practitioners practitioners, Patients patients) {
        this.visitId = visitId;
        this.practitioners = practitioners;
        this.patients = patients;
    }

    public int getVisitId() {
        return visitId;
    }

    public Practitioners getPractitioners() {
        return practitioners;
    }

    public Patients getPatients() {
        return patients;
    }

    public static class VisitsBuilder{
        private int visitId;
        private Practitioners practitioners;
        private Patients patients;

        public VisitsBuilder setVisitId(int visitId) {
            this.visitId = visitId;
            return this;
        }

        public VisitsBuilder setPractitioners(Practitioners practitioners) {
            this.practitioners = practitioners;
            return this;
        }

        public VisitsBuilder setPatients(Patients patients) {
            this.patients = patients;
            return this;
        }

        public Visits build(){
            return new Visits(visitId, practitioners, patients);
        }
    }

}
