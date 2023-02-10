package model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *  Class contains the information for a cinema
 */
//
public class Cinema implements Serializable, ItemTag {

	// String cinema code to identify the cinema
	private String cinemaCode;

	// Seating layout of a cinema. 2D Array, True if seat is occupied, False if empty
	private boolean[][] layout;
	
	// CinemaClass of the cinema
	private CinemaClass cinemaClass;
	
	// ArrayList to store the show times for each cinema
	private ArrayList<ShowTime> showTimes = new ArrayList<ShowTime>();

	/**
	 *Constructor for cinema, takes in cinemaCode, seat layout and cinema class
	 * @param cinemaCode
	 * @param layout
	 * @param cinemaClass
	 */
	//
	public Cinema(String cinemaCode, boolean[][] layout, CinemaClass cinemaClass) {
		this.cinemaCode = cinemaCode;
		this.layout = layout;
		this.cinemaClass = cinemaClass;
	}

	/**
	 *Method to create a show time for a given start date time and a given movie
	 *Adds the created show time to the cinema's ArrayList of showtimes
	 * @param startDateAndTime
	 * @param movie
	 */
	//
	public void createShowTime(LocalDateTime startDateAndTime, Movie movie) {
		ShowTime showTime = new ShowTime(this, startDateAndTime, movie);
		this.showTimes.add(showTime);
	}

	/**
	 *Returns the cinema's cinema code and cinema class
	 * @return
	 */
	//
	public String getTag() {
		return cinemaCode + " (" + cinemaClass.getTag() + ")";
	}

	/**
	 *Getter for Cinema Code
	 * @return
	 */
	//
	public String getCinemaCode() {
		return cinemaCode;
	}

	/**
	 *Getter for Seating Layout
	 * @return
	 */
	//
	public boolean[][] getLayout() {
		return layout;
	}

	/**
	 *Getter for Cinema Class
	 * @return
	 */
	//
	public CinemaClass getCinemaClass() {
		return cinemaClass;
	}

	/**
	 *Getter for ArrayList of showtimes
	 * @return
	 */
	//
	public ArrayList<ShowTime> getShowTimes() {
		return this.showTimes;
	}
}


