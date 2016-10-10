package ua.com.cinema.test;

import java.util.HashMap;

import ua.com.cinema.enums.Days;
import ua.com.cinema.models.Schedule;
import ua.com.cinema.models.Time;

public class TestCinema {
	
	private Time timeOpen;
	private Time timeClose;
	private HashMap<Days, Schedule> map;
	
	public TestCinema(Time open, Time close) {
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


}
