/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Character object interface
 */

package ShowPedia;

import java.util.List;

public interface Character {

    /**
     * Retrieves the name of this character.
     * @return A <code>String</code> with the name of this base.
     */
    String getCharacterName();
    
    /**
     * Retrieves a list of all events involving to this character.
     * @return A <code>List&lt;Event&gt;</code> of all events involving to this character.
     */
    List<Event> getEvents();
    
    /**
     * Retrieves a list of all relationships involving this character.
     * @return A <code>List&lt;Relationship&gt;</code> of all relationships involving this character.
     */
    List<Relationship> getRelationships();
    
    
    /**
     * Adds the event <code>event</code> to the list of events involving to this character.
     * @param event         An <code>Event</code> object pointer that involves this character.
     */
    void addEvent(Event event);
    
    /**
     * Adds the relationship <code>relationship</code> to the list of relationships involving this character.
     * @param relationship  A <code>Relationship</code> object pointer that involves this character.
     */
    void addRelationship(Relationship relationship);

  
}

