package ua.com.cinema.models;

/**
 *
 * @author RomanGrupskyi;
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	public Set<Seance> set;

	public Schedule() {
		this.set = new TreeSet<Seance>();

	}

	public void addSeans(Seance seance) {
		set.add(seance);
	}

	public Set<Seance> getSet() {
		return set;
	}

	public void removeSeance(Seance seance) {
		set.remove(seance);
	}

	@Override
	public String toString() {
		String out = "";

		if (set.isEmpty()) {

			return "Ви ще не добавили жодного сеансу! Будьласка, заповніть розклад сеансами!";
		} else {
			Iterator<Seance> iter = set.iterator();

			while (iter.hasNext())
				out += iter.next().toString();
		}
		return out;

	}
}
