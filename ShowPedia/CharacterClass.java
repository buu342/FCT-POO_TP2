/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Character class implementation
 */

package ShowPedia;

import java.util.LinkedList;
import java.util.List;

public abstract class CharacterClass implements Character {

    private String characterName;
    private List<Event> events;
    private List<Character> parents;
    private List<Character> children;
    private List<Character> lovers;
	private Show show;
  
    public CharacterClass(Show current, String characterName) {
        this.characterName = characterName;
        this.events = new LinkedList<>();
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
        this.lovers = new LinkedList<>();
        setShow(current);
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
    public List<Character> getParents() {
        return this.parents;
    }
    
    @Override
    public List<Character> getChildren() {
        return this.children;
    }
    
    @Override
    public List<Character> getLovers() {
        return this.lovers;
    }
    
    @Override
    public void addParent(Character character) {
        this.parents.add(character);
    }
    
    @Override
    public void addChild(Character character) {
        this.children.add(character);
    }
    
    @Override
    public void addLover(Character character) {
        this.lovers.add(character);
    }
    
    @Override
    public void addEvent(Event event) {
        this.events.add(event);
    }

    @Override
	public Show getShow() {
		return show;
	}

	@Override
	public void setShow(Show show) {
		this.show = show;
	}
    
    @Override
    public int getNumParents() {
        return this.parents.size();
    }    
    
    @Override
    public int getNumChildren() {
        return this.children.size();
    }
    
    @Override
    public int getNumLovers() {
        return this.lovers.size();
    }
    
}
