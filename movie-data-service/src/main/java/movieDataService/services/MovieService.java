package movieDataService.services;

import movieDataService.exceptions.BusinessException;
import movieDataService.models.Movie;
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
        Movie existingMovie = movieRepository.findByTitle(movie.getTitle());
        if(existingMovie == null) {
            Movie newMovie = new Movie(movie.getTitle(), movie.getDescription(), movie.getGenre(), new ArrayList<>());
            return movieRepository.save(newMovie);
        }
        else throw new BusinessException("606", "Movie with given title already exists");
    }

    public Movie getMovieById(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if(movie != null) return movie;
        else throw new BusinessException("601", "Movie with id = " + movieId + " Does not exists");
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).orElse(null);
        if(existingMovie != null) return movieRepository.save(movie);
        else throw new BusinessException("601", "Movie with id = " + movie.getId() + " Does not exists");
    }

    public void deleteMovie(Long movieId) {
        if(movieId == null) throw new BusinessException("603", "Movie Id cannot be null");
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if(movie != null) movieRepository.deleteById(movieId);
        else throw new BusinessException("601", "Movie with id = " + movieId + " Does not exists");
    }
}
