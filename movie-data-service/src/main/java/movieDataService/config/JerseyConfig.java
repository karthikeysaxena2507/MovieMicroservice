package movieDataService.config;

import movieDataService.controllers.MovieController;
import movieDataService.controllers.ReviewController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(MovieController.class);
        register(ReviewController.class);
    }
}
