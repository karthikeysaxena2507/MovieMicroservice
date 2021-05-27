package ratingService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratingService.models.Rating;
import ratingService.repositories.RatingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    Logger logger = LoggerFactory.getLogger(RatingService.class);

    private final RatingRepository ratingRepository;

    @Autowired
    private RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingsByMovieId(Long movieId) {
        List<Rating> ratings = ratingRepository.findAll();
        List<Rating> filteredRatings = new ArrayList<>();
        for(Rating rating: ratings) {
            if(rating.getMovieId().equals(movieId)) {
                filteredRatings.add(rating);
            }
        }
        return filteredRatings;
    }

    public Rating getRatingById(Long ratingId) {
        return ratingRepository.findById(ratingId).orElse(null);
    }

    public Rating addRating(Rating rating) {
        Rating newRating = new Rating(rating.getRating(), rating.getMovieId(), rating.getUsername());
        return ratingRepository.save(newRating);
    }

    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

}
