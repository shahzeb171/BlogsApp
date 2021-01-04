package com.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.blogs.*"})
@EnableAutoConfiguration
public class BlogsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogsAppApplication.class, args);
	}

}
