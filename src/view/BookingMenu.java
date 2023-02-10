package view;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

import model.AgeGroup;
import model.Booking;
import model.Cineplex;
import model.DataManager;
import model.Movie;
import model.MovieGoer;
import model.PriceOutline;
import model.ShowTime;
import model.ShowingStatus;
import controller.BookingController;
import controller.IO;
import controller.MenuController;

/**
 * Controller for movie goer to make bookings
 */
public class BookingMenu implements Menu {

	/**
	 * The movie goer who wants to do the booking
	 */
	private MovieGoer movieGoer;
	
	/**
	 *  Showtime that the movie goer wants
	 */
	private ShowTime showTime;
	
	
	/**
	 * Constructor for BookingMenu
	 * @param movieGoer the movieGoer that is making the booking
	 */
	public BookingMenu(MovieGoer movieGoer) {
		this.movieGoer = movieGoer;
	}

	/**
	 * Execute() method to display the menu
	 */
	public void execute() {		
		System.out.println("===========================");
		System.out.println("|      Book a Ticket      |");
		System.out.println("===========================");

		this.showTime = selectShowTime();
		if (showTime.checkFull()) {
			System.out.println("This show time is fully booked");
			Driver.goBack();
			return;
		}
		
		BookingController.displaySeats(showTime);
		
		int number = IO.readInt("How many seats would you like to book: ");
		if (number > 0) {
		boolean[][] selectedSeats = BookingController.getSeats(number, showTime);
		EnumMap<AgeGroup, Integer> ageGroupCount = BookingController.getAgeGroupCount(number);
		double totalPrice = calculatePrice(ageGroupCount);
		
		boolean confirm = IO.readBoolean("Confirm booking (y/n): ", "y", "n");
		
		if (confirm) {
			// Create a booking with input data from user
			Booking booking = showTime.createBooking(movieGoer, selectedSeats, totalPrice);
			BookingController.displaySeats(showTime);
			// Print out the booking details
			System.out.println("Ticket Booked successful!");
			System.out.println("Transaction ID: " + booking.getTID());
			BookingController.printBookingDetails(ageGroupCount, totalPrice);
			
		} else {
			System.out.println("Booking cancelled");
		}
	}
		// Go back to previous menu
		Driver.goBack();
	}
	

	/**
	 * Method to collect input data from user for the booking
	 * @return a showtime
	 */
	private ShowTime selectShowTime() {
		// Prompts user to select a cineplex, movie and then showtime
		List<Cineplex> cineplexList = DataManager.getDatabase().getCineplexList();
		Cineplex cineplex = MenuController.getItemTag("Select a Cineplex", cineplexList);
	
		// Retrieve show times by movie
		List<ShowTime> showTimeList = cineplex.getShowTimes();
		Map<Movie, List<ShowTime>> showTimesByMovie = showTimeList.stream().collect(Collectors.groupingBy(ShowTime::getMovie));
		
		List<Movie> movieList = new ArrayList<Movie>();
		
		for (Movie movie: showTimesByMovie.keySet()) {
			ShowingStatus showingStatus = movie.getShowingStatus();
			if (showingStatus == ShowingStatus.PREVIEW || showingStatus == ShowingStatus.NOW_SHOWING)
				movieList.add(movie);
		}
		
		Movie movie = MenuController.getItemTag("Select a movie", movieList);
		
		List<ShowTime> movieShowTimeList = showTimesByMovie.get(movie);
		Comparator<ShowTime> dateComparator = Comparator.comparing(ShowTime::getStartDateTime);
		movieShowTimeList.sort(dateComparator);
		ShowTime showTime = MenuController.getItemTag("Select a Show Time", movieShowTimeList);
		
		return showTime;
	}
	
	/**
	 * Ticket price calculation done by this method
	 * @param ageGroupCount an EnumMap consisting of the AgeGroups and how many of each group there are
	 * @return the total price of the booking
	 */
	public double calculatePrice(EnumMap<AgeGroup, Integer> ageGroupCount) {
		PriceOutline priceOutline = DataManager.getDatabase().getPriceOutline();
		
		// Initialise price as 0
		double totalPrice = 0;
		
		for (AgeGroup ageGroup : AgeGroup.values()) {
			totalPrice += ageGroupCount.get(ageGroup) * priceOutline.getPrice(
				showTime.getDate(),
				showTime.getCinema().getCinemaClass(),
				ageGroup,
				showTime.getMovie().getMovieFormat()
			);
		}
		
		totalPrice *= 1.07;
		return totalPrice;
	}
}
