package io.s3soft.api.consumer;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author shaiksha
 *
 */

public class User implements Serializable,Comparable<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 73L;
	
	private long userId;
	private boolean enabled;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<String> roles;
	private Date accountCreated;
	private Date modifiedDate;


	public Date getAccountCreated() {
		return accountCreated;
	}

	public void setAccountCreated(Date accountCreated) {
		this.accountCreated = accountCreated;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}




	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int compareTo(User o) {
		return (int) (this.getUserId()-o.getUserId());
	}

	public User() {
		super();
		this.enabled=false;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", enabled=" + enabled + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", roles=" + roles + ", accountCreated="
				+ accountCreated + ", modifiedDate=" + modifiedDate + "]";
	}

	 
}
