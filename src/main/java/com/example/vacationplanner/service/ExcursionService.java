package com.example.vacationplanner.service;

import com.example.vacationplanner.model.Excursion;
import com.example.vacationplanner.model.Vacation;
import com.example.vacationplanner.repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExcursionService {

    @Autowired
    private ExcursionRepository excursionRepository;

    @Autowired
    private VacationService vacationService;

    public List<Excursion> getExcursionsByVacationId(Long vacationId) {
        return excursionRepository.findByVacationId(vacationId);
    }

    public void addExcursionToVacation(Long vacationId, Excursion excursion) {
        Optional<Vacation> vacation = vacationService.getVacationById(vacationId);
        if (vacation.isPresent()) {
            excursion.setVacation(vacation.orElse(null));
            excursionRepository.save(excursion);
        }
    }

    public void deleteExcursion(Long excursionId) {
        excursionRepository.deleteById(excursionId);
    }
}
