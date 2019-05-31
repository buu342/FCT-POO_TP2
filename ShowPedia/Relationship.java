/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Relationship object interface
 */

package ShowPedia;

public interface Relationship {
    
    /**
     * Retrieves the first character in the relationship.
     * @return A <code>Character</code> object pointing to the first character in the relationship.
     */
    Character getCharacter1();

    /**
     * Retrieves the second character in the relationship.
     * @return A <code>Character</code> object pointing to the second character in the relationship.
     */
    Character getCharacter2();
    
    /**
     * Returns the type of relationship between two characters.
     * @return A <code>String</code> with the type of relationship.
     */
    String getType();
    
}
