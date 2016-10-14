package ua.com.cinema.models;

/**
 * This class is model of Schedule. Has Set of Seances implemented in TreeSet<Seance>; 
 * @version 1.2 14 Oct 2016
 * @author RomanGrupskyi;
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	public Set<Seance> seances;

	public Schedule() {
		this.seances = new TreeSet<Seance>();

	}

	/**
	 * adds seance to set
	 * 
	 * @param seance
	 * 
	 */
	public void addSeans(Seance seance) {
		seances.add(seance);
	}

	/**
	 * removes seance from schedule
	 * 
	 * @param seance
	 */
	public void removeSeance(Seance seance) {
		seances.remove(seance);
	}

	/**
	 * @returns set of seances
	 */
	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	/**
	 * Checks and shows the schedule (set<Seance>)
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String out = "";

		if (seances.isEmpty()) {

			return "Ви ще не добавили жодного сеансу! Будьласка, заповніть розклад сеансами!";
		} else {
			Iterator<Seance> iter = seances.iterator();

			while (iter.hasNext())
				out += iter.next().toString();
		}
		return out;

	}
}
