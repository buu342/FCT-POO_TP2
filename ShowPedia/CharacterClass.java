/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Character class implementation
 */

package ShowPedia;

import java.util.LinkedList;
import java.util.List;

public abstract class CharacterClass implements Character {

    private String characterName;
    private List<Event> events;
    private List<Relationship> relationships;
    private List<Quote> quotes;

    public CharacterClass(String characterName) {
        this.characterName = characterName;
        this.events = new LinkedList<>();
        this.relationships = new LinkedList<>();
        this.quotes = new LinkedList<>();
    }

    @Override
    public String getCharacterName() {
        return this.characterName;
    }
    
    @Override
    public List<Event> getEvents() {
        return this.events;
    }
    
    @Override
    public List<Quote> getQuotes() {
        return this.quotes;
    }
    
    @Override
    public List<Relationship> getRelationships() {
        return this.relationships;
    }
    
    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }
    
    @Override
    public void addRelationship(Relationship relationship) {
        this.relationships.add(relationship);
    }
    
    @Override
    public void addQuote(Quote quote) {
        this.quotes.add(quote);
    }
}
