/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Event class implementation
 */

package ShowPedia;

import java.util.Map;

public class EventClass implements Event {

    String description;
    Map<String, Character> characters;

    public EventClass(String description, Map<String, Character> tmpCharacters) {
        this.description = description;
        this.characters = tmpCharacters;

    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Map<String, Character> getCharacters() {
        return this.characters;
    }

}
