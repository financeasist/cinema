package ua.com.cinema.models;

/**
 *
 * @author RomanGrupskyi;
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	public Set<Seance> schedule;

	public Schedule() {
		this.schedule = new TreeSet<Seance>();

	}
	
	public void addSeans(Seance seance) {
		schedule.add(seance);
	}
	public void removeSeance(Seance seance) {
		schedule.remove(seance);
	}
	
	public Set<Seance> getSchedule() {
		return schedule;
	}

	public void setSchedule(TreeSet<Seance> schedule) {
		this.schedule = schedule;
	}
	

	@Override
	public String toString() {
		String out = "";

		if (schedule.isEmpty()) {

			return "Ви ще не добавили жодного сеансу! Будьласка, заповніть розклад сеансами!";
		} else {
			Iterator<Seance> iter = schedule.iterator();

			while (iter.hasNext())
				out += iter.next().toString();
		}
		return out;

	}
}
