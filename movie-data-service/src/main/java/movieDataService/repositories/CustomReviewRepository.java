package movieDataService.repositories;
import movieDataService.models.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomReviewRepository {
    public List<Review> findReviewsByMovieId(Long movieId);
}
