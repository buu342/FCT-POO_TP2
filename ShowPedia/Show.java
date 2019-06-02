/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Show object interface
 */

package ShowPedia;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import Exceptions.*;

public interface Show {

    /**
     * Adds a new season to this show.
     */
    void addSeason();

    /**
     * Adds an episode with the name <code>episode</code> to the season
     * <code>season</code> of this show.
     * 
     * @param season  An <code>int</code> with the number of the season to insert
     *                the episode to.
     * @param episode A <code>String</code> with the name of the episode.
     */
    void addEpisode(int season, String episode);

    /**
     * Adds the character <code>character</code> to this show.
     * 
     * @param character A <code>Character</code> object to add to this show.
     */
    void addCharacter(Character character);

    /**
     * Adds the character <code>parent</code> and <code>child</code> to this show's
     * list of families.
     * 
     * @param parent A <code>Character</code> object to add to this show's list of
     *               parents.
     * @param child  A <code>Character</code> object to add to this show's list of
     *               children.
     */
    void addFamily(Character parent, Character child) throws ExistingRelationshipException;

    /**
     * Adds the character <code>lover1</code> and <code>lover2</code> to this show's
     * list of lovers.
     * 
     * @param lover1 A <code>Character</code> object to add to this show's list of
     *               lovers.
     * @param lover2 A <code>Character</code> object to add to this show's list of
     *               lovers.
     */
    void addLovers(Character lover1, Character lover2) throws ExistingRelationshipException;

    /**
     * Adds the quote <code>quote</code> to this show's list of quotes.
     * 
     * @param quote A <code>Character</code> object to add to the list of this
     *              show's quotes.
     */
    void addQuote(Quote quote);

    /**
     * Adds the event <code>event</code> to this show's list of events.
     * 
     * @param season  An <code>int</code> with the season this event happened in.
     * @param episode An <code>int</code> with the episode this event happened in.
     * @param event   An <code>Event</code> object to add to the list of this show's
     *                events.
     */
    void addEvent(int season, int episode, Event event);

    /**
     * Retrieves the name of this show.
     * 
     * @return A <code>String</code> with the name of this show.
     */
    String getName();

    /**
     * Returns a list of all the episodes in the season <code>season</code> of this
     * show.
     * 
     * @param season An <code>int</code> with the number of the season to return.
     * @return A <code>Map&lt;Integer, Episode&gt;</code> that contains all the
     *         episodes in the season <code>season</code>.
     */
    Map<Integer, Episode> getSeason(int season);

    /**
     * Retrieves the name of the episode in season <code>episode</code>., episode
     * number <code>episode</code>.
     * 
     * @param season  An <code>int</code> with the season to get the name of.
     * @param episode An <code>int</code> with the episode to get the name of.
     * @return A <code>String</code> with the name of this episode.
     */
    String getEpisodeName(int season, int episode);

    /**
     * Retrieve a pointer to the character object with name <code>name</code>.
     * 
     * @param name A <code>String</code> with the name of the character to get the
     *             name of.
     * @return A <code>Character</code> object pointer with the requested character.
     * @throws NoCharacterException
     */
    Character getCharacter(String name) throws NoCharacterException;

    /**
     * Retrieves a list of this show's parents.
     * 
     * @return A <code>List&lt;Character&gt;</code> with a list of this show's
     *         parents.
     */
    List<Character> getParents();

    /**
     * Retrieves a list of this show's children.
     * 
     * @return A <code>List&lt;Character&gt;</code> with a list of this show's
     *         children.
     */
    List<Character> getChildren();

    /**
     * Retrieves a list of this show's lovers.
     * 
     * @return A <code>List&lt;Character&gt;</code> with a list of this show's
     *         lovers.
     */
    List<Character> getLovers();

    /**
     * Retrieves a quote object pointer with the quote <code>quote</code>.
     * 
     * @param quote A <code>String</code> with the quote.
     * @return A <code>Quote</code> object pointer that has the requested quote.
     */
    Quote getQuote(String quote);

    /**
     * Retrieves a list of this show's events.
     * 
     * @return A
     *         <code>Map&lt;Integer, SortedMap&lt;Integer, List&lt;Event&gt;&gt;&gt;</code>
     *         with a list of this show's events.
     */
    Map<Integer, SortedMap<Integer, List<Event>>> getEvents();

    /**
     * Retrieves a list of this show's events per season.
     * 
     * @return A <code>Map&lt;Integer, List&lt;Event&gt;&gt;</code> with a list of this
     *         show's events per season.
     */
    Map<Integer, List<Event>> getEventsPerSeason();

    /**
     * Retrieves the number of seasons in this show.
     * 
     * @return An <code>int</code> with the number of seasons in this show.
     */
    int getNrSeasons();

    /**
     * Retrieves the number of episodes in this show.
     * 
     * @return An <code>int</code> with the number of episodes in this show.
     */
    int getNrEpisodes();

    /**
     * Checks whether this show has the character with name <code>name</code>
     * registered.
     * 
     * @return <code>true</code> if the character is registered, <code>false</code>
     *         if it is not.
     */
    boolean hasCharacter(String name);

    /**
     * Checks whether this show has the quote with name <code>quote</code>
     * registered.
     * 
     * @return <code>true</code> if the quote is registered, <code>false</code> if
     *         it is not.
     */
    boolean hasQuote(String quote);

}
