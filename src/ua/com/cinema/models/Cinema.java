package ua.com.cinema.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ua.com.cinema.enums.Days;

/**
 * This class represents a cinema working process. Cinema works every day from
 * time opening to time closing (fields timeOpen / timeClose) and has some
 * schedule seances for every day (field weeklySchedule).
 *
 * @version 1.3 08 October 2016
 * @author RomanGrupskyi;
 */

public class Cinema {

	private Time timeOpen;
	private Time timeClose;
	private HashMap<Days, Schedule> weeklySchedule;

	public Cinema(Time open, Time close) {
		this.timeOpen = open;
		this.timeClose = close;
		this.weeklySchedule = new HashMap<Days, Schedule>();

		weeklySchedule.put(Days.MONDAY, new Schedule());
		weeklySchedule.put(Days.THUESDAY, new Schedule());
		weeklySchedule.put(Days.WEDNESDAY, new Schedule());
		weeklySchedule.put(Days.THURSDAY, new Schedule());
		weeklySchedule.put(Days.FRIDAY, new Schedule());
		weeklySchedule.put(Days.SATURDAY, new Schedule());
		weeklySchedule.put(Days.SUNDAY, new Schedule());
	}

	public Time getTimeOpen() {
		return timeOpen;
	}

	public void setTimeOpen(Time timeOpen) {
		this.timeOpen = timeOpen;
	}

	public Time getTimeClose() {
		return timeClose;
	}

	public void setTimeClose(Time timeClose) {
		this.timeClose = timeClose;
	}

	public HashMap<Days, Schedule> getWeeklySchedule() {
		return weeklySchedule;
	}

	public void setWeeklySchedule(HashMap<Days, Schedule> weeklySchedule) {
		this.weeklySchedule = weeklySchedule;
	}

	/**
	 * method toString() - shows schedule for ich day.
	 */
	@Override
	public String toString() {
		String out1 = "~~~~~~~~~~~~~~~~~~CINEMA~~~~~~~~~~~~~~~~\n" + "~~~WORKING EVERYDAY FROM "
				+ this.timeOpen.toString() + " TO " + this.timeClose.toString() + "~~~\n";

		Iterator<Map.Entry<Days, Schedule>> iter = weeklySchedule.entrySet().iterator();
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
