/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Quote object interface
 */

package ShowPedia;

import java.util.Map;

public interface Quote {

    /**
     * Adds the character <code>character</code> to the list of characters that have
     * said this quote.
     * 
     * @param show A <code>Character</code> object pointer to add to the the list of
     *             characters that have said this quote.
     */
    void addCharacter(Character character);

    /**
     * Retrieves this quote's quote.
     * 
     * @return A <code>String</code> with the quote.
     */
    String getQuote();

    /**
     * Retrieves the season which this quote was said.
     * 
     * @return An <code>int</code> with the season which this quote was said.
     */
    int getSeason();

    /**
     * Retrieves the episode which this quote was said.
     * 
     * @return An <code>int</code> with the episode which this quote was said.
     */
    int getEpisode();

    /**
     * Retrieves a list of characters that have said this quote.
     * 
     * @return A <code>Map&lt;String, Character&gt;</code> with a list of characters
     *         that have said this quote.
     */
    Map<String, Character> getCharacters();

}
