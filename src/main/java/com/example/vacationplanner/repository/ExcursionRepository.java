package com.example.vacationplanner.repository;

import com.example.vacationplanner.model.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    List<Excursion> findByVacationId(Long vacationId);
}

