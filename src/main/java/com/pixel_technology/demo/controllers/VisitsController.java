package com.pixel_technology.demo.controllers;


import com.pixel_technology.demo.dto.PatientsCount;
import com.pixel_technology.demo.dto.VisitsCount;
import com.pixel_technology.demo.services.VisitsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitsController {

    private VisitsServiceImpl visitsService;

    @Autowired
    public VisitsController(VisitsServiceImpl visitsService){
        this.visitsService=visitsService;
    }


    @RequestMapping(value ="/visits" ,method = RequestMethod.GET, params = {"cities","specialities"})
    public List<PatientsCount> countVisitsByCityAndSpecialities(@RequestParam List<String> cities, @RequestParam List<String> specialities){
      return visitsService.countVisitsByCityAndSpecialities(cities,specialities);
    }

   @RequestMapping(value ="/specialities" ,method = RequestMethod.GET, params = {"specialities"})
    public VisitsCount countVisitsAndSpecialities(@RequestParam String specialities){
        return visitsService.countVisitsBySpecialization(specialities);
    }



}
