/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Lovers Comparator
 */

package Comparators;

import java.util.Comparator;

import ShowPedia.Actor;

public class LoversComparatorClass implements Comparator<Actor> {
    
    @Override
    public int compare(Actor actor1, Actor actor2) {
        if (actor1.getNrRomances() < actor2.getNrRomances()) {
            return 1;
        }
        else if (actor1.getNrRomances() > actor2.getNrRomances()) {
            return -1;
        }
        else if (actor1.getNrRomances() == actor2.getNrRomances() && actor1.getShows().size() > actor2.getShows().size()) {
            return 1;
        } else if (actor1.getNrRomances() == actor2.getNrRomances() && actor1.getShows().size() < actor2.getShows().size()) {
            return -1;
        }
        else if (actor1.getShows().size() == actor2.getShows().size() && actor1.getNrRomanticShows() < actor2.getNrRomanticShows()) {
            return 1;
        }
        else if (actor1.getShows().size() == actor2.getShows().size() && actor1.getNrRomanticShows() > actor2.getNrRomanticShows()) {
            return -1;
        }
        else if (actor1.getNrRomanticShows() == actor2.getNrRomanticShows() && actor1.getName().compareTo(actor2.getName()) > 0) {
            return 1;
        }
        else
            return -1;
    }
    
}
