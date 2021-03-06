package ua.com.cinema.model;

/**
 * this class represents the model of Time.
 * 
 * @version 1.2 14 Oct 2016
 * @author RomanGrupskyi;
 */
public class Time implements Comparable<Time> {

	private int hour;
	private int min;

	/**
	 * Creates Time;
	 * 
	 * @param hour
	 * @param min
	 */
	public Time(int hour, int min) {
		int tempHour = 0;

		if (min > 59) {
			tempHour = (min / 60);
		}

		this.min = min % 60;
		this.hour = hour % 24 + tempHour;

	}

	public int getHour() {
		return hour;
	}

	public int getMin() {
		return min;
	}

	public void setHour(int newValue) {
		this.hour = newValue;
	}

	public void setMin(int newValue) {
		this.min = newValue;
	}

	/**
	 * Compares 2 Times
	 * 
	 * @return int (1,0 or -1);
	 */
	@Override
	public int compareTo(Time o) {
		int h = Integer.compare(hour, o.getHour());

		if (h != 0) {
			return h;
		} else if (h == 0) {
			return Integer.compare(min, o.getMin());
		} else
			return 0;
	}

	/**
	 * checks Times on equales
	 */
	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || (this.getClass() != o.getClass())) {
			return false;
		}

		Time time = (Time) o;

		if (getHour() != time.getHour()) {
			return false;
		}
		return getMin() == time.getMin();

	}

	/**
	 * generates hash code;
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + hour;
		result = prime * result + min;

		return result;
	}

	/**
	 * Shows Time in a correct format
	 * 
	 * @return String
	 */
	@Override
	public String toString() {

		if (hour < 10 && min < 10) {
			return "0" + hour + " : 0" + min;
		} else if (hour < 10 && min >= 10) {
			return "0" + hour + " : " + min;
		} else if (hour >= 10 && min < 10) {
			return hour + " : 0" + min;
		} else
			return hour + " : " + min;
	}

}
