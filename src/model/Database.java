package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class contains all the data of the application
 */
//
public class Database implements Serializable {
	/**
	 * HashMap for the cinema staff list, with the username of the cinema staff as the key
	 */
	//
	private HashMap<String, CinemaStaff> cinemaStaffList = new HashMap<String, CinemaStaff>();
	/**
	 * HashMap for the movie goer list, with the username of the movie goer as the key
	 */
	//
	private HashMap<String, MovieGoer> movieGoerList = new HashMap<String, MovieGoer>();
	/**
	 * The pricing scheme
	 */
	//
	private PriceOutline priceOutline = new PriceOutline();
	/**
	 * ArrayList to store the list of cineplexes
	 */
	//
	private ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
	/**
	 * ArrayList to store the list of movies
	 */
	//
	private ArrayList<Movie> movieList = new ArrayList<Movie>();

	/**
	 *This method checks whether the database contains the given cinema staff username
	 * @param username
	 * @return
	 */
	//
	public boolean checkCinemaStaffUsername(String username) {
		return cinemaStaffList.containsKey(username);
	}

	/**
	 *This method returns the CinemaStaff object corresponding to the username if the password is correct,
	 *Returns null if the username or password is incorrect
	 * @param username
	 * @param password
	 * @return
	 */
	//
	public CinemaStaff getCinemaStaff(String username, String password) {
		CinemaStaff cinemaStaff = cinemaStaffList.get(username);
		
		if (cinemaStaff != null && cinemaStaff.login(password))
			return cinemaStaff;
		else
			return null;
	}

	/**
	 *This method adds a new cinema staff to the database,
	 *returns true if the cinema staff was successfully added, otherwise false
	 * @param cinemaStaff
	 * @return
	 */
	//
	//
	public boolean addCinemaStaff(CinemaStaff cinemaStaff) {
		String username = cinemaStaff.getUsername();
		
		if (cinemaStaffList.containsKey(username)) {
			return false;
			
		} else {
			cinemaStaffList.put(username, cinemaStaff);
			return true;
		}
	}

	/**
	 *This method checks whether the database contains the given movie goer username,
	 *returns true if the username is in the database, otherwise false
	 * @param username
	 * @return
	 */
	//
	//
	public boolean checkMovieGoerUsername(String username) {
		return movieGoerList.containsKey(username);
	}

	/**
	 *This method returns the MovieGoer object corresponding to the username if the password is correct
	 *Returns null if the username or password is incorrect
	 * @param username
	 * @param password
	 * @return
	 */
	//
	//
	public MovieGoer getMovieGoer(String username, String password) {
		MovieGoer movieGoer = movieGoerList.get(username);
		
		if (movieGoer != null && movieGoer.login(password))
			return movieGoer;
		else
			return null;
	}

	/**
	 *This method adds a new movie goer to the database,
	 *returns true if the movie goer was successfully added, otherwise false
	 * @param movieGoer
	 * @return
	 */
	//
	//
	public boolean addMovieGoer(MovieGoer movieGoer) {
		String username = movieGoer.getUsername();
		
		if (movieGoerList.containsKey(username)) {
			return false;
			
		} else {
			movieGoerList.put(username, movieGoer);
			return true;
		}
	}

	/**
	 *Getter for the pricing scheme
	 * @return
	 */
	//
	public PriceOutline getPriceOutline() {
		return priceOutline;
	}

	/**
	 *Getter for the cineplex list
	 * @return
	 */
	//
	public ArrayList<Cineplex> getCineplexList() {
		return cineplexList;
	}

	/**
	 *Getter for the the movie list
	 * @return
	 */
	//
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	/**
	 *This method adds a cineplex to the movie list
	 * @param cine
	 */
	//
	public void addCineplex(Cineplex cine) {
		cineplexList.add(cine);
	}
}

