/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Episode class implementation
 */

package ShowPedia;

import java.util.List;
import java.util.LinkedList;

public class EpisodeClass implements Episode {

    private String name;
    private List<Event> events;

    public EpisodeClass(String name) {
        this.name = name;
        this.events = new LinkedList<>();
    }

    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Event> getEvents() {
        return this.events;
    }

}
