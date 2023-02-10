package view;

import java.util.ArrayList;
import java.util.List;

import model.Booking;
import model.Cinema;
import model.Cineplex;
import model.DataManager;
import model.MovieGoer;
import model.ShowTime;
import controller.ListController;

/**
 * This class displays the booking history of the movie goer
 */
public class BookingHistoryMenu implements Menu {
	private MovieGoer movieGoer;
	
	/**
	 * Constructor for BookingHistoryMenu
	 * @param movieGoer the movie goer that is checking his booking history
	 */
	public BookingHistoryMenu(MovieGoer movieGoer) {
		this.movieGoer = movieGoer;
	}

	/**
	 * Execute() method to display the menu
	 */
	public void execute() {
		System.out.println("==================================");
		System.out.println("|      View Booking History      |");
		System.out.println("==================================");
		ListController.displayList("Booking History", getBookingHistory(), "No bookings made");
		Driver.goBack();
	}
	
	/**
	 * Method to get booking history
	 * @return a list of booking history strings
	 */
	public List<String> getBookingHistory() {
		List<String> bookingHistoryStrings = new ArrayList<String>();
		// Iterate through for every cineplex, for every cinema, for every showtime, for every booking. Add the bookings to the List
		for (Cineplex cineplex: DataManager.getDatabase().getCineplexList()) {
			for (Cinema cinema: cineplex.getCinemas()) {
				for (ShowTime showTime: cinema.getShowTimes()) {
					for (Booking booking: showTime.getBookings()) {
						if (booking.getMovieGoer() == movieGoer) {
							bookingHistoryStrings.add(
								"Transaction ID: " + booking.getTID() + "\n" +
								"Price: $" + String.format("%.2f", booking.getPrice()) + "\n" +
								"Movie: " + showTime.getMovie().getTitle() + "\n" +
								"Show time: " + showTime.getTag() + "\n" +
								"Cineplex: " + cineplex.getName() + "\n"
							);
						}
					}
				}
			}
		}
		return bookingHistoryStrings;
	}
}
