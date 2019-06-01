/**
 * @author Andre Enes 51099
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
    
    List<Character> getParents();
    
    List<Character> getChildren();
    
    List<Character> getLovers();
    
    void addParent(Character character);
    
    void addChild(Character character);
    
    void addLover(Character character);
    
    Show getShow();
    
    void setShow(Show show);
    
    /**
     * Adds the event <code>event</code> to the list of events involving to this character.
     * @param event         An <code>Event</code> object pointer that involves this character.
     */
    void addEvent(Event event);

    int getNumParents();
    
    int getNumChildren();
    
    int getNumLovers();
}

