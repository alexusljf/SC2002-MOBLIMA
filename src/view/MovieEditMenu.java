package view;

import java.util.List;

import model.DataManager;
import model.Movie;
import controller.MenuController;
import controller.MovieEditController;
import controller.MovieController;

/**
 * Displays the main menu for "Modify Movie Listings"
 */
public class MovieEditMenu implements Menu {
	
	/**
	 * Execute() method to display the menu
	 */
	public void execute() {
		List<Movie> movieList = DataManager.getDatabase().getMovieList();
		while (true) {
			System.out.println("===================================");
			System.out.println("|      Modify Movie Listings      |");
			System.out.println("===================================");
			int option = MenuController.getMenuOption(
				"Enter your choice: ",
				"View movie details",
				"Add a Movie",
				"Update a Movie",
				"Remove a Movie",
				"Exit"
			);
			
			switch (option) {
				case 1: 
					Movie movie = MenuController.getItemTag("Select a movie", movieList);
					MovieController.printMovieDetails(movie);
					break;
					
				case 2:
					MovieEditController.addMovie();
					break;
					
				case 3:
					MovieEditController.updateMovie();	
					break;
					
				case 4:
					MovieEditController.removeMovie();
					break;
					
				case 5:
					Driver.goBack();
					return;
			}
		}
	}
}
