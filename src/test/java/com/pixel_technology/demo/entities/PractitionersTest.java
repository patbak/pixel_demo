package com.pixel_technology.demo.entities;

import com.pixel_technology.demo.repositories.PractitionersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PractitionersTest {

    private PractitionersRepository practitionersRepository;

    @Autowired
    public PractitionersTest(PractitionersRepository practitionersRepository){
        this.practitionersRepository=practitionersRepository;
    }

    @Test
    public void testGetAllPractitioners(){
        List<Practitioners> practitionersList = practitionersRepository.findAll();
        assertTrue(practitionersList.size()>0);
    }


}
