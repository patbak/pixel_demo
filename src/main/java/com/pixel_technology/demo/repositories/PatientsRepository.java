package com.pixel_technology.demo.repositories;

import com.pixel_technology.demo.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Integer> {

    @Query(value = "SELECT p FROM Patients p WHERE p.city IN :city")
    List<Patients> findPatientsByCityList(@Param("city") List<String> city);

}
