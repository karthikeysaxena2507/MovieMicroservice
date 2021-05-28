package ratingService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ratingService.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>, CustomRatingRepository {

}
