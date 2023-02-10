package view;

import model.CinemaStaff;
import model.DataManager;
import controller.IO;
import controller.MenuController;

/**
 * This class will be the menu for CinemaStaff
 * It will first prompt for login
 */
public class CinemaStaffMenu implements Menu {
	
	/**
	 * CinemaStaff object for the signed in staff
	 */
	private CinemaStaff cinemaStaff;
	
	/**
	 * Execute() method to run the menu
	 */
	public void execute() {
		while (this.cinemaStaff == null) {
			int option = MenuController.getMenuOption(
				"Please select an option",
				"Login",
				"Exit"
			);
			
			switch (option) {
				case 1:
					this.cinemaStaff = loginCinemaStaff();
					break;
					
				case 2:
					Driver.goBack();
					return;
			}
		}
		
		displayMenu();
	}
	
	/**
	 * This method displays the main menu for cinema staff
	 */
	private void displayMenu() {
		System.out.println("===============================");
		System.out.println("|      Cinema Staff Menu      |");
		System.out.println("===============================");
		System.out.println("Welcome " + cinemaStaff.getUsername() + "!");
		int option = MenuController.getMenuOption(
			"Enter your choice: ",
			"Modify Movie Listings",
			"Modify Cinema Showtimes",
			"Modify Ticket Pricing Scheme",
			"List the Top 5 Movies",
			"Exit"
		);
		
		switch (option) {
			case 1:
				Driver.addMenu(new MovieEditMenu());
				break;
				
			case 2:
				Driver.addMenu(new ShowTimeEditMenu());
				break;
				
			case 3:
				Driver.addMenu(new PriceOutlineEditMenu());
				break;
				
			case 4:
				Driver.addMenu(new TopMoviesMenu());
				break;
				
			case 5:
				Driver.goBack();
				break;
		}
	}

	/**
	 * Method for CinemaStaff to login
	 */
	public static CinemaStaff loginCinemaStaff() {
		String username = IO.readLine("Enter your Username: ");
		
		// Check if there is a user with that username
		// If no, print error message and return null (go back to menu)
		if (!DataManager.getDatabase().checkCinemaStaffUsername(username)) {
			System.out.println("ERROR: A user with username does not exist");
			return null;
		}
		
		String password = IO.readLine("Enter your Password: ");
		
		CinemaStaff cinemaStaff = DataManager.getDatabase().getCinemaStaff(username, password);
		// Retrieve a cinemaStaff with the same username and password, if null that means wrong password
		if (cinemaStaff == null)
			System.out.println("ERROR: Wrong password");

		return cinemaStaff;
	}
}