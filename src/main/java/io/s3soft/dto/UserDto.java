package io.s3soft.dto;

public class UserDto {
	private long userId;
	private String firstName;
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
	public UserDto(long userId, String firstName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
	}
	
}
