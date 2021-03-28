package com.pixel_technology.demo.entities;

import com.pixel_technology.demo.repositories.PatientsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PatientsTest {


    private PatientsRepository patientsRepository;

    @Autowired
    public PatientsTest(PatientsRepository patientsRepository){
        this.patientsRepository=patientsRepository;
    }

    @Test
    public void testGetAllPatients(){
        List<Patients> patientsList = patientsRepository.findAll();
        assertTrue(patientsList.size()>0);
    }

    @Test
    @Transactional
    public void testGetPractitionersSet(){
        Patients patients = patientsRepository.getOne(5);
        Set<Practitioners> practitionersSet = patients.getPractitionersSet();
        assertTrue(practitionersSet.size()>0);
    }

    @Test
    @Transactional
    public void testGetPatientsByCity(){
       List<String> city = new ArrayList<>();
        city.add("Kutno") ;
        List<Patients> patientsList = patientsRepository.findPatientsByCityList(city);
        assertTrue(patientsList.size()>0);
    }

}
