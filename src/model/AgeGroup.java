package model;

/**
 * Enum class for the different Age Groups of Movie Goers
 */
//
public enum AgeGroup implements ItemTag {
	/**
	 * Child Age Group
	 */
	//
	CHILD("Child"),
	/**
	 * Adult Age Group
	 */
	//
	ADULT("Adult"),
	/**
	 * Senior Citizen Age Group
	 */
	//
	SENIOR_CITIZEN("Senior Citizen");
	/**
	 * Tag for each Age Group
	 */
	//
	private String tag;

	/**
	 * Constructor for AgeGroup object that uses String input as a tag
	 * @param tag
	 */
	//
	private AgeGroup(String tag) {
		this.tag = tag;
	}

	/**
	 * Getter for the tag
	 * @return
	 */
	//
	public String getTag() {
		return tag;
	}
}
