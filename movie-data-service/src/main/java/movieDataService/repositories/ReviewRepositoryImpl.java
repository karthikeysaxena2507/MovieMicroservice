package movieDataService.repositories;

import movieDataService.models.Review;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepositoryImpl implements CustomReviewRepository{
    @Autowired
    private ReviewRepository reviewRepository;

//    GOOD PRACTICE BUT CAUSES CYCLIC DEPENDENCY IN THIS CASE
//    IF DECLARED INSIDE ANOTHER PACKAGE LIKE SERVICES NO CYCLIC DEPENDENCY (NOT ABLE TO UNDERSTAND WHY?)
//    NAME OF CLASS MUST BE ReviewRepository + "Impl" But in another package we can rename it
//    private final ReviewRepository reviewRepository;
//    @Autowired
//    public ReviewRepositoryImpl(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }

    @Override
    public List<Review> findReviewsByMovieId(Long movieId) {
        List<Review> reviews = reviewRepository.findAll();
        List<Review> requiredReviews = new ArrayList<>();
        for(Review review: reviews) {
            if(review.getMovieId().equals(movieId)) {
                requiredReviews.add(review);
            }
        }
        return requiredReviews;
    }

}
