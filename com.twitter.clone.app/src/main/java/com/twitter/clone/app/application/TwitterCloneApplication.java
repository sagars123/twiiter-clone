package com.twitter.clone.app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.twitter.clone"}, exclude = {
                SecurityAutoConfiguration.class})
@EntityScan(basePackages = "com.twitter.clone.dao")
@EnableJpaRepositories(basePackages = "com.twitter.clone.dao")
public class TwitterCloneApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(TwitterCloneApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(TwitterCloneApplication.class);
  }
}
