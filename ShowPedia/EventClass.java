/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Event class implementation
 */

package ShowPedia;

import java.util.List;

public class EventClass implements Event {

    String description;
    Episode episode;
    List<Character> characters;
    
    public EventClass(String description, Episode episode, List<Character> characters) {
        this.description = description;
        this.episode = episode;
        this.characters = characters;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public Episode getEpisode() {
        return this.episode;
    }
   
    public List<Character> getCharacters() {
        return this.characters;
    }

}
