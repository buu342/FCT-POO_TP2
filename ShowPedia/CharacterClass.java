/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Character class implementation
 */

package ShowPedia;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class CharacterClass implements Character {

    private String characterName;
    private List<Event> events;
    private List<Relationship> relationships;

    public CharacterClass(String characterName) {
        this.characterName = characterName;
        this.events = new LinkedList<>();
        this.relationships = new LinkedList<>();
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
    public int getNumParents() {
        int num = 0;
        Iterator<Relationship> it = this.relationships.iterator();
        while (it.hasNext())
        {
            Relationship temp = it.next();
            if (temp instanceof RelationshipFamilyClass && temp.getCharacter2() == this)
                num++;
        }
        return num;
    }    
    
    @Override
    public int getNumChildren() {
        int num = 0;
        Iterator<Relationship> it = this.relationships.iterator();
        while (it.hasNext())
        {
            Relationship temp = it.next();
            if (temp instanceof RelationshipFamilyClass && temp.getCharacter1() == this)
                num++;
        }
        return num;
    }
    
}
