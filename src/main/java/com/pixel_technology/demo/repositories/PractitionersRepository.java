package com.pixel_technology.demo.repositories;

import com.pixel_technology.demo.entities.Practitioners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PractitionersRepository extends JpaRepository<Practitioners, Integer> {
}
