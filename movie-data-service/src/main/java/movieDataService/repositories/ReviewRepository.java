package movieDataService.repositories;

import movieDataService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, CustomReviewRepository {
    List<Review> findByUsername(String username);
}
