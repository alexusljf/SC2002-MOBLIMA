package model;

import java.io.Serializable;

/**
 * This class contains info for Cinema Staff
 */
//
public class CinemaStaff implements Serializable {
	/**
	 * User Name for the Cinema Staff
	 */
	//
	private String username;
	/**
	 * Password for the Cinema Staff
	 */
	//
	private String password;

	/**
	 *Constructor for CinemaStaff object with a given username and password
	 * @param username
	 * @param password
	 */
	//
	public CinemaStaff(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 *Method to login, compares input password with the password. Return true if they match, else return false
	 * @param password
	 * @return
	 */
	//
	public boolean login(String password) {
		return password.equals(this.password);
	}

	/**
	 *Getter for User Name
	 * @return
	 */
	//
	public String getUsername() {
		return this.username;
	}

	/**
	 *Setter for User Name
	 * @param username
	 */
	//
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 *Getter for Password
	 * @return
	 */
	//
	public String getPassword() {
		return this.password;
	}

	/**
	 *Setter for Password
	 * @param password
	 */
	//
	public void setPassword(String password) {
		this.password = password;
	}
}
