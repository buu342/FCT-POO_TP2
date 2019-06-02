/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Event object interface
 */

package ShowPedia;

import java.util.Map;

public interface Event {
    
    /**
     * Retrieves a description of this event.
     * @return A <code>String</code> with a description of this event.
     */
    String getDescription();
   
    /**
     * Retrieves a list of characters relating to this event.
     * @return A <code>List&lt;Character&gt;</code> of characters relating to this event.
     */
    Map<String, Character> getCharacters();
    
}
