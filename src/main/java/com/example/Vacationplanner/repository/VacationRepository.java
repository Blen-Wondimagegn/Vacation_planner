package com.example.Vacationplanner.repository;

import com.example.Vacationplanner.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
