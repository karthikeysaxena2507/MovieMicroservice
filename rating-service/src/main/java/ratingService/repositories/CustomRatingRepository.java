package ratingService.repositories;

import ratingService.models.Rating;

import java.util.List;

public interface CustomRatingRepository {

    List<Rating> findRatingsByMovieId(Long movieId);

}
