package controller;

import java.util.ArrayList;
import java.util.List;

import model.ItemTag;

/**
 * Method for displaying lists of items (string, int, etc.)
 */
public class ListController {

	// Display list of strings
	public static void displayList(String title, List<String> stringList, String emptyString) {
		System.out.println("");
		
		IO.displayTitle(title);
		
		if (stringList.size() == 0) {
			System.out.println(emptyString);
			
		} else {
			
			for (String string: stringList) {
				System.out.println(string);
			}
		}
		
		IO.EnterToContinue();
		System.out.println("");
	}

	/**
	 * Display list of Tagged Items
	 * @param title
	 * @param taggedItemList
	 * @param emptyString
	 * @param <T>
	 */
	public static <T extends ItemTag> void displayTaggedItemList(String title, List<T> taggedItemList, String emptyString) {
		List<String> stringList = new ArrayList<String>();
		
		for (ItemTag item: taggedItemList)
			stringList.add(item.getTag());
		
		displayList(title, stringList, emptyString);
	}
}
