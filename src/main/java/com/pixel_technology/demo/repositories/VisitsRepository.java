package com.pixel_technology.demo.repositories;

import com.pixel_technology.demo.dto.PatientsCount;
import com.pixel_technology.demo.dto.VisitsCount;
import com.pixel_technology.demo.entities.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitsRepository extends JpaRepository<Visits, Integer> {


    @Query("select new com.pixel_technology.demo.dto.PatientsCount(v.patients.firstName, v.patients.lastName, COUNT(v.visitId))" +
            " from Visits v where v.patients.city IN :city AND v.practitioners.specialization IN :specialization group by v.patients.patientId")
    List<PatientsCount> countPatientsVisitsByCityListAndSpecialitiesList(@Param("city") List<String> city, @Param("specialization") List<String> specialization);


    @Query("select new com.pixel_technology.demo.dto.PatientsCount(v.patients.firstName, v.patients.lastName, COUNT(v.visitId))" +
            " from Visits v where v.patients.city IN :city group by v.patients.patientId")
    List<PatientsCount> countPatientsVisitsByCityList(@Param("city") List<String> city);


    @Query("select new com.pixel_technology.demo.dto.PatientsCount(v.patients.firstName, v.patients.lastName, COUNT(v.visitId))" +
            " from Visits v where v.practitioners.specialization IN :specialization group by v.patients.patientId")
    List<PatientsCount> countPatientsVisitsBySpecialitiesList(@Param("specialization") List<String> specialization);


    @Query("select new com.pixel_technology.demo.dto.PatientsCount(v.patients.firstName, v.patients.lastName, COUNT(v.visitId))" +
            " from Visits v group by v.patients.patientId")
    List<PatientsCount> countPatientsVisits();


  @Query(value = "SELECT new com.pixel_technology.demo.dto.VisitsCount(v.practitioners.specialization, count(v.visitId)) " +
            "from Visits v where v.practitioners.specialization like  :specialization group by v.practitioners.specialization")
  VisitsCount countVisitsBySpecialities(@Param("specialization") String specialization);



}
