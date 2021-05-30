package userService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import userService.exceptions.NoSuchElementFoundException;
import userService.models.Movie;
import userService.models.MovieDetail;
import userService.models.Rating;
import userService.models.Review;

import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final WebClient.Builder webClient;

    @Autowired
    public UserService(WebClient.Builder webClient) {
        this.webClient = webClient;
    }

    public Review getReviewDetailsByReviewId(Long reviewId) {

        logger.info("Review Id => " + reviewId);
        return webClient
                .build()
                .get()
                .uri("http://MOVIE-DATA-SERVICE/api/movies/reviews/" + reviewId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Review.class)
                .doOnError(exc -> {
                    logger.error(exc.getMessage());
                    throw new NoSuchElementFoundException();
                })
                .block();

    }

    public List<Rating> getRatingsByMovieId(Long movieId) {

        logger.info("Movie Id => " + movieId);
        return webClient
                .build()
                .get()
                .uri("http://RATING-SERVICE/api/ratings/movie/" + movieId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Rating.class)
                .collectList()
                .block();

    }

    public List<Review> getAllReviews() {

        return webClient
                .build()
                .get()
                .uri("http://MOVIE-DATA-SERVICE/api/movies/reviews/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Review.class)
                .collectList()
                .doOnError(exc -> {
                    logger.error(exc.getMessage());
                    throw new NoSuchElementFoundException();
                })
                .block();
    }

    public List<Rating> getAllRatings() {

        return webClient
                .build()
                .get()
                .uri("http://RATING-SERVICE/api/ratings/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Rating.class)
                .collectList()
                .doOnError(exc -> {
                    logger.error(exc.getMessage());
                    throw new NoSuchElementFoundException();
                })
                .block();
    }

    public Movie getMovieDetails(Long movieId) {

        logger.info("Movie Id => " + movieId);
        return webClient
                .build()
                .get()
//                .uri("http://localhost:5001/api/movies/" + movieId)
                .uri("http://MOVIE-DATA-SERVICE/api/movies/" + movieId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Movie.class)
                .block();
    }

    public MovieDetail getAllMovieDetails(Long movieId) {

        logger.info("Movie Id => " + movieId);
        Movie movie = getMovieDetails(movieId);
        return new MovieDetail(
                movieId,
                movie.getTitle(),
                movie.getDescription(),
                movie.getGenre(),
                getRatingsByMovieId(movieId),
                movie.getReviews()
        );

    }

}
