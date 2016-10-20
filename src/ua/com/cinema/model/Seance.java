package ua.com.cinema.model;

/**
 * this class represents the model for seance of movie. has timeStart and
 * timeEnd. has util class named SeanceUtils.java which calculates the movie's
 * endTime.
 * 
 * @version 1.2 14 Oct 2016
 * @author RomanGrupskyi;
 */
public class Seance implements Comparable<Seance> {

	private Movie movie;
	private Time startTime;
	private Time endTime;

	/**
	 * get movie and startTime, and creates the seance
	 * 
	 * @param movie
	 * @param startTime
	 */
	public Seance(Movie movie, Time startTime) {
		this.movie = movie;
		this.startTime = startTime;
		int deltaMin = startTime.getMin() + movie.getDurationTime().getMin();
		int deltaHour = startTime.getHour() + movie.getDurationTime().getHour();

		if (deltaMin < 60) {
			this.endTime = new Time(deltaHour, deltaMin);
		} else if (deltaMin == 60) {
			this.endTime = new Time((deltaHour + 1), 0);
		} else {
			this.endTime = new Time(deltaHour + 1, deltaMin - 60);
		}
	}

	public Time getEndTime() {
		return endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * Compares 2 seances by startTime
	 */
	@Override
	public int compareTo(Seance o) {

		return this.startTime.compareTo(o.startTime);

	}

	/**
	 * Checks on equales two seances
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
		Seance other = (Seance) obj;
		if (endTime == null) {
			if (other.endTime != null) {
				return false;
			}
		} else if (!endTime.equals(other.endTime))
			return false;

		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie)) {
			return false;
		}
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime)) {
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
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	/**
	 * shows what kind of movie and when will be shown;
	 */
	public String toString() {

		if (startTime.getMin() < 10) {
			return movie.getTitle() + "   " + startTime.getHour() + ":0" + startTime.getMin() + " - "
					+ endTime.getHour() + ":" + endTime.getMin() + '\n';
		} else if (endTime.getMin() < 10) {
			return movie.getTitle() + "   " + startTime.getHour() + ":" + startTime.getMin() + " - " + endTime.getHour()
					+ ":0" + endTime.getMin() + '\n';
		} else {
			return movie.getTitle() + "   " + startTime.getHour() + ":" + startTime.getMin() + " - " + endTime.getHour()
					+ ":" + endTime.getMin() + '\n';
		}
	}
}
