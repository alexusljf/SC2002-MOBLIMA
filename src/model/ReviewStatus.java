package model;

import java.io.Serializable;

/**
 *This class contains all the information of a review rating
 */
//
public class ReviewStatus implements Serializable, ItemTag {
	/**
	 *The minimum possible rating value
	 */
	//
	public static final int MIN_RATING = 1;
	/**
	 *The maximum possible rating value
	 */
	//
	public static final int MAX_RATING = 5;
	/**
	 *The movie goer who made the review rating
	 */
	//
	private MovieGoer movieGoer;
	/**
	 *The review
	 */
	//
	private String review;
	/**
	 *The rating
	 */
	//
	private Integer rating;

	/**
	 *Constructor for ReviewStatus object
	 */
	//
	private ReviewStatus() {}

	/**
	 *Creates a ReviewRating object with the given movie goer who made the review rating, the review and the rating
	 * @param movieGoer
	 * @param review
	 * @param rating
	 * @return
	 */
	//
	public static ReviewStatus createReviewRating(MovieGoer movieGoer, String review, int rating) {
		ReviewStatus reviewRating = new ReviewStatus();
		
		reviewRating.movieGoer = movieGoer;
		reviewRating.review = review;
		reviewRating.rating = rating;
		/**
		 *Return the ReviewRating objcet if the rating provided is valid (between Min_Rating and Max_Rating)
		 */
		//
		if (rating >= MIN_RATING && rating <= MAX_RATING)
			return reviewRating;
		/**
		 *Else return null because it is not valid
		 */
		//
			else
			return null; 
	}

	/**
	 *Getter for the movie goer who made the review rating
	 * @return
	 */
	//
	public MovieGoer getMovieGoer() {
		return movieGoer;
	}

	/**
	 *Setter for the  movieGoer
	 * @param movieGoer
	 */
	//
	public void setMovieGoer(MovieGoer movieGoer) {
		this.movieGoer = movieGoer;
	}

	/**
	 *Getter for the review
	 * @return
	 */
	//
	public String getReview() {
		return review;
	}

	/**
	 *Setter for the review
	 * @param review
	 */
	//
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 *Getter for the rating
	 * @return
	 */
	//
	public int getRating() {
		return rating;
	}

	/**
	 *Setter for the rating
	 * @param rating
	 */
	//
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 *Getter for the tag of this ReviewStatus object
	 * @return
	 */
	//
	public String getTag() {
		return review + " (" + rating + "/5) —— " + movieGoer.getName();
	}
}
