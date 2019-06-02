/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Company object interface
 */

package ShowPedia;

import java.util.Map;

public interface Company {

    /**
     * Adds the character <code>character</code> to the list of characters rendered
     * by this company.
     * 
     * @param character A <code>Character</code> object to add to the list of
     *                  characters rendered by this company.
     */
    void addCharacter(Character character);

    /**
     * Retrieves the name of this company.
     * 
     * @return A <code>String</code> with the name of this company.
     */
    String getName();

    /**
     * Retrieves a list of characters rendered by this company.
     * 
     * @return A <code>Map&lt;String, Character&gt;</code> with a list of characters
     *         rendered by this company.
     */
    Map<String, Character> getCharacters();

    /**
     * Retrieves the revenue made by this company.
     * 
     * @return An <code>int</code> with the revenue made by this company.
     */
    int getRevenue();

    /**
     * Sets the revenue of this company to the revenue <code>revenue</code>.
     * 
     * @param revenue An <code>int</code> with the revenue made by this company.
     */
    void setRevenue(int revenue);

}
