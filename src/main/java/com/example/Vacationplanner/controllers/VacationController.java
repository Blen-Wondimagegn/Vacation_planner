package com.example.Vacationplanner.controllers;
import org.springframework.ui.Model;
import com.example.Vacationplanner.model.Vacation;
import com.example.Vacationplanner.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;


    @GetMapping
    public String getAllVacations(Model model) {
        List<Vacation> vacations = vacationService.getAllVacations();
        model.addAttribute("vacations", vacations);
        return "vacation-list";
    }

    @GetMapping("/new")
    public String showCreateVacationForm(Model model) {
        Vacation vacation = new Vacation();
        model.addAttribute("vacation", vacation);
        return "vacation-form";
    }


    @GetMapping("/edit/{id}")
    public String showEditVacationForm(@PathVariable Long id, Model model) {
        Optional<Vacation> optionalVacation = vacationService.getVacationById(id);
        if (optionalVacation.isPresent()) {
            model.addAttribute("vacation", optionalVacation.get());
        } else {
            return "redirect:/vacations";
        }
        return "vacation-form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("vacation") Vacation vacation) {
        if (vacation.getId() != null) {
            vacationService.updateVacation(vacation.getId(), vacation);
        } else {
            vacationService.createVacation(vacation);
        }
        return "redirect:/vacations";
    }

    @GetMapping("/delete/{id}")
    public String deleteVacation(@PathVariable Long id) {
        vacationService.deleteVacation(id);
        return "redirect:/vacations";
    }

}
