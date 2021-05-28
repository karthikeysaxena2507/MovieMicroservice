
package userService.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import userService.controllers.UserController;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserController.class);
    }
}