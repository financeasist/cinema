package ua.com.cinema.newmodels;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ua.com.cinema.enums.Days;
import ua.com.cinema.models.Movie;
import ua.com.cinema.models.Schedule;
import ua.com.cinema.models.Seance;
import ua.com.cinema.models.Time;

/**
 * This class represents a cinema working process.
 * 
 * state of class:
 * 
 * Cinema works every day from time opening to time closing (fields timeOpen / timeClose)
 * and has some schedule seances for each day (field map).
 *
 * behavior of class :
 * method addMovie -  adds movie to schedule. Creates a new seance for each time from []times.
 * 
 * method addSeance - adds new seance to schedule in day, accepted in parameter;
 * 
 * method removeMovie - removes movie from schedule by name, accepted in parameter;
 * 
 * method removeSeance - removes accepted seance by day, accepted in parameter;
 * 
 * method toString() - shows schedule for ich day.
 * 
 * @version 1.2 06 October 2016
 * @author RomanGrupskyi;
 */

public class Cinema {

	
	private Time timeOpen;
	private Time timeClose;
	private HashMap<Days, Schedule> map;

	public Cinema(Time open, Time close) {
		this.timeOpen = open;
		this.timeClose = close;
		this.map = new HashMap<Days, Schedule>();
		
		map.put(Days.MONDAY, new Schedule());
		map.put(Days.THUESDAY, new Schedule());
		map.put(Days.WEDNESDAY, new Schedule());
		map.put(Days.THURSDAY, new Schedule());
		map.put(Days.FRIDAY, new Schedule());
		map.put(Days.SATURDAY, new Schedule());
		map.put(Days.SUNDAY, new Schedule());

			}

	public void addMovie(Movie movie, Time... times) {
		Days[] days = Days.values();

		for (int j = 0; j < days.length; j++) {

			for (int i = 0; i < times.length; i++) {

				if (checkTime(times[i], (Seance.endingTime(times[i], movie.getDuration())))) {
					map.get(days[j]).addSeans(new Seance(movie, times[i]));
				}
			}
		}
	}

	public void addSeance(String nameOFDay, Seance seance) {
		Days[] days = Days.values();

		for (int i = 0; i < days.length; i++) {

			if (nameOFDay.equalsIgnoreCase((days[i]).toString())) {

				if (checkTime(seance.getStartTime(), seance.getEndTime())) {
					map.get(days[i]).addSeans(seance);
				}
			}
		}
	}

	public boolean checkTime(Time start, Time end) {
		boolean isCorrectStartTime = start.compareTo(timeOpen) == 1;
		boolean isCorrectEndTime = end.compareTo(timeClose) == -1;

		return (isCorrectStartTime && isCorrectEndTime) ? true : false;
	}

	public void removeMovie(String movie) {
		Days[] days = Days.values();

		for (int i = 0; i < days.length; i++) {
			Iterator<Seance> iter = map.get(days[i]).getSet().iterator();

			while (iter.hasNext()) {

				if (iter.next().getMovie().getTitle().equals(movie))
					iter.remove();
			}
		}
	}

	public void removeSeance(String nameOfDay, Seance seance) {
		Days[] day = Days.values();
		

		for (int i = 0; i < day.length; i++) {

			if (nameOfDay.equalsIgnoreCase(day[i].toString())) {
				Iterator<Seance> iter = map.get(day[i]).getSet().iterator();

				while (iter.hasNext()) {

					if (iter.next().equals(seance)) {
						iter.remove();
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		String out1 = "~~~~~~~~~~~~~~~~~~CINEMA~~~~~~~~~~~~~~~~\n" + "~~~WORKING EVERYDAY FROM " + this.timeOpen.toString()
				+ " TO " + this.timeClose.toString() + "~~~\n";

		Iterator<Map.Entry<Days, Schedule>> iter = map.entrySet().iterator();
		String out = "";
		String tempK = "";
		String tempV = "";

		while (iter.hasNext()) {
			Map.Entry<Days, Schedule> temp = iter.next();

			tempK = "\n -----" + temp.getKey().toString() + "------\n";
			tempV = temp.getValue().toString();
			out += tempK + tempV;
		}

		return (out1 + out);
	}

}
