package view;

import model.DataManager;
import model.PriceOutline;
import controller.MenuController;
import controller.PriceOutlineEditController;

/**
 * Menu for modifying ticket pricing and also holiday list, which affects ticket price
 */
public class PriceOutlineEditMenu implements Menu {

		/**
	 	* Execute() method to display the menu
	 	*/
		public void execute() {
		PriceOutline pricingScheme = DataManager.getDatabase().getPriceOutline();
		while (true) {
			System.out.println("==========================================");
			System.out.println("|      Modify Ticket Pricing Scheme      |");
			System.out.println("==========================================");
			int option = MenuController.getMenuOption(
				"Enter your choice: ",
				"Change base price",
				"Change multipliers",
				"Change holiday list",
				"Exit"
			);
			switch (option) {
				case 1:
					PriceOutlineEditController.updateBasePrice(pricingScheme);
					break;
					
				case 2:
					PriceOutlineEditController.updateMultipliers(pricingScheme);
					break;
					
				case 3:
					PriceOutlineEditController.updateHolidays(pricingScheme);
					break;
					
				case 4:
					Driver.goBack();
					return;
			}
		}
	}	            		
}
