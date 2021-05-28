package movieDataService.services;

import movieDataService.exceptions.BusinessException;
import movieDataService.models.Movie;
import movieDataService.models.Review;
import movieDataService.repositories.MovieRepository;
import movieDataService.repositories.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(movie != null)
        {
            if(movie.getReviews().isEmpty()) throw new BusinessException("601", movie.getTitle() + " doesn't have any reviews");
            else return reviewRepository.findReviewsByMovieId(movieId);
        }
        else throw new BusinessException("601", "Movie with Id " + movieId + " doesn't exists");
    }

    /**
     * SERVICE TO GET ALL REVIEWS OF A USER
     * @param username THE USERNAME WHOSE REVIEWS ARE ACCESSED
     * @return THE REQUIRED MOVIE REVIEWS
     */
    public List<Review> getReviewsByUsername(String username) {
        List<Review> reviews = reviewRepository.findByUsername(username);
        if(reviews.isEmpty()) throw new BusinessException("601", username + " hasn't given any reviews");
        else return reviews;
    }

    /**
     * SERVICE TO GET A REVIEW FROM DB BY ID
     * @param reviewId THE ID OF THE REVIEW TO BE ACCESSED
     * @return THE REQUIRED REVIEW
     */
    public Review getReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review == null) throw new BusinessException("601", "Review with Id " + reviewId + " doesn't exists");
        return review;
    }

    /**
     * SERVICE TO ADD A NEW REVIEW
     * @param review THE REVIEW TO BE ADDED
     * @return THE ADDED MOVIE REVIEW
     */
    public Review addNewReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovieId()).orElse(null);
        if(movie != null) return reviewRepository.save(review);
        else throw new BusinessException("601", "Movie with Id " + review.getMovieId() + " doesn't exists");
    }

    /**
     * SERVICE TO UPDATE A REVIEW
     * @param review NEW REVIEW DATA
     * @return UPDATED REVIEW DATA
     */
    public Review updateReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovieId()).orElse(null);
        if(movie != null) return reviewRepository.save(review);
        else throw new BusinessException("601", "Movie with Id " + review.getMovieId() + " doesn't exists");
    }

    /**
     * SERVICE TO DELETE A REVIEW
     * @param reviewId THE ID OF THE REVIEW TO BE DELETED
     */
    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if(review != null) reviewRepository.deleteById(reviewId);
        else throw new BusinessException("601", "Review with Id " + reviewId + " doesn't exists");
    }

}
