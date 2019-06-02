/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Quote object interface
 */

package ShowPedia;

import java.util.Map;

public interface Quote {

	void addCharacter(Character character);

	String getQuote();

	void setQuote(String quote);

	Map<String, Character> getCharacters();

	int getSeason();
	
	int getEpisode();
}
