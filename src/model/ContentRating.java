package model;

/**
 * Enum class for the different Age Groups of Movie Goers
 */
//
public enum ContentRating implements ItemTag {
	/**
	 * G rating
	 */
	//
	G("G"),
	/**
	 * PG rating
	 */
	//
	PG("PG"),
	/**
	 * PG13 rating
	 */
	//
	PG13("PG13"),
	/**
	 * NC16 rating
	 */
	//
	NC16("NC16"),
	/**
	 * M18 rating
	 */
	//
	M18("M18"),
	/**
	 * R21 rating
	 */
	//
	R21("R21");
	/**
	 * Tag for the movie content rating
	 */
	//
	private final String tag;

	/**
	 *Constructor for Content Rating object
	 * @param tag
	 */
	//
	private ContentRating(String tag) {
		this.tag = tag;
	}

	/**
	 *Getter for the tag of the content rating
	 * @return
	 */
	//
	public String getTag() {
		return tag;
	}
}
