package ua.com.cinema.main;

import java.util.HashMap;

import ua.com.cinema.enums.Days;
import ua.com.cinema.models.Cinema;
import ua.com.cinema.models.Schedule;
import ua.com.cinema.service.CinemaService;

public class Main {

	public static void main(String[] args) {
		CinemaService cinemaService = new CinemaService(CinemaGuiMain.palace);
				Days dayOfWeeks = Days.valueOf("MONDAY");
		
		
		
		Cinema cinema = cinemaService.getCinema();
		HashMap<Days, Schedule> weeklySchedule = cinema.getWeeklySchedule();
		
		Schedule schedule =  weeklySchedule.get(dayOfWeeks);
		
		System.out.println(schedule.toString()); 
	}

}
