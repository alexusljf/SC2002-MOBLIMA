package model;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *This class contains all the information of a cineplex
 */
//
public class Cineplex implements Serializable, ItemTag {
	/**
	 * ArrayList of cinemas in the cineplex
	 */
	//
	private ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
	/**
	 * Name of the cineplex
	 */
	//
	private String name;

	/**
	 *Constructor for Cineplex with the given name
	 * @param name
	 */
	//
	public Cineplex(String name) {
		this.name = name;
	}

	/**
	 *Creates a cinema and adds it to the cineplex's cinema list with the cinema code, layout and class of the cinema
	 * @param cinemaCode
	 * @param layout
	 * @param cinemaClass
	 */
	//
	public void createCinema(String cinemaCode, boolean[][] layout, CinemaClass cinemaClass) {
		Cinema cinema = new Cinema(cinemaCode, layout, cinemaClass);
		this.cinemas.add(cinema);
	}

	/**
	 *Getter for ArrayList of cinemas in the cineplex
	 * @return
	 */
	//
	public ArrayList<Cinema> getCinemas() {
		return cinemas;
	}

	/**
	 *Getter for Cineplex object type
	 * @return
	 */
	//
	public String getTag() {
		return name;
	}

	/**
	 *Getter for Cineplex name
	 * @return
	 */
	//
	public String getName() {
		return name;
	}

	/**
	 *Getter for the list of show times in all the cinemas in cineplex
	 * @return
	 */
	//
	public ArrayList<ShowTime> getShowTimes() {
		ArrayList<ShowTime> showTimes = new ArrayList<ShowTime>();
		
		for (Cinema cinema: cinemas)
			showTimes.addAll(cinema.getShowTimes());

		return showTimes;
	}

	/**
	 *Method to add a cinema to the cineplex, by adding it to the array list of cinemas
	 * @param cine
	 */
	//
	public void addCinema(Cinema cine){
		cinemas.add(cine);
	}
}
