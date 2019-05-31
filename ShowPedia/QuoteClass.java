/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Quote class implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;

public class QuoteClass implements Quote {
    
   
	private Map<String, Character> characters;
	private String quote;

	public QuoteClass(String quote) {
       setQuote(quote);
       characters = new HashMap<String,Character>();
   
	}

	@Override
	public void addCharacter(Character character) {
		if(!characters.containsKey(character.getCharacterName())) {
			characters.put(character.getCharacterName(), character);
		}
	}

	/**
	 * @return the quote
	 */
	@Override
	public String getQuote() {
		return quote;
	}

	/**
	 * @param quote the quote to set
	 */
	@Override
	public void setQuote(String quote) {
		this.quote = quote;
	}

}
