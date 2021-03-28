package com.pixel_technology.demo.services;

import com.pixel_technology.demo.dto.PatientsDto;
import com.pixel_technology.demo.entities.Patients;
import com.pixel_technology.demo.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientsServiceImpl implements PatientsService{

    private PatientsRepository patientsRepository;

    @Autowired
    public PatientsServiceImpl(PatientsRepository patientsRepository){
        this.patientsRepository=patientsRepository;
    }

    @Override
    public PatientsDto convertPatientsToPatientsDto(Patients patients){
        return new PatientsDto.PatientsDtoBuilder()
                .setPatientId(patients.getPatientId())
                .setFirstName(patients.getFirstName())
                .setLastName(patients.getLastName())
                .setCity(patients.getCity())
                .setCreatedAt(patients.getCreatedAt())
                .setPractitionersSet(patients.getPractitionersSet())
                .build();
    }

    @Override
    public List<PatientsDto> convertPatientsListToPatientsDtoList(List<Patients> patientsList){
        List<PatientsDto> patientsDtoList = new ArrayList<>();
        for (Patients patients:patientsList){
            patientsDtoList.add(convertPatientsToPatientsDto(patients));
        }
        return patientsDtoList;
    }

    @Override
    public List<PatientsDto> getAllPatients(){
        List<Patients> patientsList = patientsRepository.findAll();
        return convertPatientsListToPatientsDtoList(patientsList);
    }


}
