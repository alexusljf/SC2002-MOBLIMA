package model;

import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;

/**
 *This class contains all the information of a movie
 */
//
public class Movie implements Serializable, ItemTag {
	/**
	 *The title of the movie
	 */
	//
	private String title;
	/**
	 *The synopsis of the movie
	 */
	//
	private String synopsis;
	/**
	 *The director of the movie
	 */
	//
	private String director;
	/**
	 *The list of cast names of the movie
	 */
	//
	private String[] cast;
	/**
	 *The showing status of the movie
	 */
	//
	private ShowingStatus showingStatus;
	/**
	 *The content rating of the movie
	 */
	//
	private ContentRating contentRating;
	/**
	 *The movie type of the movie
	 */
	//
	private MovieFormat movieFormat;
	/**
	 *The ArrayList of review ratings of the movie
	 */
	//
	private ArrayList<ReviewStatus> reviewStatuses = new ArrayList<ReviewStatus>();
	/**
	 *The ArrayList of show times of the movie
	 */
	//
	private ArrayList<ShowTime> showTimes = new ArrayList<ShowTime>();
	/**
	 *The duration of the movie
	 */
	//
	private Duration duration;

	/**
	 *Constructor for a Movie object with the given title, synopsis, director, cast, showing status, content rating, movie format and duration
	 * @param title
	 * @param synopsis
	 * @param director
	 * @param cast
	 * @param showingStatus
	 * @param contentRating
	 * @param movieFormat
	 * @param duration
	 */
	//
	public Movie(String title, String synopsis, String director, String[] cast, ShowingStatus showingStatus, ContentRating contentRating,
			MovieFormat movieFormat, Duration duration) {
		this.title = title;
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		this.showingStatus = showingStatus;
		this.contentRating = contentRating;
		this.movieFormat = movieFormat;
		this.duration = duration;
	}

	/**
	 *This method adds a showtime to the movie
	 * @param showTime
	 */
	//
	protected void addShowTime(ShowTime showTime) {
		this.showTimes.add(showTime);
	}

	/**
	 *Getter for the list of show times of a movie
	 * @return
	 */
	//
	public ArrayList<ShowTime> getShowTimes() {
		return showTimes;
	}

	/**
	 *Getter for the OverallRating of a movie, this method calculates the overall Rating by summing up all the ratings and dividing the sum by the number of users who rated it
	 * @return
	 */
	//
	public Double getOverallRating() {
		int noOfReviews = reviewStatuses.size();
		/**
		 *Overall reviewer rating will only be displayed if there are more than ONE individual rating
		 */
		//
		if (noOfReviews <= 1)
			return null;
		
		Double sum = 0.0;
		for (ReviewStatus reviewRating: reviewStatuses)
			sum += reviewRating.getRating();
		
		double overallRating = sum / noOfReviews;
		return overallRating;
	}

	/**
	 *Getter for TotalSales of a movie, this method sums up the total ticket sales of the movies from all its show times
	 * @return
	 */
	//
	public double getTotalSales() {
		double totalSales = 0;
		
		for (ShowTime showTime: showTimes)
			totalSales += showTime.getTotalSales();
		
		return totalSales;
	}

	/**
	 *Getter for the Tag of Movie object
	 * @return
	 */
	//
	@Override
	public String getTag() {
		return title;
	}

	/**
	 *Getter for the title of the movie
	 * @return
	 */
	//
	public String getTitle() {
		return title;
	}

	/**
	 *Getter for thesynopsis of the movie
	 * @return
	 */
	//
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 *Getter for the director of the movie
	 * @return
	 */
	//
	public String getDirector() {
		return director;
	}

	/**
	 *Getter for the list of cast names of the movie
	 * @return
	 */
	//
	public String[] getCast() {
		return cast;
	}

	/**
	 *Getter for the release rating of the movie
	 * @return
	 */
	//
	public ContentRating getContentRating() {
		return contentRating;
	}

	/**
	 *Getter for the movie format of the movie
	 * @return
	 */
	//
	public MovieFormat getMovieFormat() {
		return movieFormat;
	}

	/**
	 *Getter for the ArrayList of review ratings of the movie
	 * @return
	 */
	//
	public ArrayList<ReviewStatus> getReviewStatuses() {
		return reviewStatuses;
	}

	/**
	 *Getter for the showing status of the movie
	 * @return
	 */
	//
	public ShowingStatus getShowingStatus() {
		return showingStatus;
	}

	/**
	 *Getter for the duration of the movie
	 * @return
	 */
	//
	public Duration getDuration() {
		return duration;
	}

	/**
	 *Setter for the title for the movie
	 * @param title
	 */
	//
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 *Setter for the synopsis of the movie
	 * @param synopsis
	 */
	//
	public void setSynopsis(String synopsis) {  
		this.synopsis = synopsis;
	}

	/**
	 *Setter for the director of the movie
	 * @param director
	 */
	//
	public void setDirector(String director) {  
		this.director = director;
		
	}

	/**
	 *Setter for the list of cast names of the movie
	 * @param cast
	 */
	//
	public void setCast(String[] cast) {
		this.cast = cast;
	}

	/**
	 *Setter for the content rating of the movie
	 * @param contentRating
	 */
	//
	public void setContentRating(ContentRating contentRating) {
		this.contentRating = contentRating;
	}

	/**
	 *Setter for the movie format of the movie
	 * @param movieFormat
	 */
	//
	public void setMovieFormat(MovieFormat movieFormat) {
		this.movieFormat = movieFormat;
	}

	/**
	 *Setter for the duration of the movie
	 * @param duration
	 */
	//
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	/**
	 *Setter for the showing status of the movie
	 * @param showingStatus
	 */
	//
	public void setShowingStatus(ShowingStatus showingStatus) {
		this.showingStatus = showingStatus;
	}
}
