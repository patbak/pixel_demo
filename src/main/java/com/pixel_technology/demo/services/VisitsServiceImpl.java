package com.pixel_technology.demo.services;

import com.pixel_technology.demo.dto.PatientsCount;
import com.pixel_technology.demo.dto.VisitsCount;
import com.pixel_technology.demo.repositories.VisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitsServiceImpl implements VisitsService{

    private VisitsRepository visitsRepository;

    @Autowired
    public VisitsServiceImpl(VisitsRepository visitsRepository){
        this.visitsRepository=visitsRepository;
    }

    @Override
    public List<PatientsCount> countVisitsByCityAndSpecialities(List<String> cities, List<String> specialities){

        boolean citiesRequestAll = listHasAll(cities);
        boolean specialitiesRequestAll = listHasAll(specialities);

        if((citiesRequestAll||cities.size()==0)&&(specialities.size()>0&&!specialitiesRequestAll)){
            return visitsRepository.countPatientsVisitsBySpecialitiesList(specialities);
        }else if((specialitiesRequestAll||specialities.size()==0)&&(cities.size()>0&&!citiesRequestAll)){
            return visitsRepository.countPatientsVisitsByCityList(cities);
        }else if((cities.size()==0||citiesRequestAll)&&(specialities.size()==0||specialitiesRequestAll)){
            return visitsRepository.countPatientsVisits();
        }else{
            return visitsRepository.countPatientsVisitsByCityListAndSpecialitiesList(cities,specialities);
        }
    }

    @Override
    public Boolean listHasAll(List<String> listToSearch){
        final String ALL="ALL";
        List<String> matchingElements = listToSearch.stream()
                .filter(str -> str.toUpperCase().contains(ALL))
                .collect(Collectors.toList());
        if (matchingElements.size()>0)
            return true;
        return false;
    }

    @Override
    public VisitsCount countVisitsBySpecialization(String specialities){
        return visitsRepository.countVisitsBySpecialities(specialities);
    }


}