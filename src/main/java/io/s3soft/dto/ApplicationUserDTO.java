package io.s3soft.dto;
import java.io.Serializable;
public class ApplicationUserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 14544L;
	private String fullName;
	private String email;
	private String Password;
	private String conformPassword;
	private String role;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConformPassword() {
		return conformPassword;
	}
	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}
	@Override
	public String toString() {
		return "ApplicationUserDTO []";
	}
	public ApplicationUserDTO() {
		super();
	}
}
