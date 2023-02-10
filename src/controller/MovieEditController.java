package controller;

import java.time.Duration;
import java.util.List;

import model.DataManager;
import model.Movie;
import model.ContentRating;
import model.ShowingStatus;
import model.MovieFormat;

/**
 * Class to edit movies (Add, Update, Remove)
 * Also includes methods to read input from user for movie details
 */
public class MovieEditController {

	/**
	 * Method to add Movie
	 */
	public static void addMovie() {
		// Call all the read methods to get user input
		String title = readTitle();
		String synopsis = readSynopsis();
		String director = readDirector();
		
		ShowingStatus showingStatus = readShowingStatus();
		ContentRating contentRating = readContentRating();
		MovieFormat movieType = readMovieFormat();
		
		String[] cast = readCast();
		Duration duration = readDuration();
		
		// Create movie object with input data and add it to the list of movies in our db
		Movie movie = new Movie(title, synopsis, director, cast, showingStatus, contentRating, movieType, duration);
		DataManager.getDatabase().getMovieList().add(movie);
	}

	/**
	 * Method to update Movie
	 */
	public static void updateMovie() {
		List<Movie> movieList = DataManager.getDatabase().getMovieList();
		Movie movie = MenuController.getItemTag("Select a movie", movieList);
		
		int option = MenuController.getMenuOption(
			"What do you want to update?",
			"Title",
			"Synopsis",
			"Director",
			"Showing status",
			"Release rating",
			"Movie type",
			"Cast",
			"Duration"
		);
		
		// Switch statements for each choice, then call read methods to get updated input
		switch(option) {
		    	
			case 1:
		        movie.setTitle(MovieEditController.readTitle());
		        break;
					  
		    case 2:
		    	movie.setSynopsis(MovieEditController.readSynopsis());
				break;
				
			case 3:
				movie.setDirector(MovieEditController.readDirector());
				break;
				
			case 4:
				movie.setShowingStatus(MovieEditController.readShowingStatus());
				break;
				
			case 5:
				movie.setContentRating(MovieEditController.readContentRating());
				break;
				
			case 6:
				movie.setMovieFormat(MovieEditController.readMovieFormat());
				break;
				
			case 7:
				movie.setCast(MovieEditController.readCast());
				break;
				
			case 8:
				movie.setDuration(MovieEditController.readDuration());
				break;
		}
	}

	/**
	 * Method to remove Movie
	 */
	public static void removeMovie() {
		List<Movie> movieList = DataManager.getDatabase().getMovieList();
		Movie movie = MenuController.getItemTag("Select a Movie", movieList);
		movie.setShowingStatus(ShowingStatus.END_OF_SHOWING);
	}

	/**
	 * Method to read Title
	 */
	private static String readTitle() {
		return IO.readLine("Title: ");
	}
	/**
	 * Method to read Synopsis
	 */
	private static String readSynopsis() {
		return IO.readLine("Synopsis: ");
	}
	/**
	 * Method to read Director
	 */
	private static String readDirector() {
		return IO.readLine("Director: ");
	}
	/**
	 * Method to read ShowingStatus
	 */
	private static ShowingStatus readShowingStatus() {
		return MenuController.getItemTag("Showing status: ", ShowingStatus.values());
	}
	/**
	 * Method to read ContentRating
	 */
	private static ContentRating readContentRating() {
		return MenuController.getItemTag("Content rating: ", ContentRating.values());
	}
	/**
	 * Method to read MovieFormat
	 */
	private static MovieFormat readMovieFormat() {
		return MenuController.getItemTag("Movie type: ", MovieFormat.values());
	}
	/**
	 * Method to read Cast
	 */
	private static String[] readCast() {
		int castSize = IO.readInt("Enter the size of Cast: ");
		
		// Create an array of Strings first to store all inputs
		String[] castNames = new String[castSize];
		System.out.println("Cast names: ");
		
		for (int i = 0; i < castSize; i++)
			castNames[i] = IO.readLine("• ");
		
		return castNames;
	}
	/**
	 * Method to read Duration
	 */
	private static Duration readDuration() {
		return IO.readDuration("Duration (in Minutes): ");
	}
}
