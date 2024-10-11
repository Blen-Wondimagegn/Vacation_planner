package com.example.Vacationplanner.service;



import com.example.Vacationplanner.model.Vacation;
import com.example.Vacationplanner.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationService {

    @Autowired
    private VacationRepository vacationrepository;

    public List<Vacation> getAllVacations() {
        return vacationrepository.findAll();
    }

    public Optional<Vacation> getVacationById(Long id) {
        return vacationrepository.findById(id);
    }

    public Vacation createVacation(Vacation vacation) {
        return vacationrepository.save(vacation);
    }

    public void deleteVacation(Long id) {
        vacationrepository.deleteById(id);
    }

    public Vacation updateVacation(Long id, Vacation updatedVacation) {
        return vacationrepository.findById(id)
                .map(vacation -> {
                    vacation.setTitle(updatedVacation.getTitle());
                    vacation.setHotel(updatedVacation.getHotel());
                    vacation.setStartDate(updatedVacation.getStartDate());
                    vacation.setEndDate(updatedVacation.getEndDate());
                    vacation.setDestination(updatedVacation.getDestination());
                    return vacationrepository.save(vacation);
                })
                .orElseThrow(() -> new RuntimeException("Vacation not found"));
    }
}

