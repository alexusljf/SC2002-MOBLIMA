package controller;

import java.io.Console;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Helper method for all our Input Output functions
 */
public class IO {

	/**
	 * Displays Title
	 * @param title
	 */
	public static void displayTitle(String title) {
		System.out.println(title);
		
		String line = "";
		
		for (int i = 0; i < title.length(); i++)
			line += "-";
		
		System.out.println(line);
	}
	
	// Displays input message in the centre, with input width of space for the message to be centred in

	/**
	 * Displays input message in the centre, with input width of space for the message to be centred in
	 * @param message
	 * @param width
	 */
	public static void displayMessageCentred(String message, int width) {
		String space = "";
		for (int i = 0; i < (width - message.length()) / 2; i++)
			space += " ";
		
		System.out.println(space + message);
	}
	

	/**
	 * Helper method to print out a message, then read an input
	 * @param message
	 */
	public static String readLine(String message) {
		System.out.print(message);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	/**
	 * Helper method to print out a message, then read an input int
	 * @param message
	 */
	public static int readInt(String message) {
		while (true) {
			try {
				System.out.print(message);
				Scanner sc = new Scanner(System.in);
				return sc.nextInt();
				
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer");
			}
		}
	}

	/**
	 * Helper method to print out a message, then read an input double
	 * @param message
	 */
	public static double readDouble(String message) {
		while (true) {
			try {
				System.out.print(message);
				Scanner sc = new Scanner(System.in);
				return sc.nextDouble();
				
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number");
			}
		}
	}
	

	/**
	 * Helper method to print out a message, then compares the input with the true and false Strings
	 * @param message
	 * @param trueString
	 * @param falseString
	 */
	public static boolean readBoolean(String message, String trueString, String falseString) {
		while (true) {
			System.out.print(message);
			String input = readLine("");
			
			if (input.equals(trueString))
				return true;
			else if (input.equals(falseString))
				return false;
			
			System.out.println("ERROR: Invalid input (input should be " + trueString + " or " + falseString + ")");
		}
	}


	/**
	 * Helper method to print out a message, then reads in an input for date and time in the format: dd/mm/yyyy hh:mm
	 * @param message
	 */
	public static LocalDateTime readDateTime(String message) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	    
	    while (true) {
		    try {
		    	String dateTimeString = readLine(message);
		    	return LocalDateTime.parse(dateTimeString, formatter);
		    	
		    } catch (DateTimeParseException e) {
		    	System.out.println("Please enter a valid date time of format: dd/mm/yyyy hh:mm");
		    }
	    }
	}


	/**
	 * Helper method to print out a message, then reads in an input for date in the format: "dd/MM/yyyy"
	 * @param message
	 */
	public static LocalDate readDate(String message) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		while (true) {
		    try {
		    	String dateString = readLine(message);
		    	return LocalDate.parse(dateString, formatter);
		    	
		    } catch (DateTimeParseException e) {
		    	System.out.println("Please enter a valid date of format: dd/mm/yyyy");
		    }
	    }
	}
	

	/**
	 * Helper method to print out a message, then read an input int for duration of Movie in minutes
	 * @param message
	 */
	public static Duration readDuration(String message) {
		int durationMinutes = readInt(message);
		// use .ofMinutes to return a Duration object with the input minutes
		return Duration.ofMinutes(durationMinutes);
	}

	/**
	 * Just prompts user to press enter to continue
	 */
	public static void EnterToContinue() {
		System.out.println("Press Enter to Continue...");
		Scanner sc = new Scanner(System.in);
		// use sc.nextLine() to consume the enter
		sc.nextLine();
	}
}
