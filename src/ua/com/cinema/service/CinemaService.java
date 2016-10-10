package ua.com.cinema.service;

import java.util.HashMap;
import java.util.Iterator;

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

				Time endTime = SeanceUtils.calculateEndTime(startTime, movie.getDuration());

				if (checkTime(startTime, endTime)) {

					HashMap<Days, Schedule> weeklyShedule = cinema.getWeeklySchedule();
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
		Days[] days = Days.values();

		for (int i = 0; i < days.length; i++) {

			if (nameOFDay.equalsIgnoreCase((days[i]).toString())) {

				if (checkTime(seance.getStartTime(), seance.getEndTime())) {
					cinema.getWeeklySchedule().get(days[i]).addSeans(seance);
				}
			}
		}
	}

	/**
	 * method check startMovieTime and endMovieTime with cinema timeOpen and cinema timeClose;
	 * 
	 * @param startMovieTime
	 * @param endMovieTime
	 * @return boolean for check this time with cinema timeOpen and cinema timeClose
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
	public void removeMovie(String movie) {
		Days[] days = Days.values();

		for (int i = 0; i < days.length; i++) {
			Iterator<Seance> iter = cinema.getWeeklySchedule().get(days[i]).getSet().iterator();

			while (iter.hasNext()) {

				if (iter.next().getMovie().getTitle().equals(movie))
					iter.remove();
			}
		}
	}

	/**
	 * method removeSeance - removes accepted seance by day, accepted in
	 * parameter;
	 * 
	 * @param str
	 * @param seance
	 */
	public void removeSeance(String str, Seance seance) {
		Days[] day = Days.values();

		for (int i = 0; i < day.length; i++) {

			if (str.equalsIgnoreCase(day[i].toString())) {
				Iterator<Seance> iter = cinema.getWeeklySchedule().get(day[i]).getSet().iterator();

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
