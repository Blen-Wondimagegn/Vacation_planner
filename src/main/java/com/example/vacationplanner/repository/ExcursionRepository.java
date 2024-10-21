package org.blen.wondimagegn.vacationplanner.repository;

import org.blen.wondimagegn.vacationplanner.model.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    List<Excursion> findByVacationId(Long vacationId);
}

