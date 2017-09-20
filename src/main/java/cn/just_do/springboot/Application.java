package cn.just_do.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.*;

@EnableScheduling
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
	}

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
}
