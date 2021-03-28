package com.pixel_technology.demo.dto;

public class VisitsCount {
    private String visit;
    private Long numberOfVisits;

    public VisitsCount(String visit, Long numberOfVisits) {
        this.visit = visit;
        this.numberOfVisits = numberOfVisits;
    }

    public String getVisit() {
        return visit;
    }

    public Long getNumberOfVisits() {
        return numberOfVisits;
    }
}
