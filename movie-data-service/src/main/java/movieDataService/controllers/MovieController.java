package movieDataService.controllers;

import movieDataService.models.Movie;
import movieDataService.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/api/movies")
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;



    /**
     * CONSTRUCTOR TO INJECT MOVIE-SERVICE CLASS (DEPENDENCY INJECTION)
     * @param movieService THE MOVIE-SERVICE OBJECT
     */
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * API TO GET ALL MOVIES
     * @return LIST OF MOVIES PRESENT IN DATABASE
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMovies() {
        try {
            logger.info(System.getenv("SPRING_DATASOURCE_URL"));
            logger.info(System.getenv("SPRING_DATASOURCE_USERNAME"));
            logger.info(System.getenv("SPRING_DATASOURCE_PASSWORD"));
            List<Movie> data = movieService.getAllMovies();
            return Response.status(200).entity(data).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }



    /**
     * API TO GET MOVIE BY ITS ID
     * @param id THE ID OF THE MOVIE TO BE ACCESSED
     * @return THE REQUIRED MOVIE OBJECT
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getMovieById(@PathParam("id") long id) {
        try {
            logger.info("Movie Id: {}", id);
            Movie movie = movieService.getMovieById(id);
            return Response.status(200).entity(movie).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TO ADD A NEW MOVIE TO DATABASE
     * @param movie THE MOVIE OBJECT TO BE INSERTED INTO DB
     * @return THE INSERTED MOVIE DATA
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewMovie(Movie movie) {
        try {
            Movie addedMovie = movieService.addNewMovie(movie);
            return Response.status(200).entity(addedMovie).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TO UPDATE A MOVIE IN DB
     * @param movie THE UPDATED MOVIE DATA
     * @return MOVIE DATA AFTER UPDATING
     */
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMovie(Movie movie) {
        try {
            Movie updatedMovie = movieService.updateMovie(movie);
            return Response.status(200).entity(updatedMovie).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TO DELETE THE MOVIE IN DB BY ITS ID
     * @param movieId THE ID OF THE MOVIE TO BE DELETED
     * @return SUCCESS MESSAGE ON DELETION
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deleteMovie(@PathParam("id") Long movieId) {
        try {
            logger.info("Movie Id => " + movieId);
            movieService.deleteMovie(movieId);
            return Response.status(200).entity("Success: Movie Deleted").build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
