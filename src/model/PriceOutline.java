package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

/**
 *This class contains all the information of a pricing scheme
 */
//
public class PriceOutline implements Serializable {
	/**
	 *The base price of the pricing scheme
	 */

	//
	private double basePrice;
	/**
	 *The holiday dates of the pricing scheme
	 */
	//
	private ArrayList<LocalDate> holidayDates = new ArrayList<LocalDate>();
	/**
	 *The cinema class multipliers of the pricing scheme
	 */
	//
	private EnumMap<CinemaClass, Double> cinemaMultipliers = new EnumMap<CinemaClass, Double>(CinemaClass.class);
	/**
	 *The age group multipliers of the pricing scheme
	 */
	//
	private EnumMap<AgeGroup, Double> ageMultipliers = new EnumMap<AgeGroup, Double>(AgeGroup.class);
	/**
	 *The movie type multipliers of the pricing scheme
	 */
	//
	private EnumMap<MovieFormat, Double> movieMultipliers = new EnumMap<MovieFormat, Double>(MovieFormat.class);
	/**
	 *The date type multipliers of the pricing scheme
	 */
	//
	private HashMap<DateType, Double> dateMultipliers = new HashMap<DateType, Double>();

	/**
	 *Getter for the price of a ticket with the given date, cinema class, age group and movie type
	 * @param date
	 * @param cinemaClass
	 * @param ageGroup
	 * @param movieType
	 * @return
	 */
	//
	public double getPrice(LocalDate date, CinemaClass cinemaClass, AgeGroup ageGroup, MovieFormat movieType) {
		double price = this.basePrice;
		
		Double cinemaMultiplier = this.getCinemaMultiplier(cinemaClass);
		if (cinemaMultiplier != null)
			price *= cinemaMultiplier;
		
		Double ageMultiplier = this.getAgeMultiplier(ageGroup);
		if (ageMultiplier != null)
			price *= ageMultiplier;

		Double movieMultiplier = this.getMovieMultiplier(movieType);
		if (movieMultiplier != null)
			price *= movieMultiplier;
		
		Double dateMultiplier = this.getDateMultiplier(date);
		if (dateMultiplier != null)
			price *= dateMultiplier;

		return price;
	}

	/**
	 *Getter for the list of holidays
	 * @return
	 */
	//
	public ArrayList<LocalDate> getHolidayDates() {
		return this.holidayDates;
	}

	/**
	 *This method returns true if the given date is a holiday
	 * @param date
	 * @return
	 */
    //
	private boolean isHoliday(LocalDate date) {
		for (LocalDate holidayDate: holidayDates) {
			if (date.equals(holidayDate))
				return true;
		}

		return false;
	}

	/**
	 *Getter for the base price of the pricing scheme.
	 * @return
	 */
	//
	public double getBasePrice() {
		return this.basePrice;
	}

	/**
	 *Setter for the base price of the pricing scheme.
	 * @param basePrice
	 */
	//
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 *Getter for the multiplier corresponding to a given cinema class.
	 * @param cinemaClass
	 * @return
	 */
	//
	public Double getCinemaMultiplier(CinemaClass cinemaClass) {
		return this.cinemaMultipliers.get(cinemaClass);
	}

	/**
	 *Setter for the multiplier corresponding to a given cinema class.
	 * @param cinemaClass
	 * @param cinemaMultiplier
	 */
	//
	public void setCinemaMultiplier(CinemaClass cinemaClass, Double cinemaMultiplier) {
		this.cinemaMultipliers.put(cinemaClass, cinemaMultiplier);
	}

	/**
	 *Getter for the multiplier corresponding to a given age group.
	 * @param ageGroup
	 * @return
	 */
	//
	public Double getAgeMultiplier(AgeGroup ageGroup) {
		return this.ageMultipliers.get(ageGroup);
	}

	/**
	 *Setter for the multiplier corresponding to a given age group.
	 * @param ageGroup
	 * @param ageMultiplier
	 */
	//
	public void setAgeMultiplier(AgeGroup ageGroup, Double ageMultiplier) {
		this.ageMultipliers.put(ageGroup, ageMultiplier);
	}

	/**
	 *Getter for the multiplier corresponding to a given movie type.
	 * @param movieFormat
	 * @return
	 */
	//
	public Double getMovieMultiplier(MovieFormat movieFormat) {
		return this.movieMultipliers.get(movieFormat);
	}

	/**
	 *Setter for the multiplier corresponding to a given movie type.
	 * @param movieFormat
	 * @param movieMultiplier
	 */
	//
	public void setMovieMultiplier(MovieFormat movieFormat, Double movieMultiplier) {
		this.movieMultipliers.put(movieFormat, movieMultiplier);
	}

	/**
	 *Getter for the corresponding DateType of a given date.
	 * @param date
	 * @return
	 */
	//
	private DateType getDateType(LocalDate date) {
		if (this.isHoliday(date))
			return DateType.HOLIDAY;
		
		else if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
			return DateType.WEEKEND;
		
		else
			return DateType.WEEKDAY;
	}

	/**
	 *Getter for the multiplier corresponding to a given date.
	 * @param date
	 * @return
	 */
	//
	public Double getDateMultiplier(LocalDate date) {
		return this.dateMultipliers.get(getDateType(date));
	}

	/**
	 *Getter for the multiplier corresponding to a given date type.
	 * @param dateType
	 * @return
	 */
	//
	public Double getDateMultiplier(DateType dateType) {
		return this.dateMultipliers.get(dateType);
	}

	/**
	 *Setter for the multiplier corresponding to a given date type.
	 * @param dateType
	 * @param dateMultiplier
	 */
	//
	public void setDateMultiplier(DateType dateType, Double dateMultiplier) {
		this.dateMultipliers.put(dateType, dateMultiplier);
	}
}
