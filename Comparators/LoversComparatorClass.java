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
        return actor2.getNrRomances() - actor1.getNrRomances();
    }
    
}
