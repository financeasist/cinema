package ua.com.cinema;

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

    public void removeSeance(Seance seance) {
        set.remove(seance);
    }

    public Set<Seance> getSet() {
        return set;
    }

    @Override

    public String toString() {
        Iterator<Seance> iter = set.iterator();
        String out = "";
        while (iter.hasNext())
            out+=iter.next().toString() ;
        return out;


    }
}
