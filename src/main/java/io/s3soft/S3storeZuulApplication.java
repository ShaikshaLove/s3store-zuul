package io.s3soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class S3storeZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(S3storeZuulApplication.class, args);
	}
}
