package userService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import userService.models.MovieDetail;
import userService.services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("/movies")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieDetailsById(@PathParam("id") Long id) {
        try {
            MovieDetail movieDetails = userService.getMovieDetailsById(id);
            return Response.status(200).entity(movieDetails).build();
        }
        catch(Exception e) {
            return Response.status(500).entity("Unknown Error").build();
        }
    }

}
