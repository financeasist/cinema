package ua.com.cinema.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ua.com.cinema.enums.Days;
import ua.com.cinema.model.Cinema;
import ua.com.cinema.model.Movie;
import ua.com.cinema.model.Schedule;
import ua.com.cinema.model.Seance;
import ua.com.cinema.model.Time;
import ua.com.cinema.util.SeanceUtil;

/**
 * This class is service for class Cinema from package ua.com.cinema.models;
 * version 1.3 18 October 2016
 * 
 * @author RomanGrupskyi;
 */
public class CinemaService {

	private static Cinema cinema;

	public CinemaService(Cinema cinemaa) {
		super();
		cinema = cinemaa;
	}

	/**
	 * Method addMovie - adds movie to schedule. Creates a new seance for each
	 * time from []times.
	 * 
	 * @param movie
	 * @param times[]
	 */
	public boolean addMovie(Movie movie, Time... times) {
		boolean isAdded = false;
		for (Days day : Days.values()) {

			for (Time startTime : times) {

				Time endTime = SeanceUtil.calculateEndTime(startTime, movie.getDurationTime());

				if (checkTime(startTime, endTime)) {

					Map<Days, Schedule> weeklyShedule = cinema.getWeeklySchedule();
					Schedule schedule = weeklyShedule.get(day);
					schedule.addSeans(new Seance(movie, startTime));
					isAdded = true;

				} else
					isAdded = false;
			}
		}
		return isAdded;
	}

	/**
	 * method addSeance - adds new seance to schedule in day, accepted in
	 * parameter;
	 * 
	 * @param nameOFDay
	 * @param seance
	 */
	public boolean addSeance(String nameOFDay, Seance seance) {
		boolean isAdded = false;
		for (Days day : Days.values()) {

			if (nameOFDay.equalsIgnoreCase((day).toString())) {

				if (checkTime(seance.getStartTime(), seance.getEndTime())) {
					cinema.getWeeklySchedule().get(day).addSeans(seance);
					isAdded = true;
				}
			}
		}
		return isAdded;
	}

	/**
	 * method check startMovieTime and endMovieTime with cinema timeOpen and
	 * cinema timeClose;
	 * 
	 * @param startMovieTime
	 * @param endMovieTime
	 * @return boolean for check this time with cinema timeOpen and cinema
	 *         timeClose
	 */
	public boolean checkTime(Time startMovieTime, Time endMovieTime) {
		boolean isCorrectStartTime = startMovieTime.compareTo(cinema.getTimeOpen()) == 1;
		boolean isCorrectEndTime = endMovieTime.compareTo(cinema.getTimeClose()) == -1;

		return (isCorrectStartTime && isCorrectEndTime) ? true : false;
	}

	/**
	 * method compare sianceStartTime and sianceEndTime with cinema don't
	 * working time
	 * 
	 * @param sianceStartTime
	 * @param sianceEndTime
	 * @return true if seance will be in time when cinema is working.
	 */
	public boolean compareWithCinemaWorkingTime(Time sianceStartTime, Time sianceEndTime) {
		Time cinemaTimeClosedFrom = new Time(01, 00);
		Time cinemaTimeClosedTo = new Time(8, 29);
		boolean isCorrectStartTime = sianceStartTime.compareTo(cinemaTimeClosedTo) == 1;
		boolean isCorrectEndTime = (sianceEndTime.compareTo(cinemaTimeClosedFrom) == 1)
				&& (sianceEndTime.compareTo(cinemaTimeClosedTo) == 1);
		return (isCorrectStartTime && isCorrectEndTime) ? true : false;

	}

	/**
	 * method removeMovie - removes movie from schedule by name, accepted in
	 * parameter;
	 * 
	 * @param movieName
	 */
	public boolean removeMovie(String movieName) {
		boolean isRemoved = false;
		for (Days day : Days.values()) {

			Map<Days, Schedule> weeklySchedule = cinema.getWeeklySchedule();
			Schedule schedule = weeklySchedule.get(day);
			Set<Seance> seances = schedule.getSeances();
			Iterator<Seance> iter = seances.iterator();

			while (iter.hasNext()) {

				if (iter.next().getMovie().getTitle().equals(movieName)) {
					iter.remove();
					isRemoved = true;
				}
			}
		}
		return isRemoved;
	}

	/**
	 * method removeSeance - removes accepted seance by day, accepted in
	 * parameter;
	 * 
	 * @param nameOfDay
	 * @param seance
	 */
	public void removeSeance(String nameOfDay, Seance seance) {

		for (Days day : Days.values()) {

			if (nameOfDay.equalsIgnoreCase(day.toString())) {
				Iterator<Seance> iter = cinema.getWeeklySchedule().get(day).getSeances().iterator();
				while (iter.hasNext()) {

					if (iter.next().equals(seance)) {
						iter.remove();
					}
				}
			}
		}
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinemaa) {
		cinema = cinemaa;
	}

}
