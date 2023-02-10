package model;

/**
 * This is the interface for a showtime booking
 */
public interface ShowTimeBooking {
	/**
	 * This method will check the Seat Availability of a given showtime and return them as a 2D Array of SeatStatus objects
	 */
    public SeatStatus[][] getSeatAvailabilities();

	/**
	 * This method will check the availability of the given selected seats
	 * @param selectedSeat
	 */
	public boolean checkAvail(boolean [][] selectedSeat);

	/**
	 * This method will return the Seating Layout
	 */
	public boolean[][] getLayout();
}
