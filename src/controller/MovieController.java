package controller;

import java.time.Duration;

import model.Movie;
import model.MovieGoer;
import model.ReviewStatus;

/**
 * Class for displaying movie info like Movie details, reviews
 * Also includes a method to add reviews
 */
public class MovieController {

	/**
	 * Displays the Movie details for the input movie
	 * @param movie
	 */
	public static void printMovieDetails(Movie movie) {
		Duration duration = movie.getDuration();
		String durationString = String.format("%dh %02dmin", duration.toHoursPart(), duration.toMinutesPart());
		
		// Prints out the details
		System.out.println(
			"Title: " + movie.getTitle() + "\n" +
			"Synopsis: " + movie.getSynopsis() + "\n" +
			"Director: " + movie.getDirector() + "\n" +
			"Duration: " + durationString + "\n" +
			"Showing Status: " + movie.getShowingStatus().getTag() + "\n" +
			"Release Rating: " + movie.getContentRating().getTag() + "\n" +
			"Movie Type: " + movie.getMovieFormat().getTag()
		);
		
		System.out.println("Cast:");
		for (String castName: movie.getCast())
			System.out.println("• " + castName);
		
		// Overall reviewer rating will only be displayed if there are more than ONE individual rating, else "NA" is displayed
		
		String overallRating = (movie.getOverallRating() != null) ? String.format("%.1f", movie.getOverallRating()) : "NA (Not Available)";
		System.out.println("Overall Reviewer Rating: " + overallRating);
		
		IO.EnterToContinue();
	}

	/**
	 * Method to add Reviews
	 * @param movie
	 * @param movieGoer
	 */
	public static void addMovieReview(Movie movie, MovieGoer movieGoer) {
		// Reads in String comment and int rating
		String comment = IO.readLine("Review: ");
		int rating = IO.readInt("Rating: ");
		
		// Create the review object first
		ReviewStatus review = ReviewStatus.createReviewRating(movieGoer, comment, rating);
		
		// If != null, means the rating int provided was valid
		if (review != null) {
			// Add the created review into the movie's ArrayList of ReviewRatings
			movie.getReviewStatuses().add(review);
			System.out.println("Review & rating added");
			
		} else {
			System.out.println("ERROR: The Rating provided is not valid! (ratings must be between " + ReviewStatus.MIN_RATING + " and " + ReviewStatus.MAX_RATING + ")");
		}
	}
}
