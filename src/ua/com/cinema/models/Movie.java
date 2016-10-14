package ua.com.cinema.models;

/**
 * This class - it's model for movie. Has 2 fields movieTitle and durationTime;
 * has appropriate getters and setters, equals, hashCode and method toString;
 * 
 * @version 1.2 14 Oct 2016
 * @author RomanGrupskyi;
 */
public class Movie {

	private String title;
	private Time durationTime;

	public Movie(String title, Time duration) {
		this.title = title;
		this.durationTime = duration;
	}

	/**
	 * getters and setters:
	 */
	public Time getDurationTime() {
		return durationTime;
	}

	public String getTitle() {
		return title;
	}

	public void setDuration(Time duration) {
		this.durationTime = duration;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Checks on equales:
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		Movie other = (Movie) obj;

		if (durationTime == null) {
			if (other.durationTime != null) {
				return false;
			}
		} else if (!durationTime.equals(other.durationTime)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}

	/**
	 * generates hash code;
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((durationTime == null) ? 0 : durationTime.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());

		return result;
	}

	/**
	 * shows movie with title and durationTime
	 */
	@Override
	public String toString() {

		return "Movie '" + title + "'- " + durationTime.getHour() + ":" + durationTime.getMin();
	}
}
