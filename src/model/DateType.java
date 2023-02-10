package model;

/**
 *Enum class for the different Date Types
 */
//
public enum DateType implements ItemTag {
	/**
	 *Enums for the different types of dates
	 */
	//
	WEEKDAY("Weekday"),
	WEEKEND("Weekend"),
	HOLIDAY("Holiday");
	/**
	 *Tag for each date type
	 */
	//
	private String tag;

	/**
	 *Constructor for DateType object that uses String input as a tag
	 * @param tag
	 */
	//
	private DateType(String tag) {
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
