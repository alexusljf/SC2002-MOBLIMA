package controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import model.Cinema;
import model.Cineplex;
import model.DataManager;
import model.Movie;
import model.ShowTime;

/**
 * Class contains methods to edit ShowTimes
 */
public class ShowTimeEditController {

	/**
	 * Method to add new ShowTime
	 */
	public static void addShowTime() {
		Cinema cinema = readCinema();
		Movie movie = readMovie();
		LocalDateTime startDateTime = readStartDateTime();
		
		Duration duration = movie.getDuration();
		
		// Use null as the currentShowTime because current showtime has not been created yet
		if (checkClash(startDateTime, duration, cinema, null))
			System.out.println("ERROR: This show time clashes with another show time in the same cinema");
		else
			cinema.createShowTime(startDateTime, movie);
	}

	/**
	 * Method to update an existing ShowTime
	 */
	public static void updateShowTime() {
		// Get an input cinema, then prints all show times and prompts for a choice
		Cinema cinema = readCinema();
		ShowTime showTime = MenuController.getItemTag("Select a show time", cinema.getShowTimes());
		
		int option = MenuController.getMenuOption(
			"What would you want to update",
			"Start date & time",
			"Movie"
		);
		// Update the ShowTime's start date & time or movie
		switch(option) {
			case 1:
				LocalDateTime startDateTime = readStartDateTime();
				if (checkClash(startDateTime, showTime.getMovie().getDuration(), cinema, showTime))
					System.out.println("ERROR: This show time clashes with another show time in the same cinema");
				else
					showTime.setStartDateTime(startDateTime);
		        break;
					  
		    case 2:
		    	showTime.setMovie(readMovie());
				break;
		}
	}

	/**
	 * Method to remove existing ShowTime
	 */
	public static void removeShowTime() {
		Cinema cinema = readCinema();
		List<ShowTime> showTimeList = cinema.getShowTimes();
		ShowTime showTime = MenuController.getItemTag("Select a show time", showTimeList);
		showTime.remove();
	}

	/**
	 * Method to get a Cinema as input
	 */
	private static Cinema readCinema() {
		// Select a cineplex
		List<Cineplex> cineplexList = DataManager.getDatabase().getCineplexList();
		Cineplex cineplex = MenuController.getItemTag("Select a cineplex", cineplexList);
		
		// Select a cinema
		List<Cinema> cinemaList = cineplex.getCinemas();
		return MenuController.getItemTag("Select a cinema", cinemaList);
	}

	/**
	 * Method to get a Movie as input
	 */
	private static Movie readMovie() {
		// Select a movie
		List<Movie> movieList = DataManager.getDatabase().getMovieList();
		return MenuController.getItemTag("Select a movie", movieList);
	}

	/**
	 * Method to get a start date and time as input
	 */
	private static LocalDateTime readStartDateTime() {
		return IO.readDateTime("Enter start date & time (dd/mm/yyyy hh:mm): ");
	}

	/**
	 * Checks if the start date & time & duration for this movie clashes with any movie in the same cinema, that is not this current ShowTime
	 * @param startDateTime
	 * @param duration
	 * @param cinema
	 * @param currentShowTime
	 */
	public static boolean checkClash(LocalDateTime startDateTime, Duration duration, Cinema cinema, ShowTime currentShowTime) {
		for (ShowTime showTime: cinema.getShowTimes()) {
			LocalDateTime endDateTime = startDateTime.plus(duration);
			LocalDateTime oldShowTimeStart = showTime.getStartDateTime();
			LocalDateTime oldShowTimeEnd = oldShowTimeStart.plus(showTime.getMovie().getDuration());
			
			// Check if start times and end times have and clashes
			boolean isClash = (
				(oldShowTimeStart.isBefore(endDateTime) && !oldShowTimeStart.isEqual(endDateTime)) &&
				(startDateTime.isBefore(oldShowTimeEnd) && !startDateTime.isEqual(oldShowTimeEnd)) &&
				showTime != currentShowTime
			);
			
			// if there's a clash, it will return true, otherwise it returns false
			if (isClash)
				return true;
		}
		
		return false;
	}
}
