package controller;

import java.util.List;

import model.ItemTag;


/**
 *  Class for menu display and input
 */
public class MenuController {

	/**
	 * Method to display a numbered list of options, then prompts users to select an option
	 * @param title
	 * @param options
	 */
	public static int getMenuOption(String title, String... options) {
		System.out.println("");
		IO.displayTitle(title);
		
		// Start options from 1, more readable for users
		for (int i = 0; i < options.length; i++) {
			System.out.println((i + 1) + ": " + options[i]);
		}
		int option;
		
		while (true) {
			option = IO.readInt("Option: ");
			
			if (option >= 1 && option <= options.length)
				break;
			else
				System.out.println("Invalid option selected!");
		}
		
		System.out.println("");
		
		return option;
	}

	/**
	 * Method to display the numbered list of items, pass in an array of items then prompts the user to select an option.
 	 * @param title
	 * @param taggedItems
	 * @param <T>
	 */
	public static <T extends ItemTag> T getItemTag(String title, T[] taggedItems) {
		String[] options = new String[taggedItems.length];
		
		for (int i = 0; i < taggedItems.length; i++)
			options[i] = taggedItems[i].getTag();
		
		int option = getMenuOption(title, options);
		
		return taggedItems[option - 1];
	}


	/**
	 * Method to display the numbered list of items, pass in a list of items then prompts the user to select an option.
	 * @param title
	 * @param taggedItems
	 * @param <T>
	 */
	public static <T extends ItemTag> T getItemTag(String title, List<T> taggedItems) {
		int size = taggedItems.size();
		String[] options = new String[size];
		
		int i = 0;		
		for (T taggedItem: taggedItems) {
			options[i] = taggedItem.getTag();
			i++;
		}
		
		int option = getMenuOption(title, options);		
		return taggedItems.get(option - 1);
	}
}
