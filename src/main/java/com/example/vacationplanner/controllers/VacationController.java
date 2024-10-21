package org.blen.wondimagegn.vacationplanner.controllers;
import org.blen.wondimagegn.vacationplanner.service.EmailService;
import org.springframework.ui.Model;
import org.blen.wondimagegn.vacationplanner.model.Vacation;
import org.blen.wondimagegn.vacationplanner.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vacations")
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/notify")
    public String sendNotification(@RequestParam String startDate, @RequestParam String email, RedirectAttributes redirectAttributes) {
        try {
            emailService.sendEmail(email, "Vacation Start Date Notification", "Your vacation starts on: " + startDate);
            redirectAttributes.addFlashAttribute("message", "Notification sent to " + email);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to send notification: " + e.getMessage());
        }
        return "redirect:/vacations";
    }


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

    @GetMapping("/search")
    public String searchVacations(@RequestParam("keyword") String keyword, Model model) {
        List<Vacation> vacations = vacationService.searchVacations(keyword);
        model.addAttribute("vacations", vacations);
        return "vacation-list";
    }



}
