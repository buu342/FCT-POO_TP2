/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Actor class implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorClass implements Actor {

    private String name;
    private List<Quote> quotes;
    private Map<String, Character> characters;
    private Map<String, Show> shows;

    public ActorClass(String name) {
        this.name = name;
        this.shows = new HashMap<String, Show>();
        this.characters = new HashMap<String, Character>();
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNrShows() {
        return shows.size();
    }

    @Override
    public void addShow(Show show) {
        this.shows.put(show.getName(), show);
    }
    
}