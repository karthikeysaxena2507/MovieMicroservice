package movieDataService.services;

import movieDataService.models.Movie;
import movieDataService.models.Review;
import movieDataService.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    Logger logger = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository movieRepository;

    @Autowired
    private MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addNewMovie(Movie movie) {
        List<Review> reviews = new ArrayList<>();
        Movie newMovie = new Movie(movie.getTitle(), movie.getDescription(), movie.getGenre(), reviews);
        return movieRepository.save(newMovie);
    }

    public Movie getMovieById(long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if(movie != null) {
            return movie;
        }
        return new Movie();
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
