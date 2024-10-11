package com.example.Vacationplanner.repository;

import com.example.Vacationplanner.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findByTitleContaining(String keyword);
}
