/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Event object interface
 */

package ShowPedia;

import java.util.List;

public interface Event {
    
    /**
     * Retrieves a description of this event.
     * @return A <code>String</code> with a description of this event.
     */
    String getDescription();
    
    /**
     * Retrieves the episode which this event happened in.
     * @return An <code>Episode</code> object pointing to the episode which this event happened in.
     */
    Episode getEpisode();
   
    /**
     * Retrieves a list of characters relating to this event.
     * @return A <code>List&lt;Character&gt;</code> of characters relating to this event.
     */
    List<Character> getCharacters();

}
