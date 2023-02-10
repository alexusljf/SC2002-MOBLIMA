package view;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.DataManager;
import model.Movie;
import controller.ListController;
import controller.MenuController;

/**
 * Displays Top 5 movies by Ticket Sales or by Ratings
 */
public class TopMoviesMenu implements Menu{

	/**
	 * Execute() method to display the menu
	 */
	public void execute() {
		while (true) {
			System.out.println("===============================");
			System.out.println("|      List Top 5 Movies      |");
			System.out.println("===============================");
			int option = MenuController.getMenuOption(
				"Show the Top 5 movies by...",
				"Ticket sales",
				"Overall reviewer's rating",
				"Exit"
			);
			
			List<String> movieStrings;
			
			switch (option) {
				case 1:
					movieStrings = getTopMoviesByTicketSales();
					ListController.displayList("Top 5 Movies By Ticket Sales", movieStrings, "There are no movies available");
					break;
					
				case 2:
					movieStrings = getTopMoviesByOverallRating();
					ListController.displayList("Top 5 Movies By Overall Rating", movieStrings, "There are no movies available");
					break;
					
				case 3:
					Driver.goBack();
					return;
			}
		}
	}
	
	/**
	 * Method to get the top 5 movies by ticket sales in descending order
	 * @return list of top 5 movies by ticket sales in descending order
	 */
	private List<String> getTopMoviesByTicketSales() {
		// Retrieve all movies
		List<Movie> movieList = DataManager.getDatabase().getMovieList();
		List<Movie> movieListCopy = new ArrayList<Movie>();
		movieListCopy.addAll(movieList);

		// Sort them based on total sales in descending order
		Comparator<Movie> salesComparator = Collections.reverseOrder(Comparator.comparing(Movie::getTotalSales));
		movieListCopy.sort(salesComparator);
		
		// List of Strings just to store the movie names
		List<String> movieStrings = new ArrayList<String>(); 

		// Add the first 5 in the descending order movieList (aka the Top 5) into another list and then return it
		for (int i = 0; i < 5 && i < movieListCopy.size(); i++) {
			Movie movie = movieListCopy.get(i);
			movieStrings.add((i + 1) + ". " + movie.getTitle() + " ($" + String.format("%.2f", movie.getTotalSales()) + ")");
		}
		
		return movieStrings;
	}
	
	/**
	 * Method to get the top 5 movies by Overall reviewer's rating in descending order
	 * @return list of top 5 movies by Overall reviewer's rating in descending order
	 */	
	private List<String> getTopMoviesByOverallRating() {
		// Retrieve all movies that have ratings
		List<Movie> movieList = DataManager.getDatabase().getMovieList();
		List<Movie> moviesWithRatings = new ArrayList<Movie>();

		// Check each movie if they have reviews, don't add them if they don't have reviews
		for (Movie movie: movieList) {
			if (movie.getOverallRating() != null)
				moviesWithRatings.add(movie);
		}

		// Sort them based on reviews in descending order
		Comparator<Movie> ratingComparator = Collections.reverseOrder(Comparator.comparing(Movie::getOverallRating));
		moviesWithRatings.sort(ratingComparator);
		
		// List of Strings just to store the movie names
		List<String> movieStrings = new ArrayList<String>();
		
		// Add the first 5 in the descending order movieList (aka the Top 5) into another list and then return it
		for (int i = 0; i < 5 && i < moviesWithRatings.size(); i++) {
			Movie movie = moviesWithRatings.get(i);
			movieStrings.add((i + 1) + ". " + movie.getTitle() + " (" + String.format("%.2f", movie.getOverallRating()) + ")");
		}
		return movieStrings;
	}
}
