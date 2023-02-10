package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class contains the information for a Booking
 */
//
public class Booking implements Serializable {
	/**
	 * Transaction ID for the Booking
	 */
	//
	private String TID;
	/**
	 * Movie Goer that made the Booking
	 */
	//
	private MovieGoer movieGoer;
	/**
	 * ArrayList of Tickets to store the Tickets booked
	 */
	//
	private ArrayList<Ticket> tickets;
	/**
	 * Total Price of the Booking
	 */
	//
	private double price;

	/**
	 *Constructor for Booking, given input Transaction ID, Movie Goer, Selected Seats and Price of Ticket
	 * @param TID
	 * @param user
	 * @param takenSeats
	 * @param price
	 */
	//
	protected Booking(String TID, MovieGoer user, boolean[][] takenSeats, double price) {
		this.TID = TID;
		this.movieGoer = user;
		this.price = price;
		this.tickets = new ArrayList<Ticket>();
		
		// Iterate through the 2D Array to find which seats were selected
		for (int i = 0; i < takenSeats.length ; i++) {
			for(int j = 0; j < takenSeats[i].length; j++) {
				// If True, means selected and now occupied
				if(takenSeats[i][j] == true) {
					// Create a ticket with the i and j values
					Ticket newTicket = new Ticket(i, j);
					tickets.add(newTicket);
				}
			}
		}
	}

	/**
	 *Getter for TID
	 * @return
	 */
	//
	public String getTID() {
		return TID;
	}

	/**
	 *Setter for TID
	 * @param TID
	 */
	//
	public void setTID(String TID) {
		this.TID = TID;
	}

	/**
	 *Getter for MovieGoer
	 * @return
	 */
	//
	public MovieGoer getMovieGoer() {
		return movieGoer;
	}

	/**
	 *Setter for MovieGoer
	 * @param movieGoer
	 */
	//
	public void setMovieGoer(MovieGoer movieGoer) {
		this.movieGoer = movieGoer;
	}

	/**
	 *Getter for Tickets ArrayList
	 * @return
	 */
	//
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	/**
	 *Setter for Tickets ArrayList
	 * @param tickets
	 */
	//
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 *Getter for Price
	 * @return
	 */
	//
	public double getPrice() {
		return price;
	}

	/**
	 *Setter for Price
	 * @param price
	 */
	//
	public void setPrice(double price) {
		this.price = price;
	}
}
