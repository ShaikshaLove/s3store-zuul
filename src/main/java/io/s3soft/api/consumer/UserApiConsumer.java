package io.s3soft.api.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.s3soft.dto.SuccessResponse;

@FeignClient(name="user-api",url="https://s3-registration-service.herokuapp.com")
public interface UserApiConsumer {
	@GetMapping("/users/{userName}")
	public SuccessResponse<User> getUser(@PathVariable("userName")String userName);
}
