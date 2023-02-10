package view;

import controller.MenuController;
import controller.ShowTimeController;
import controller.ShowTimeEditController;

/**
 * Menu for cinema staff to edit cinema showtimes
 */
public class ShowTimeEditMenu implements Menu {

	/**
	 * Execute() method to display the menu
	 */
	public void execute() {
		while (true) {
			System.out.println("=====================================");
			System.out.println("|      Modify Cinema Showtimes      |");
			System.out.println("=====================================");
			int option = MenuController.getMenuOption(
				"Enter your choice: ",
				"View movie showtimes",
				"Add a Show Time",
				"Update a Show Time",
				"Remove a Show Time",
				"Exit"
			);
			
			switch (option) {
				case 1:
					ShowTimeController.displayAllShowTimes();
					break;
					
				case 2:
					ShowTimeEditController.addShowTime();
					break;
					
				case 3:
					ShowTimeEditController.updateShowTime();	
					break;
					
				case 4:
					ShowTimeEditController.removeShowTime();
					break;
					
				case 5:
					Driver.goBack();
					return;
			}
		}
	}
}
