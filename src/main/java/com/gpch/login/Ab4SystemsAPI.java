package com.gpch.login;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.builder.SpringApplicationBuilder;
        import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Ab4SystemsAPI extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Ab4SystemsAPI.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Ab4SystemsAPI.class);
    }
}