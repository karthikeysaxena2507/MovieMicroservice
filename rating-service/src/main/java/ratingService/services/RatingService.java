package ratingService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratingService.exceptions.NoSuchElementFoundException;
import ratingService.helpers.RatingHelper;
import ratingService.models.Rating;
import ratingService.repositories.RatingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    Logger logger = LoggerFactory.getLogger(RatingService.class);

    private final RatingRepository ratingRepository;

    private final RatingHelper ratingHelper;

    @Autowired
    private RatingService(RatingRepository ratingRepository, RatingHelper ratingHelper) {
        this.ratingRepository = ratingRepository;
        this.ratingHelper = ratingHelper;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingsByMovieId(Long movieId) {
        if(ratingHelper.isMovieIdValid(movieId)) {
            return ratingRepository.findRatingsByMovieId(movieId);
        }
        else throw new NoSuchElementFoundException();

    }

    public int add(int a, int b) {
        return a + b;
    }

    public double area(int r) {
        return 3.14 * r * r;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public Rating getRatingById(Long ratingId) {
        Rating rating = ratingRepository.findById(ratingId).orElse(null);
        if(rating != null) return rating;
        else throw new NoSuchElementFoundException();

    }

    public Rating addRating(Rating rating) {
        if(ratingHelper.isMovieIdValid(rating.getMovieId())) return ratingRepository.save(rating);
        else throw new NoSuchElementFoundException();
    }

    public Rating updateRating(Rating rating) {
        Rating existingRating = ratingRepository.findById(rating.getId()).orElse(null);
        if(existingRating != null) {
            if(ratingHelper.isMovieIdValid(rating.getMovieId())) return ratingRepository.save(rating);
            else throw new NoSuchElementFoundException();
        }
        else throw new NoSuchElementFoundException();
    }

    public void deleteRating(Long ratingId) {
        Rating rating = ratingRepository.findById(ratingId).orElse(null);
        if(rating != null) ratingRepository.deleteById(rating.getId());
        else throw new NoSuchElementFoundException();
    }

}
