package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class contains all the information of a showtime
 */
public class ShowTime implements Serializable, ItemTag, ShowTimeBooking {

	/**
	 * The cinema that has the ShowTime
	 */
	private Cinema cinema;

	/**
	 * The start date and time of the ShowTime
	 */
	private LocalDateTime startDateTime;

	/**
	 *  The movie for this ShowTime
	 */
	private Movie movie;

	/**
	 * All the bookings made for this ShowTime
	 */
	private ArrayList <Booking> bookings;

	/**
	 * Constructor for a ShowTime object for the given cinema, start date and time and movie
	 * @param cinema
	 * @param startDateTime
	 * @param movie
	 */
	protected ShowTime(Cinema cinema, LocalDateTime startDateTime, Movie movie) {
		this.cinema = cinema;
		this.bookings = new ArrayList<Booking>();
		this.startDateTime = startDateTime;
		this.movie = movie;
		movie.addShowTime(this);
	}

	/**
	 * Constructor for a Booking object for the given movie goer, selected seats and price of the booking.
	 * This booking is added to the ArrayList of bookings for this ShowTime
	 * @param movieGoer
	 * @param takenSeats
	 * @param price
	 * @return newBooking
	 */
	public Booking createBooking(MovieGoer movieGoer, boolean[][] takenSeats, double price ){
		Booking newBooking = new Booking(createTID(), movieGoer, takenSeats, price);
		this.bookings.add(newBooking);
		return newBooking;
	}

	/**
	 * This method will check the Seat Availability of a given ShowTime and return them as a 2D Array of SeatStatus objects
	 * @return seatAvail
	 */
	public SeatStatus[][] getSeatAvailabilities() {
		boolean [][] layout = getLayout();
		SeatStatus[][] seatAvail = new SeatStatus[layout.length][];
		
		for (int i = 0; i < layout.length; i++) {
			boolean[] row = layout[i];
			seatAvail[i] = new SeatStatus[row.length];
			
			for (int j = 0; j < row.length; j++) {
				seatAvail[i][j] = row[j] == true ? SeatStatus.EMPTY : SeatStatus.NO_SEAT;
			}
		}
		
		for (Booking booking: bookings) {
			for (Ticket t: booking.getTickets()) {
				int row = t.getRow();
				int col = t.getCol();
				
				if (seatAvail[row][col] == SeatStatus.EMPTY)
					seatAvail[row][col] = SeatStatus.TAKEN;
			}
		}
		
		return seatAvail;
	}

	/**
	 * This method will check the availability of the given selected seats
	 * @param selectedSeat
	 * @return true or false
	 */
	public boolean checkAvail(boolean [][] selectedSeat) {
		SeatStatus[][] availSeat = this.getSeatAvailabilities();
		
		for (int i = 0; i < availSeat.length; i++) {
			for (int j = 0; j < availSeat[i].length; j++) {
				SeatStatus seatStatus = availSeat[i][j];
				
				if (selectedSeat[i][j] == true && (seatStatus == SeatStatus.TAKEN || seatStatus == SeatStatus.NO_SEAT))
					return false;
			}
		}
		
		return true;
	}

	/**
	 * This method check if the ShowTime is already fully booked
	 * return true if the ShowTime is already fully booked, otherwise false
	 * @return true or false
	 */
	public boolean checkFull() {
		SeatStatus[][] availSeat = this.getSeatAvailabilities();
		for (int i = 0; i < availSeat.length; i++) {
			for (int j = 0; j < availSeat[i].length; j++) {
				if(availSeat[i][j] == SeatStatus.EMPTY)
					return false;
			}
		}
		
		return true;
	}

	/**
	 * Getter for the total sales of a ShowTime
	 * @return totalSales
	 */
	public double getTotalSales() {
		double totalSales = 0;
		
		for (Booking booking: bookings)
			totalSales += booking.getPrice();
		
		return totalSales;
	}

	/**
	 * This method generates a transaction id for a booking
	 * @return transaction
	 */
	public String createTID() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		String transaction = cinema.getCinemaCode() + LocalDateTime.now().format(formatter);
		// return the created booking transaction id
		return transaction;
	}

	/**
	 * Returns the date and time for the showtime, as well as the cinema and it's cinema code
	 * @return Date
	 */
	public String getTag() {
		return this.getDate() + "  " + this.getStartDateTime().toLocalTime() + " (" + this.getCinema().getCinemaCode() + ") "+this.getMovie().getTitle();
	}

	/**
	 * Getter for Seating Layout
	 * @return Layout
	 */
	public boolean[][] getLayout() {
		return cinema.getLayout();
	}

	/**
	 * Getter for the start date of a ShowTime
	 * @return LocalDate
	 */
	public LocalDate getDate() {
		return startDateTime.toLocalDate();
	}

	/**
	 * Getter for the start date and time of the ShowTime
	 * @return StartDateTime
	 */
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	/**
	 * Getter for the Movie of the ShowTime
	 * @return Movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * Getter for the ArrayList of bookings made for this ShowTime
	 * @return Bookings
	 */
	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	/**
	 * Getter for the ArrayList of bookings made for this ShowTime
	 * @param bookings
	 */
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	/**
	 * Getter for the Cinema for this ShowTime
	 * @return Cinema
	 */
	public Cinema getCinema() {
		return cinema;
	}

	/**
	 * Setter for the Cinema for this ShowTime
	 * @param cinema
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	/**
	 * Setter for the Movie of the ShowTime
	 * @param movie
	 */
	public void setMovie(Movie movie) {
		this.movie.getShowTimes().remove(this);
		this.movie = movie;
		movie.addShowTime(this);
	}

	/**
	 * Setter for the start date and time of the ShowTime
	 * @param startDateTime
	 */
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * This method removes the current ShowTime from the movie and the cinema
	 */
	public void remove() {
		this.movie.getShowTimes().remove(this);
		this.cinema.getShowTimes().remove(this);
	}
}
