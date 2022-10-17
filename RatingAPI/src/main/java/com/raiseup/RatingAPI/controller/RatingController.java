package com.raiseup.RatingAPI.controller;

import com.raiseup.RatingAPI.mode.Rating;
import com.raiseup.RatingAPI.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rating")
public class RatingController {
    private final RatingService ratingService;

    @GetMapping
    public List<Rating> findRatingsByBookId(
            @RequestParam(required = false, defaultValue = "0") Long bookId) {
        if (bookId.equals(0L)) {
            return ratingService.findAllRatings();
        }
        return ratingService.findRatingsByBookId(bookId);
    }
    @PostMapping
    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.createRating(rating);
    }
    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
    }
    @PutMapping("/{ratingId}")
    public Rating updateRating(@RequestBody Rating rating, @PathVariable Long ratingId) {
        return ratingService.updateRating(rating, ratingId);
    }
    @PatchMapping("/{ratingId}")
    public Rating updateRating(
            @RequestBody Map<String, String> updates,
            @PathVariable Long ratingId) {
        return ratingService.updateRating(updates, ratingId);
    }
}
