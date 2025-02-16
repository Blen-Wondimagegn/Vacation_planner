package com.example.vacationplanner.repository;

import com.example.vacationplanner.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findByTitleContaining(String keyword);
}
