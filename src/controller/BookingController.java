package controller;

import java.util.EnumMap;
import model.AgeGroup;
import model.SeatStatus;
import model.ShowTimeBooking;


/**
 * Class used to get input info from movie goer to book tickets
 */
public class BookingController {

	/**
	 * Method to get the seats that movie goer wants to book
	 * @param n
	 * @param showTime
	 */
	public static boolean[][] getSeats(int n, ShowTimeBooking showTime) {
		boolean[][] layout = showTime.getLayout();
		boolean[][] selectedSeat = new boolean[layout.length][];
		
		while (true) {
			// Create all 2D boolean array of false with the same dimensions as layout
			for (int i = 0; i < layout.length; i++) {
				selectedSeat[i] = new boolean[layout[i].length];
				
				for (int j = 0; j < layout[i].length; j++)
					selectedSeat[i][j] = false;
			}
			
			System.out.println("Enter the seat numbers that you want to book (e.g. A1): ");
		
			for (int i = 0; i < n; i++) {
				int row = 0;
				String input;
				while(true){
					input = IO.readLine("");
					if(input.length()==2){
						int ascii = input.charAt(0);
						if((ascii>=65 && ascii<=90)||(ascii>=97 && ascii<=122)){
							ascii = input.charAt(1);
							if(ascii>=0 && ascii<=57){
								break;								
							}
						}
					}
					else if(input.length()==3){
						int ascii = input.charAt(0);
						if((ascii>=65 && ascii<=90)||(ascii>=97 && ascii<=122)){
							ascii = input.charAt(1);
							if(ascii>=0 && ascii<=57){
								ascii = input.charAt(2);
								if (ascii>=0 && ascii<=57){
									break;
								}
							}
						}
					}
					System.out.println("Invalid seat number entered!");
				}
				if (input.charAt(0)<96) {
					row = input.charAt(0) - 'A';
				}
				else{
					row = input.charAt(0) - 'a';
				}
				int col = Integer.parseInt(input.substring(1));
				selectedSeat[row][col - 1] = true;
			}
			
			if (showTime.checkAvail(selectedSeat)) { 
				break;
				
			} else {
				System.out.println("Unavailable seats selected");
				System.out.println("Please select seats again");
			}
		}
		
		return selectedSeat;
	}

	/**
	 * Method to get how many age groups are there and how many tickets for them
	 * @param n
	 */
	public static EnumMap<AgeGroup, Integer> getAgeGroupCount(int n) {
		System.out.println("How many of each age group?");
		
		EnumMap<AgeGroup, Integer> ageGroupCount = new EnumMap<AgeGroup, Integer>(AgeGroup.class);
		
		while (true) {
			int totalCount = 0;
			
			for (AgeGroup ageGroup: AgeGroup.values()) { 
			    int count = IO.readInt(ageGroup.getTag() + ": ");
			    totalCount += count;
			    ageGroupCount.put(ageGroup, count);
			}
			
			if (totalCount == n)
				break;
			else
				System.out.println("ERROR! Total people is not " + n);
		}
		
		return ageGroupCount;
	}

	/**
	 * Display seats for the ShowTime input
	 * @param showTime
	 */
	public static void displaySeats(ShowTimeBooking showTime) {
		SeatStatus[][] availSeats = showTime.getSeatAvailabilities();
		int textWidth = availSeats[0].length * 5 + 4;
		
		// Create Line String
		String line = "";
		for (int i =0; i< textWidth; i++)
			line += "-";
		
		// Create column headers
		String columnHeaders = "  ";
		
		for (int i = 0; i < availSeats[0].length; i++) {
			if (i < 10)
				columnHeaders += "  " + (i + 1) + "  ";	
			else
				columnHeaders += " " + (i + 1) + "  ";	
		}
		
		IO.displayMessageCentred("ENTRANCE", textWidth);
		
		System.out.println(line);
		System.out.println(columnHeaders);
		System.out.println(line);
		
		// Print rows of seats
		char row = 'A';
		
		for (SeatStatus[] availSeatRow: availSeats) {
			String rowString = "";
			rowString += row + " ";
			
			for (SeatStatus seatStatus: availSeatRow) {
				switch (seatStatus) {
					case TAKEN:
						rowString += "[ x ]";
						break;
						
					case EMPTY:
						rowString += "[   ]";
						break;
						
					case NO_SEAT:
						rowString += "     ";
						break;
				}
			}
			rowString += " " + row;
			System.out.println(rowString);
		   	row++;
		}
		
		System.out.println(line);
		System.out.println(columnHeaders);
		System.out.println(line);
		
		IO.displayMessageCentred("SCREEN", textWidth);
		
		IO.EnterToContinue();
	}


	/**
	 * Method to print out the details of the Booking
	 * @param ageGroupCount
	 * @param totalPrice
	 */
	public static void printBookingDetails(EnumMap<AgeGroup, Integer> ageGroupCount, double totalPrice) {
		IO.displayTitle("Booking Details");
		for (AgeGroup ageGroup: AgeGroup.values()) 
			System.out.println(ageGroup.getTag() + ": " + ageGroupCount.get(ageGroup));
		
		System.out.println("");
		System.out.println("Total Price (SGD, inclusive of GST): $" + String.format("%.2f", totalPrice));
		
		IO.EnterToContinue();
	}
}
