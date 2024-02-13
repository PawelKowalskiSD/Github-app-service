package com.pawel.git_app.client.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition (
        info = @Info(
        contact = @Contact(
                name = "Pawel",
                email = "kowalski.pawel.sd@gmail.com"
        ),
                description = "The application has one endpoint where," +
                        " after entering the username from github," +
                        " it searches for all repositories that are not forks",

                title = "Github Application",
                version = "v1.0.0.1"
        ),
        servers = {
                @Server(
                        description = "Localhost",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerConfig {
}
