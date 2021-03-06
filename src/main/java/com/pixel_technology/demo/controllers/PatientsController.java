package com.pixel_technology.demo.controllers;

import com.pixel_technology.demo.dto.PatientsDto;
import com.pixel_technology.demo.services.PatientsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientsController {


    private PatientsServiceImpl patientsService;

    @Autowired
    public PatientsController(PatientsServiceImpl patientsService){
        this.patientsService=patientsService;
    }



    @RequestMapping(value ="/patients" ,method = RequestMethod.GET)
    public List<PatientsDto> getPatients(){
    return patientsService.getAllPatients();
    }




}
