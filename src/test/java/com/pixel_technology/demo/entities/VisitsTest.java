package com.pixel_technology.demo.entities;

import com.pixel_technology.demo.dto.PatientsCount;
import com.pixel_technology.demo.dto.VisitsCount;
import com.pixel_technology.demo.repositories.VisitsRepository;
import com.pixel_technology.demo.services.VisitsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class VisitsTest {

    private VisitsRepository visitsRepository;
    private VisitsServiceImpl visitsService;

    @Autowired
    public VisitsTest(VisitsRepository visitsRepository, VisitsServiceImpl visitsService){
       this.visitsRepository=visitsRepository;
       this.visitsService=visitsService;
    }

    @Test
    public void testGetAllVisits(){
        List<Visits> visitsList = visitsRepository.findAll();
        assertTrue(visitsList.size()>0);
    }

    @Test
    public void testCountVisits(){
        List<String> cities = new ArrayList<>();
        cities.add("all");
        List<String> specialities = new ArrayList<>();
        visitsService.countVisitsByCityAndSpecialities(cities, specialities);
    }


   @Test
    public void testGetAllVisitsByPatientsCityAndSpecialization(){
        List<String> city = new ArrayList<>();
        city.add("Kutno");
        city.add("Radomsko");
        List<String> specialities = new ArrayList<>();
        specialities.add("Psychiatry");
       List<PatientsCount> patientsCounts = visitsRepository.countPatientsVisitsByCityListAndSpecialitiesList(city, specialities);
        assertTrue(patientsCounts.size()>0);
        }

    @Test
    public void testGetAllVisitsByPatientsCity(){
        List<String> city = new ArrayList<>();
        city.add("Kutno");
        city.add("Radomsko");

        List<PatientsCount> patientsCount = visitsRepository.countPatientsVisitsByCityList(city);
        assertTrue(patientsCount.size()>0);
    }
    @Test
    public void testGetAllVisitsBySpecialization(){
        List<String> specialities = new ArrayList<>();
        specialities.add("Psychiatry");
        List<PatientsCount> patientsCounts = visitsRepository.countPatientsVisitsBySpecialitiesList(specialities);
        assertTrue(patientsCounts.size()>0);
    }
    @Test
    public void testGetAllVisitsCount(){
        List<PatientsCount> patientsCountList = visitsRepository.countPatientsVisits();
         assertTrue(patientsCountList.size()>0);
    }

   @Test
    public void testGetAllVisitsBySpecializationCount(){
        String specialization = "Psychiatry";
        VisitsCount visitsCount= visitsRepository.countVisitsBySpecialities(specialization);
        assertTrue(visitsCount!=null);
    }

}
