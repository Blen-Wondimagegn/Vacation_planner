package org.blen.wondimagegn.vacationplanner.repository;

import org.blen.wondimagegn.vacationplanner.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByVacationId(Long vacationId);
}
