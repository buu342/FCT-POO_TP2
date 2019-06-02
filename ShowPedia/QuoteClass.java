/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Quote class implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;

public class QuoteClass implements Quote {
    
   
	private Map<String, Character> characters;
	private String quote;
	private int season;
	private int episode;

	public QuoteClass(String quote, int season, int episode) {
       this.quote = quote;
       this.characters = new HashMap<String,Character>();
       this.season = season;
       this.episode = episode;
	}

	@Override
	public void addCharacter(Character character) {
		if(!characters.containsKey(character.getCharacterName())) {
			characters.put(character.getCharacterName(), character);
		}
	}

	@Override
	public String getQuote() {
		return quote;
	}
	
	@Override
    public int getSeason() {
        return this.season;
    }
	
	@Override
    public int getEpisode() {
        return this.episode;
    }
	
	@Override
	public Map<String, Character> getCharacters() {
		return characters;
	}

	@Override
	public void setQuote(String quote) {
		this.quote = quote;
	}

}
