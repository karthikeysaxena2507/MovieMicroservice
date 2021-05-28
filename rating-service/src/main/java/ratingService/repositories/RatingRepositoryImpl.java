package ratingService.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import ratingService.models.Rating;

import java.util.ArrayList;
import java.util.List;

public class RatingRepositoryImpl implements CustomRatingRepository {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> findRatingsByMovieId(Long movieId) {
        List<Rating> ratings = ratingRepository.findAll();
        List<Rating> filteredRatings = new ArrayList<>();
        for(Rating rating: ratings) {
            if(rating.getMovieId().equals(movieId)) {
                filteredRatings.add(rating);
            }
        }
        return filteredRatings;
    }
}
