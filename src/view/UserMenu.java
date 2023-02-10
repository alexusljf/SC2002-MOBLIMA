package view;

import controller.MenuController;

/**
 * Main menu for the MOBLIMA Program, users can choose if they are a Movie Goer or a Cinema Staff
 */
public class UserMenu implements Menu {
	
	/**
	 * Execute() method to display the menu
	 */
	public void execute() {
		System.out.println("===================================");
		System.out.println("|             MOBLIMA             |");
		System.out.println("|      By SC2002 SS9 Group 3      |");
		System.out.println("===================================");
		System.out.println("Welcome to MOBLIMA!");
		int option = MenuController.getMenuOption(
			"Are you a Movie Goer or a Cinema Staff? Enter your choice: ",
			"Movie Goer",
			"Cinema Staff",
			"Exit"
		);
		
		switch (option) {
			case 1:
				Driver.addMenu(new MovieGoerMenu());
				break;
				
			case 2:
				Driver.addMenu(new CinemaStaffMenu());
				break;
				
			case 3:
				Driver.addMenu(new RateAppMenu());
				break;
		}
	}
}
