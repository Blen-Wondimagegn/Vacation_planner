package org.blen.wondimagegn.vacationplanner.service;

import org.blen.wondimagegn.vacationplanner.model.Review;
import org.blen.wondimagegn.vacationplanner.repository.ReviewRepository;
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
