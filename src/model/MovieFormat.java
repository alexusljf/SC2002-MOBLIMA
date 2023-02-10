package model;

/**
 *Enum class for the different Movie Formats
 */
//
public enum MovieFormat implements ItemTag {
	/**
	 *Regular movie
	 */
	//
	REGULAR("Regular"),
	/**
	 *Blockbuster movie
	 */
	//
	BLOCKBUSTER("Blockbuster"),
	/**
	 *3D movie
	 */
	//
	_3D("3D");
	/**
	 *Tag for the movie format type
	 */
	//
	private final String tag;

	/**
	 *Constructor for MovieFormat object that uses String input as a tag
	 * @param tag
	 */
	//
	private MovieFormat(String tag) {
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
