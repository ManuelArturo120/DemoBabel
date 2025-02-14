package com.demo.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class SwaggerConfiguration {

      @Value("1")
      private String version;

      @Value("EMPLOYED")
      private String name;

      @Bean
      public OpenAPI myOpenAPI() {
            Server devServer = new Server();
            devServer.setUrl("http://localhost:8080");

            Contact contact = new Contact();
            contact.email("manuelarturo120@gmail.com");
            contact.name("Phoenix Team");

            License mitLicense = new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html");

            Tag tag = new Tag()
                    .name("demoBbael")
                    .description("microservicio BASE para la obtención de la oferta de maletas");

            Info info = new Info()
                    .title(name)
                    .version(version)
                    .contact(contact)
                    .description("API that EMPLEADOS")
                    .termsOfService("http://swagger.io/terms/")
                    .license(mitLicense);

            return new OpenAPI().info(info).servers(List.of(devServer)).tags(List.of(tag));
      }
}