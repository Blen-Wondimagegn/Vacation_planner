package com.example.vacationplanner.controllers;

import com.example.vacationplanner.model.Excursion;
import com.example.vacationplanner.model.Vacation;
import com.example.vacationplanner.service.ExcursionService;
import com.example.vacationplanner.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vacations")
public class ExcursionController {

    @Autowired
    private VacationService vacationService;

    @Autowired
    private ExcursionService excursionService;

    // Display excursions by vacation
    @GetMapping("/{vacationId}/excursions")
    public String getExcursionsByVacation(@PathVariable Long vacationId, Model model) {
        Optional<Vacation> vacation = vacationService.getVacationById(vacationId);

        if (vacation.isEmpty()) {
            return "redirect:/vacations";  // Redirect if vacation not found
        }

        List<Excursion> excursions = excursionService.getExcursionsByVacationId(vacationId);
        model.addAttribute("vacation", vacation.get());
        model.addAttribute("excursions", excursions);

        return "excursion-list";
    }

    // Show form to add a new excursion
    @GetMapping("/{vacationId}/excursions/new")
    public String showAddExcursionForm(@PathVariable Long vacationId, Model model) {
        Optional<Vacation> vacation = vacationService.getVacationById(vacationId);

        if (vacation.isEmpty()) {
            return "redirect:/vacations";  // Redirect if vacation not found
        }

        model.addAttribute("excursion", new Excursion());
        model.addAttribute("vacationId", vacationId);

        return "excursion-form";
    }

    // Add a new excursion to the vacation
    @PostMapping("/{vacationId}/excursions")
    public String addExcursion(@PathVariable Long vacationId, @ModelAttribute Excursion excursion) {
        excursionService.addExcursionToVacation(vacationId, excursion);

        return "redirect:/vacations/" + vacationId + "/excursions";
    }

    // Delete an excursion by ID
    @GetMapping("/excursions/delete/{excursionId}")
    public String deleteExcursion(@PathVariable Long excursionId) {
        excursionService.deleteExcursion(excursionId);

        // Redirecting to vacation list after deletion
        return "redirect:/vacations";
    }
}
