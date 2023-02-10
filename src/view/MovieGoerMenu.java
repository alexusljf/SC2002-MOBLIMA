package view;

import model.DataManager;
import model.MovieGoer;
import controller.IO;
import controller.MenuController;

/**
 * Main menu for movie goers
 * Starts with a login/signup menu for the user
 */
public class MovieGoerMenu implements Menu {
	
	/**
	 * The MovieGoer accessing this menu
	 */
	private MovieGoer movieGoer;
	
	/**
	 * Execute() method to display the menu
	 */
	public void execute() {
		while (this.movieGoer == null) {
		System.out.println("=============================");
		System.out.println("|      Movie Goer Menu      |");
		System.out.println("=============================");
			int option = MenuController.getMenuOption(
				"Please select an option",
				"Sign up",
				"Login",
				"Exit"
			);
			
			switch (option) {
				case 1:
					this.movieGoer = signupMovieGoer();
					break;
					
				case 2:
					this.movieGoer = loginMovieGoer();
					break;
					
				case 3:
					Driver.goBack();
					return;
			}
		}
		// After logging in/signing up, display the menu for movie goer's functions
		displayMenu();
	}
	
	/**
	 * Display the menu for movie goer's functions
	 */
	private void displayMenu() {
		System.out.println("Welcome " + movieGoer.getName() + "!");
		int option = MenuController.getMenuOption(
			"Enter your choice: ",
			"View movie showtimes",
			"Book a ticket",
			"View movie details",
			"List top 5 movies",
			"View booking history",
			"Exit"
		);
		
		switch (option) {
			case 1:
				Driver.addMenu(new ShowTimeMenu());
				break;
				
			case 2:
				Driver.addMenu(new BookingMenu(movieGoer));
				break;
				
			case 3:
				Driver.addMenu(new MovieMenu(movieGoer));
				break;
				
				
			case 4:
				Driver.addMenu(new TopMoviesMenu());
				break;
				
			case 5:
				Driver.addMenu(new BookingHistoryMenu(movieGoer));
				break;
				
			case 6:
				Driver.goBack();
				break;
		}
	}
	
	/**
	 * Method for movie goers to create new accounts
	 * @return movieGoer account
	 */
	public static MovieGoer signupMovieGoer() {
		String username = IO.readLine("Enter your Username: ");
		
		if (DataManager.getDatabase().checkMovieGoerUsername(username)) {
			System.out.println("ERROR: User with that username already exists");
			return null;
		}
		
		String name = IO.readLine("Enter your Name: ");
		
		int mobileNumber = IO.readInt("Enter your Mobile Number: ");
		String emailAddress = IO.readLine("Enter your Email Address: ");
		
		String password1 = "", password2;
		
		while (true) {
			password1 = IO.readLine("Enter your Password: ");
			password2 = IO.readLine("Confirm Password: ");
			
			if (password1.equals(password2))
				break;
			else
				System.out.println("ERROR: Passwords do not match");
		}
		
		MovieGoer movieGoer = new MovieGoer(username, name, mobileNumber, emailAddress, password1);
		
		if (!DataManager.getDatabase().addMovieGoer(movieGoer))
			System.out.println("ERROR: A user with that username already exists");
		
		return movieGoer;
	}
	
	/**
	 * Method for movie goers to sign in
	 * @return the movieGoer account
	 */
	public static MovieGoer loginMovieGoer() {
		String username = IO.readLine("Username: ");
		
		if (!DataManager.getDatabase().checkMovieGoerUsername(username)) {
			System.out.println("ERROR: A user with username does not exist");
			return null;
		}
		
		String password = IO.readLine("Password: ");
		
		MovieGoer movieGoer = DataManager.getDatabase().getMovieGoer(username, password);
		
		if (movieGoer == null)
			System.out.println("ERROR: Wrong password");
		
		return movieGoer;
	}
}
