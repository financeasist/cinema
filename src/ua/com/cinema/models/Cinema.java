package ua.com.cinema.models;

import java.util.*;

import ua.com.cinema.enums.Days;

/**
 * 
 * @author RomanGrupskyi;
 */

public class Cinema {

	private TreeMap<Days, Schedule> map;
	private Time timeOpen;
	private Time timeClose;

	public Cinema(Time open, Time close) {
		this.map = new TreeMap<Days, Schedule>();
		this.timeOpen = open;
		this.timeClose = close;
		Days[] days = Days.values();

		for (int i = 0; i < days.length; i++) {
			map.put(days[i], new Schedule());
		}
	}

	public void addMovie(Movie movie, Time... time) {
		Days[] days = Days.values();

		for (int j = 0; j < days.length; j++) {

			for (int i = 0; i < time.length; i++) {

				if (checkTime(time[i], (Seance.endingTime(time[i], movie.getDuration())))) {
					map.get(days[j]).addSeans(new Seance(movie, time[i]));
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

	public void removeSeance(String str, Seance seance) {
		Days[] day = Days.values();

		for (int i = 0; i < day.length; i++) {

			if (str.equalsIgnoreCase(day[i].toString())) {
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
