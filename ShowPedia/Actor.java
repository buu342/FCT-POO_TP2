/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Actor object interface
 */

package ShowPedia;

import java.util.Map;

public interface Actor {

    /**
     * Adds the show <code>show</code> to the list of shows this actor has played
     * in.
     * 
     * @param show A <code>Show</code> object to add to the list of shows this actor
     *             has played in.
     */
    void addShow(Show show);

    /**
     * Adds the character <code>character</code> to the list of characters this
     * actor has played as.
     * 
     * @param character A <code>Character</code> object to add to the list of
     *                  characters this actor has played as.
     */
    void addCharacter(Character character);
    
    /**
     * Retrieves the name of this actor.
     * 
     * @return A <code>String</code> with the name of this actor.
     */
    String getName();

    /**
     * Retrieves a list of shows this actor has played in.
     * 
     * @return A <code>Map&lt;String, Show&gt;</code> with a list of shows this actor
     *         has played in.
     */
    Map<String, Show> getShows();

    /**
     * Retrieves the amount of shows this actor has played in.
     * 
     * @return An <code>int</code> with the amount of shows this actor has played
     *         in.
     */
    int getNrShows();

    /**
     * Retrieves the amount of character this actor has played as.
     * 
     * @return An <code>int</code> with the amount of shows this actor has played
     *         in.
     */
    int getNrCharacters();

    /**
     * Retrieves the amount of romances this actor's characters have had.
     * 
     * @return An <code>int</code> with the amount of romances this actor's
     *         characters have had.
     */
    int getNrRomances();

    /**
     * Retrieves the amount of shows with romances this actor has played in.
     * 
     * @return An <code>int</code> with the amount of shows with romances this actor
     *         has played in.
     */
    int getNrRomanticShows();
}