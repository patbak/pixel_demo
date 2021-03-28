package com.pixel_technology.demo.services;

import com.pixel_technology.demo.dto.PatientsCount;
import com.pixel_technology.demo.dto.VisitsCount;

import java.util.List;

public interface VisitsService {

    public List<PatientsCount> countVisitsByCityAndSpecialities(List<String> cities, List<String> specialities);

    public Boolean listHasAll(List<String> listToSearch);

    public VisitsCount countVisitsBySpecialization(String specialities);
}
