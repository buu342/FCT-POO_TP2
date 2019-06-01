/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Actor object interface
 */

package ShowPedia;

import java.util.Map;

public interface Actor {

    /**
     * Retrieves the name of this actor.
     * @return A <code>String</code> with the name of this actor.
     */
    String getName();

    /**
     * Retrieves the amount of shows this actor has played in.
     * @return An <code>int</code> with the amount of shows this actor has played in.
     */
    int getNrShows();

    /**
     * Adds the show <code>show</code> to the list of shows this actor has played in.
     * @param show  A <code>Show</code> object to add to the list of shows this actor has played in.
     */
    void addShow(Show show);

	Map<String, Show> getShows();
	
	int getNrRomanticShows();
    
	void addCharacter(Character character);
	
	int getNrCharacters();
	
	int getNrRomances();
}