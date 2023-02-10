package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.AgeGroup;
import model.CinemaClass;
import model.DateType;
import model.MovieFormat;
import model.PriceOutline;

/**
 * This class displays the form for the modification of the pricing scheme and the holiday list.
 */
public class PriceOutlineEditController {

	/**
	 * Reads an input for new base price then update base price with the input
	 * @param priceOutline
	 */
	public static void updateBasePrice(PriceOutline priceOutline) {
		System.out.println("Current Base Price: " + priceOutline.getBasePrice());
		double basePrice = IO.readDouble("Base Price: ");
		priceOutline.setBasePrice(basePrice);
	}

	/**
	 * Switch block to update the different multipliers
	 * @param priceOutline
	 */
	public static void updateMultipliers(PriceOutline priceOutline) {
		int option = MenuController.getMenuOption(
			"Which multiplier do you want to update?",
			"Cinema Class",
			"Age Group",
			"Movie Type",
			"Date Type"
		);
		
		switch (option) {
			case 1:
				updateCinemaClassMultiplier(priceOutline);
				break;
				
			case 2:
				updateAgeGroupMultiplier(priceOutline);
				break;
				
			case 3:
				updateMovieTypeMultiplier(priceOutline);
				break;
				
			case 4:
				updateDateTypeMultiplier(priceOutline);
				break;
		}
	}

	/**
	 * Method to update Holidays
	 * @param priceOutline
	 */
	public static void updateHolidays(PriceOutline priceOutline) {
		int option = MenuController.getMenuOption(
			"What would you like to do?",
			"Add a Holiday",
			"Remove a Holiday"
		);
		switch (option) {
			case 1:
				addHoliday(priceOutline);
				break;
				
			case 2:
				removeHoliday(priceOutline);
				break;
		}
	}

	/**
	 * Method to update CinemaClass
	 * @param priceOutline
	 */
	private static void updateCinemaClassMultiplier(PriceOutline priceOutline) {
		CinemaClass cinemaClass = MenuController.getItemTag("Select a cinema class", CinemaClass.values());
		System.out.println("Current multiplier: " + priceOutline.getCinemaMultiplier(cinemaClass));
		double cinemaMultiplier = IO.readDouble("Multiplier: ");
		priceOutline.setCinemaMultiplier(cinemaClass, cinemaMultiplier);
	}

	/**
	 * Method to update AgeGroup
	 * @param priceOutline
	 */
	private static void updateAgeGroupMultiplier(PriceOutline priceOutline) {
		AgeGroup ageGroup = MenuController.getItemTag("Select an age group", AgeGroup.values());
		System.out.println("Current multiplier: " + priceOutline.getAgeMultiplier(ageGroup));
		double ageMultiplier = IO.readDouble("Multiplier: ");
		priceOutline.setAgeMultiplier(ageGroup, ageMultiplier);
	}

	/**
	 * Method to update MovieType
	 * @param priceOutline
	 */
	private static void updateMovieTypeMultiplier(PriceOutline priceOutline) {
		MovieFormat movieType = MenuController.getItemTag("Select a movie type", MovieFormat.values());
		System.out.println("Current multiplier: " + priceOutline.getMovieMultiplier(movieType));
		double movieMultiplier = IO.readDouble("Multiplier: ");
		priceOutline.setMovieMultiplier(movieType, movieMultiplier);
	}

	/**
	 * Method to update DateType
	 * @param priceOutline
	 */
	private static void updateDateTypeMultiplier(PriceOutline priceOutline) {
		DateType dateType = MenuController.getItemTag("Select a cinema class", DateType.values());
		System.out.println("Current multiplier: " + priceOutline.getDateMultiplier(dateType));
		double dateMultiplier = IO.readDouble("Multiplier: ");
		priceOutline.setDateMultiplier(dateType, dateMultiplier);
	}

	/**
	 * Method to add a holiday to the PriceOutline
	 * @param priceOutline
	 */
	private static void addHoliday(PriceOutline priceOutline) {
		LocalDate holidayDate = IO.readDate("Holiday date (dd/mm/yyyy): ");
		priceOutline.getHolidayDates().add(holidayDate);
	}

	/**
	 * Method to remove a holiday from the pricing scheme
	 * @param priceOutline
	 */
	private static void removeHoliday(PriceOutline priceOutline) {
		List<LocalDate> holidayDates = priceOutline.getHolidayDates();
		int size = holidayDates.size();
		String[] holidayDateStrings = new String[size];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for (int i = 0; i < size; i++)
			holidayDateStrings[i] = holidayDates.get(i).format(formatter);
		
		int option = MenuController.getMenuOption("Select a holiday date", holidayDateStrings);
		LocalDate selectedHolidayDate = holidayDates.get(option - 1);
		priceOutline.getHolidayDates().remove(selectedHolidayDate);
	}
}
