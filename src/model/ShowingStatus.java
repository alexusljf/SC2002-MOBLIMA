package model;

/**
 *Enum class for the different Showing Statuses for a movie
 */
//
public enum ShowingStatus implements ItemTag {
	/**
	 *The movie is Coming Soon
	 */
	//
	COMING_SOON("Coming Soon"),
	/**
	 *Preview
	 */
	//
	PREVIEW("Preview"),
	/**
	 *The movie is Now Showing
	 */
	//
	NOW_SHOWING("Now Showing"),
	/**
	 *End of Showing
	 */
	//
	END_OF_SHOWING("End of Showing");
	/**
	 *Tag for each Showing Status
	 */
	//
	String tag;

	/**
	 *Constructor for ShowingStatus object that uses String input as a tag
	 * @param tag
	 */
	//
	private ShowingStatus(String tag) {
		this.tag = tag;
	}

	/**
	 *Getter for the Tag
	 * @return
	 */
	//
	public String getTag() {
		return tag;
	}
}
 
