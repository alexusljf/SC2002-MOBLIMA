package model;

import java.io.Serializable;

/**
 *This class contains info for MovieGoer
 */
//
public class MovieGoer implements Serializable {
	/**
	 *Username of movie goer
	 */
	//
	private String username;
	/**
	 *Name of movie goer
	 */
	//
	private String name;
	/**
	 *Mobile number of movie goer
	 */
	//
	private Integer mobileNumber;
	/**
	 *Email address of movie goer
	 */
	//
	private String emailAddress;
	/**
	 *Password of movie goer
	 */
	//
	private String password;
	/**
	 *Constructor for a MovieGoer object with a given username, name, mobile number, email address and password
	 */
	//
	public MovieGoer(String username, String name, Integer mobileNumber, String emailAddress, String password) {
		this.username = username;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	/**
	 *This methods returns true if login using password is successful by comparing it with the password that was set. If not equal, return false.
	 * @param password
	 * @return
	 */
	//
	public boolean login(String password) {
		return password.equals(this.password);
	}

	/**
	 *This method returns the username of the user
	 * @return
	 */
	//
	public String getUsername() {
		return this.username;
	}

	/**
	 *This method returns the name of the user
	 * @return
	 */
	//
	public String getName() {
		return name;
	}

	/**
	 *This method sets the name of the movie goer
	 * @param name
	 */
	//
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *This method returns the mobile number of the movie user
	 * @return
	 */
	//
	public Integer getMobileNumber() {
		return mobileNumber;
	}

	/**
	 *This method sets the mobile number of the movie user
	 * @param mobileNumber
	 */
	//
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 *This method returns the email address of the movie user
	 * @return
	 */
	//
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 *This method sets the email address of the movie user
	 * @param emailAddress
	 */
	//
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 *This method sets the password of the movie user
	 * @param password
	 */
	//
	public void setPassword(String password) {
		this.password = password;
	}
}
