package model;

/**
 * Enum class for the different Cinema Classes
 */
//
public enum CinemaClass implements ItemTag {
	/**
	 * Normal cinema class
	 */
    //
	NORMAL("Normal"),
	/**
	 * Platinum Movie Suite cinema class
	 */
    //
	PLATINUM_MOVIE_SUITE("Platinum Movie Suite");
	/**
	 * tag for each cinema class
	 */
	// tag for each cinema class	
	private String tag;

	/**
	 *Constructor for CinemaClass object that uses String input as a tag
	 * @param tag
	 */
	//
	private CinemaClass(String tag) {
		this.tag = tag;
	}

	/**
	 *Getter for the tag
	 * @return
	 */
	//
	public String getTag() {
		return tag;
	}
}