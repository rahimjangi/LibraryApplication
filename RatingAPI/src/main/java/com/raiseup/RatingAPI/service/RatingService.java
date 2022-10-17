package com.raiseup.RatingAPI.service;

import com.raiseup.RatingAPI.mode.Rating;
import com.raiseup.RatingAPI.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository ratingRepository;

    public List<Rating> findAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> findRatingsByBookId(Long bookId) {
        return ratingRepository.findRatingsByBookId(bookId);
    }

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

    public Rating updateRating(Rating rating, Long ratingId) {
        Rating findedRating=ratingRepository.findById(ratingId).get();
        findedRating.setStars(rating.getStars());
        findedRating.setBookId(rating.getBookId());
        return ratingRepository.save(findedRating);
    }
    public Rating updateRating(Map<String,String> updates, Long ratingId) {
        Rating findedRating=ratingRepository.findById(ratingId).get();
        findedRating.setStars(Integer.valueOf(updates.get("stars")));
        findedRating.setBookId(Long.valueOf(updates.get("bookId")));
        return ratingRepository.save(findedRating);
    }
}
