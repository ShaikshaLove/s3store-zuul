package io.s3soft.dto;

public class UserDto {
	private long userId;
	private String firstName;
	private String email;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public UserDto(long userId, String firstName,String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
