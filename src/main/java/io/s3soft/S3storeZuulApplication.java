package io.s3soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class S3storeZuulApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(S3storeZuulApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		  registry.addMapping("/**")
		          .allowedOrigins("*")
		          .allowedMethods("GET","POST","DELETE","PUT");
	}


}
