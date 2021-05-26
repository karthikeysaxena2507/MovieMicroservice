package movieDataService.services;

import movieDataService.models.Movie;
import movieDataService.models.Review;
import movieDataService.repositories.MovieRepository;
import movieDataService.repositories.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    Logger logger = LoggerFactory.getLogger(ReviewService.class);

    private final ReviewRepository reviewRepository;

    private final MovieRepository movieRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    /**
     * SERVICE TO GET ALL REVIEWS
     * @return ALL MOVIE REVIEWS
     */
    public List<Review> getAllReviews() {

        return reviewRepository.findAll();
    }

    /**
     * SERVICE TO GET ALL REVIEWS OF A MOVIE
     * @param movieId THE ID OF THE MOVIE WHOSE REVIEWS ARE ACCESSED
     * @return THE REQUIRED MOVIE REVIEWS
     */
    public List<Review> getReviewsByMovieId(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        List<Review> reviews = new ArrayList<>();
        if(movie != null) {
            reviews = movie.getReviews();
        }
        return reviews;
    }

    /**
     * SERVICE TO GET A REVIEW FROM DB BY ID
     * @param reviewId THE ID OF THE REVIEW TO BE ACCESSED
     * @return THE REQUIRED REVIEW
     */
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    /**
     * SERVICE TO ADD A NEW REVIEW
     * @param review THE REVIEW TO BE ADDED
     * @return THE ADDED MOVIE REVIEW
     */
    public Review addNewReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovieId()).orElse(null);
        if(movie != null) {
            return reviewRepository.save(review);
        }
        else {
            return review;
        }
    }

    /**
     * SERVICE TO UPDATE A REVIEW
     * @param review NEW REVIEW DATA
     * @return UPDATED REVIEW DATA
     */
    public Review updateReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovieId()).orElse(null);
        if(movie != null) {
            return reviewRepository.save(review);
        }
        return review;
    }

    /**
     * SERVICE TO DELETE A REVIEW
     * @param reviewId THE ID OF THE REVIEW TO BE DELETED
     */
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
