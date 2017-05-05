package org.restWebService.BPlayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	registry.addMapping("/bUser/register");
                registry.addMapping("/login").exposedHeaders("Authorization");
                registry.addMapping("/bUser/findListBUserToBeAdministrator/*");
                registry.addMapping("/bUser/addBUserToOrganization/*/*");
                registry.addMapping("/organization/create");
                registry.addMapping("/organization/findAdministratedByPrincipal");
                registry.addMapping("/organization/findDetailedOrganizationByIdOrganization/*");
                registry.addMapping("/team/create");
                registry.addMapping("/team/findTeamsByIdOrganization/*");
                registry.addMapping("/player/create");
                registry.addMapping("/player/findPlayersByIdOrganization/*");
            }
        };
    }
    
}
