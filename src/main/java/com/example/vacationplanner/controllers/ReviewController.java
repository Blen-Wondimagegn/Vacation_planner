package org.blen.wondimagegn.vacationplanner.controllers;

import org.blen.wondimagegn.vacationplanner.model.Review;
import org.blen.wondimagegn.vacationplanner.model.Vacation;
import org.blen.wondimagegn.vacationplanner.service.ReviewService;
import org.blen.wondimagegn.vacationplanner.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/vacations")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private VacationService vacationService;

    // Retrieve reviews for a specific vacation
    @GetMapping("/{vacationId}/reviews")
    public String getReviewsForVacation(@PathVariable Long vacationId, Model model) {
        Optional<Vacation> vacation = vacationService.getVacationById(vacationId);
        if (vacation.isEmpty()) {
            return "redirect:/vacations"; // Handle case where the vacation ID is invalid
        }
        List<Review> reviews = reviewService.getReviewsByVacationId(vacationId);
        model.addAttribute("vacation", vacation.get());
        model.addAttribute("reviews", reviews);
        model.addAttribute("newReview", new Review()); // For adding new review

        return "reviews"; // Ensure 'reviews.html' exists in the templates folder
    }

    // Show form to add a new review for a vacation
    @GetMapping("/{vacationId}/reviews/new")
    public String showAddReviewForm(@PathVariable Long vacationId, Model model) {
        Optional<Vacation> vacation = vacationService.getVacationById(vacationId);

        if (vacation.isEmpty()) {
            return "redirect:/vacations";
        }

        model.addAttribute("review", new Review()); // Pass empty review object to the form
        model.addAttribute("vacationId", vacationId); // Pass the vacation ID for form handling

        return "review-form"; // Ensure 'review-form.html' exists in templates
    }

    // Submit a new review for a vacation
    @PostMapping("/{vacationId}/reviews")
    public String addReviewToVacation(@PathVariable Long vacationId, @ModelAttribute Review review) {
        Vacation vacation = vacationService.getVacationById(vacationId).orElseThrow(() ->
                new IllegalArgumentException("Invalid vacation Id: " + vacationId));

        review.setVacation(vacation); // Associate review with vacation
        reviewService.saveReview(review); // Save the review

        return "redirect:/vacations/" + vacationId + "/reviews"; // Redirect back to vacation reviews page
    }

}
