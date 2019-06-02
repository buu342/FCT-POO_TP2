/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Alphabetical order comparator
 */

package Comparators;

import java.util.Comparator;

public class AlphabeticalComparatorClass implements Comparator<String> {
    
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
    
}
