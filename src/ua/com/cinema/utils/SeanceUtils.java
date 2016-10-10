package ua.com.cinema.utils;
import ua.com.cinema.models.Time;


public class SeanceUtils {

	public static Time calculateEndTime(Time start, Time movieDuration){
			int endTimeHour = start.getHour() + movieDuration.getHour();
			int endTimeMin = start.getMin() + movieDuration.getMin();

			return new Time(endTimeHour, endTimeMin);
		}

	}

