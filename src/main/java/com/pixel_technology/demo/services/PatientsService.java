package com.pixel_technology.demo.services;

import com.pixel_technology.demo.dto.PatientsDto;
import com.pixel_technology.demo.entities.Patients;

import java.util.List;

public interface PatientsService {

    public PatientsDto convertPatientsToPatientsDto(Patients patients);

    public List<PatientsDto> convertPatientsListToPatientsDtoList(List<Patients> patientsList);

    public List<PatientsDto> getAllPatients();


}
