package com.example.vacationplanner.service;

import com.example.vacationplanner.model.Review;
import com.example.vacationplanner.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByVacationId(Long vacationId) {
        return reviewRepository.findByVacationId(vacationId);
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
