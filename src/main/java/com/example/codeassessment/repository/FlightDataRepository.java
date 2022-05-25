package com.example.codeassessment.repository;

import com.example.codeassessment.entity.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDataRepository extends JpaRepository<FlightData,Long> {
}