package ua.com.cinema.utils;

import ua.com.cinema.models.Time;

/**
 * This class - is utilite for Seance class from package ua.com.cinema.models;
 * 
 * @version 1.2 10 Oct 2016
 * @author RomanGupskyi
 */

public class SeanceUtils {

	/**
	 * This method calculates the movie's end time.
	 * 
	 * @param startTime
	 * @param movieDuration
	 * @return Time movie's endTime
	 */

	public static Time calculateEndTime(Time startTime, Time movieDuration) {
		int endTimeHour = startTime.getHour() + movieDuration.getHour();
		int endTimeMin = startTime.getMin() + movieDuration.getMin();

		return new Time(endTimeHour, endTimeMin);
	}

}
