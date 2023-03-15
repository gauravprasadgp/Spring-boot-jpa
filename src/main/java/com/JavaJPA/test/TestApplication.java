package com.JavaJPA.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableJpaRepositories
@EnableAsync
public class TestApplication {

  private static final long MAX_AGE_SECS = 100000;

  public static void main(String[] args) {
    SpringApplication.run(TestApplication.class, args);
  }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/**").allowedOrigins("*");
        }
      };
    }
    @Bean("taskThreadPool")
    public Executor asyncTaskExecutors(){
      ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
      threadPoolTaskExecutor.setCorePoolSize(100);
      threadPoolTaskExecutor.setMaxPoolSize(200);
      threadPoolTaskExecutor.setQueueCapacity(1000);
      threadPoolTaskExecutor.setThreadNamePrefix("TaskThreadPool-");
      threadPoolTaskExecutor.initialize();
      return threadPoolTaskExecutor;
    }
	}
