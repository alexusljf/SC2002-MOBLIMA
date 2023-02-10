package view;

import controller.ShowTimeController;

/**
 * This class controls the display of all available show times
 */
public class ShowTimeMenu implements Menu {

	/**
	 * Execute() method to display all showtimes, using ShowTimeController
	 */
	public void execute() {
		// This menu just consists of the display all show times method
		ShowTimeController.displayAllShowTimes();
		Driver.goBack();
	}
}
