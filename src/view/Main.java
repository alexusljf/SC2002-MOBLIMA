package view;

import model.DataManager;

/**
 * Main class to run the MOBLIMA program
 */
public class Main {

	/**
	 * main method to load the database, start the driver and update the database after exiting the menus
	 * @param args
	 */
	public static void main(String[] args) {
		DataManager.load();
		Driver.addMenu(new UserMenu());
		DataManager.update();
	}
}
