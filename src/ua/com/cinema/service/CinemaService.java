package ua.com.cinema.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ua.com.cinema.enums.Days;
import ua.com.cinema.models.Cinema;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Schedule;
import ua.com.cinema.models.Seance;
import ua.com.cinema.models.Time;
import ua.com.cinema.utils.SeanceUtils;

/**
 * This class is service for class Cinema from package ua.com.cinema.models;
 * version 1.1 08 October 2016
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
	 * method addMovie - adds movie to schedule. Creates a new seance for each
	 * time from []times.
	 * 
	 * @param movie
	 * @param times
	 */
	public void addMovie(Movie movie, Time... times) {

		for (Days day : Days.values()) {

			for (Time startTime : times) {

				Time endTime = SeanceUtils.calculateEndTime(startTime, movie.getDurationTime());

				if (checkTime(startTime, endTime)) {

					Map<Days, Schedule> weeklyShedule = cinema.getWeeklySchedule();
					Schedule schedule = weeklyShedule.get(day);
					schedule.addSeans(new Seance(movie, startTime));
				}
			}
		}
	}

	/**
	 * method addSeance - adds new seance to schedule in day, accepted in
	 * parameter;
	 * 
	 * @param nameOFDay
	 * @param seance
	 */
	public void addSeance(String nameOFDay, Seance seance) {

		for (Days day : Days.values()) {

			if (nameOFDay.equalsIgnoreCase((day).toString())) {

				if (checkTime(seance.getStartTime(), seance.getEndTime())) {
					cinema.getWeeklySchedule().get(day).addSeans(seance);
				}
			}
		}
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
	boolean checkTime(Time startMovieTime, Time endMovieTime) {
		boolean isCorrectStartTime = startMovieTime.compareTo(cinema.getTimeOpen()) == 1;
		boolean isCorrectEndTime = endMovieTime.compareTo(cinema.getTimeClose()) == -1;

		return (isCorrectStartTime && isCorrectEndTime) ? true : false;
	}

	/**
	 * method removeMovie - removes movie from schedule by name, accepted in
	 * parameter;
	 * 
	 * @param start
	 * @param end
	 * @return
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
		Days[] day = Days.values();

		for (int i = 0; i < day.length; i++) {

			if (nameOfDay.equalsIgnoreCase(day[i].toString())) {
				Iterator<Seance> iter = cinema.getWeeklySchedule().get(day[i]).getSeances().iterator();
				while (iter.hasNext()) {

					if (iter.next().equals(seance)) {
						iter.remove();
					}
				}
			}
		}
	}

	/**
	 * Getters and setters:
	 */
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinemaa) {
		cinema = cinemaa;
	}

}
