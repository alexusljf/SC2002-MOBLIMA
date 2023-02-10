package view;

import java.util.Stack;

/**
 * This class controls the navigation between the different menus of the program
 */
public class Driver {
	/**
	 * We use a stack to store all the menus, top of stack will have the most recently called menu
	 * Oldest menu called is at the bottom (earliest pushed)
	 */
	private static Stack<Menu> stack = new Stack<Menu>();
	
	/**
	 * Add menu by pushing it to the stack
	 * @param menu the menu that we are adding
	 */
		public static void addMenu(Menu menu) {
		stack.push(menu);
		menu.execute();
	}

	/**
	 * goes back to previous menu (default is go back by 1 menu)
	 */
	public static void goBack() {
		goBack(1);
	}
	
	/**
	 * go back by custom number of levels
	 * @param level the number of levels we want to go back by
	 */
	public static void goBack(int level) {
		Menu menu = null;
		
		// Pop out current level
		level++;

		// Pop out specified number of levels
		if (level <= stack.size()) {
			for (int i = 0; i < level; i++)
				menu = stack.pop();
			
			addMenu(menu);
		}
	}
}
