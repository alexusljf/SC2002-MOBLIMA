package model;

import java.io.Serializable;

/**
 * This class contains all the information of a ticket
 */
public class Ticket implements Serializable {

	/**
	 * The row of the booked seat
	 */
	private int row;

	/**
	 * The column of the booked seat
	 */
	private int col;

	/**
	 * Constructor for a Ticket Object for the seat booked with a given row and column
	 * @param row
	 * @param col
	 */
	protected Ticket(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Getter for the row of the booked seat
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Getter for the column of the booked seat
	 * @return col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Setter for the row of the booked seat
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Setter for the column of the booked seat
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}
}
