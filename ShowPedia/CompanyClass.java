/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Company class implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;

public class CompanyClass implements Company {
    
    private String name;
    private Map<String, Character> characters;

	public CompanyClass(String name) {
        this.setName(name);
        characters = new HashMap<String, Character>();
    }

	@Override
	public void addCharacter(Character character) {
		characters.put(character.getCharacterName(), character);	
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Map<String, Character> getCharacters() {
		return characters;
	}
	
}
