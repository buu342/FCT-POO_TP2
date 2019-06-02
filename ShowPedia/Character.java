/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Character object interface
 */

package ShowPedia;

import java.util.List;

public interface Character {

    /**
     * Adds the character <code>character</code> to the list of this character's
     * parents.
     * 
     * @param character A <code>Character</code> object pointer to add to the list
     *                  of this character's parents.
     */
    void addParent(Character character);

    /**
     * Adds the character <code>character</code> to the list of this character's
     * children.
     * 
     * @param character A <code>Character</code> object pointer to add to the list
     *                  of this character's children.
     */
    void addChild(Character character);

    /**
     * Adds the character <code>character</code> to the list of this character's
     * lovers.
     * 
     * @param character A <code>Character</code> object pointer to add to the list
     *                  of this character's lovers.
     */
    void addLover(Character character);

    /**
     * Adds the quote <code>quote</code> to the list of this character's quotes.
     * 
     * @param quote A <code>Quote</code> object pointer to add to the list of this
     *              character's quotes.
     */
    void addQuote(Quote quote);

    /**
     * Adds the event <code>event</code> to the list of events involving to this
     * character.
     * 
     * @param event An <code>Event</code> object pointer that involves this
     *              character.
     */
    void addEvent(Event event);

    /**
     * Retrieves the name of this character.
     * 
     * @return A <code>String</code> with the name of this base.
     */
    String getName();

    /**
     * Retrieves the show which this character is in.
     * 
     * @return A <code>Show</code> object pointer which this character is in.
     */
    Show getShow();

    /**
     * Retrieves a list of all quotes said by this character.
     * 
     * @return A <code>List&lt;Quote&gt;</code> of all quotes said by this
     *         character.
     */
    List<Quote> getQuotes();

    /**
     * Retrieves a list of all events involving to this character.
     * 
     * @return A <code>List&lt;Event&gt;</code> of all events involving to this
     *         character.
     */
    List<Event> getEvents();

    /**
     * Retrieves a list of all of this character's parents.
     * 
     * @return A <code>List&lt;Character&gt;</code> of all of this character's
     *         parents.
     */
    List<Character> getParents();

    /**
     * Retrieves a list of all of this character's children.
     * 
     * @return A <code>List&lt;Character&gt;</code> of all of this character's
     *         children.
     */
    List<Character> getChildren();

    /**
     * Retrieves a list of all of this character's siblings.
     * 
     * @return A <code>List&lt;Character&gt;</code> of all of this character's
     *         siblings.
     */
    List<Character> getSiblings();

    /**
     * Retrieves a list of all of this character's lovers.
     * 
     * @return A <code>List&lt;Character&gt;</code> of all of this character's
     *         lovers.
     */
    List<Character> getLovers();

    /**
     * Retrieves a list of all of this character's parent's names.
     * 
     * @return A <code>List&lt;String&gt;</code> of all of this character's parent's
     *         names.
     */
    List<String> getParentsNames();

    /**
     * Retrieves a list of all of this character's children's names.
     * 
     * @return A <code>List&lt;String&gt;</code> of all of this character's
     *         children's names.
     */
    List<String> getChildrenNames();

    /**
     * Retrieves a list of all of this character's sibling's names.
     * 
     * @return A <code>List&lt;String&gt;</code> of all of this character's
     *         children's names.
     */
    List<String> getSiblingsNames();

    /**
     * Retrieves a list of all of this character's sibling's names.
     * 
     * @return A <code>List&lt;String&gt;</code> of all of this character's
     *         sibling's names.
     */
    List<String> getLoversNames();

    /**
     * Retrieves a the number of parents this character has
     * 
     * @return A <code>List&lt;String&gt;</code> of all of this character's
     *         sibling's names.
     */
    void setShow(Show show);

}
