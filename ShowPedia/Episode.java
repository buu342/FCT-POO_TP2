/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Episode object interface
 */

package ShowPedia;

import java.util.List;

public interface Episode {

    /**
     * Retrieves the name of this episode.
     * @return A <code>String</code> with the name of this episode.
     */
    String getName();
    
    /**
     * Retrieves a list of all events in this episode.
     * @return A <code>List&lt;Event&gt;</code> of all events in this episode.
     */
    List<Event> getEvents();
    
    /**
     * Adds the event <code>event</code> to the list of episode events.
     */
    void addEvent(Event event);
}
