package com.django.product.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(name="kamal", email = "kamalrana03@gmail.com" , url = "kamalrana.web.app"),
                description = "rest api's for product",
                title= "api specification -kamalrana03@gmail.com",
                version = "1.0",
                license = @License(
                        name = "MIT",
                        url = "kamalrana.web.app"
                ),
                termsOfService = "Term of service"
        ),
        servers = {
                @Server(description = "local env", url="http://127.0.0.1:8080"),
                @Server(description = "prod env", url= "")
        }
)
public class OpenApiConfig {
}
