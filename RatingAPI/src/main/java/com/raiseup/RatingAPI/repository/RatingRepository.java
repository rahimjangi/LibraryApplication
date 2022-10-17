package com.raiseup.RatingAPI.repository;

import com.raiseup.RatingAPI.mode.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Long> {
    List<Rating> findRatingsByBookId(Long bookId);
}
