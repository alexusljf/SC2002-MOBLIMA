package view;

import java.util.List;

import model.DataManager;
import model.Movie;
import model.MovieGoer;
import controller.ListController;
import controller.MenuController;
import controller.MovieController;

/**
 * Displays the main menu for "View Movie Details"
 */
public class MovieMenu implements Menu {

	/**
	 * The movie goer using the menu
	 */
	private MovieGoer movieGoer;
	
	/**
	 * The movie whose details are being viewed
	 */
	private Movie movie;
	
	/**
	 * Constructor for MovieMenu
	 * @param movieGoer the movieGoer using the menu
	 */
	public MovieMenu(MovieGoer movieGoer) {
		this.movieGoer = movieGoer;
	}
	
	/**
	 * Execute() method to display the menu
	 */
	public void execute() {
		// Prompt user to select a movie
		this.movie = selectMovie();
		
		while (true) {
			
			System.out.println("================================");
			System.out.println("|      View Movie Details      |");
			System.out.println("================================");
			int option = MenuController.getMenuOption(
				this.movie.getTitle(),
				"View movie details",
				"View past reviews & ratings",
				"Add a review",
				"Exit"
			);
		
			switch (option) {
				case 1:
					MovieController.printMovieDetails(movie);
					break;
					
				case 2:
					ListController.displayTaggedItemList("Past Reviews & Ratings", movie.getReviewStatuses(), "No reviews & ratings available");
					break;
					
				case 3:
					MovieController.addMovieReview(movie, movieGoer);
					break;
					
				case 4:
					Driver.goBack();
					return;
			}
		}
	}
	
	/**
	 * Prompts user to select movie
	 * @return the movie
	 */
	private Movie selectMovie() {
		List<Movie> movieList = DataManager.getDatabase().getMovieList();
		return MenuController.getItemTag("Select a Movie", movieList);
	}
}
