/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System interface
 */

package ShowPedia;

import java.util.List;

import Exceptions.*;
import ShowPedia.Character;

public interface ShowPedia {

    /**
     * Adds a show with name <code>show</code> to the database.
     * 
     * @param show A <code>String</code> with the name of the show.
     * @throws ExistingShowException
     */
    void addShow(String show) throws ExistingShowException;

    /**
     * Adds a new season to the list of seasons of the currently viewed show.
     * 
     * @throws NoShowSelectedException
     */
    void addSeason() throws NoShowSelectedException;

    /**
     * Adds an episode with the name <code>episode</code> to the season
     * <code>season</code> of the currently viewed show.
     * 
     * @param season  An <code>int</code> with the number of the season to insert
     *                the episode to.
     * @param episode A <code>String</code> with the name of the episode.
     * @throws NoShowSelectedException
     * @throws NoSeasonException
     */
    void addEpisode(int season, String episode) throws NoShowSelectedException, NoSeasonException;

    /**
     * Adds a character of type <code>type</code>, name <code>name</code>, actor
     * <code>actor</code> and fee <code>fee</code> to the database.
     * 
     * @param type          A <code>String</code> with the type of character.
     *                      Acceptable values are <code>"virtual"</code> and
     *                      <code>"real"</code>.
     * @param characterName A <code>String</code> with the name of the actor who
     *                      portrays/voices this character.
     * @param actorName     A <code>String</code> with the name of this character.
     * @param fee           An <code>int</code> with the cost of paying for this
     *                      character.
     * @throws NoShowSelectedException
     * @throws InvalidTypeException
     * @throws ExistingCharacterException
     * @throws InvalidFeeException
     */
    void addCharacter(String type, String characterName, String actorName, int fee)
            throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException;

    /**
     * Adds a family relationship between the character with name
     * <code>parent</code> and <code>child</code>.
     * 
     * @param parent A <code>String</code> with the name of the parent character.
     * @param child  A <code>String</code> with the name of the child character.
     * @throws NoShowSelectedException
     * @throws SingleRelationshipException
     * @throws NoCharacterException
     * @throws NoChildException
     * @throws ExistingRelationshipException
     */
    void addRelationship(String parent, String child) throws NoShowSelectedException, SingleRelationshipException,
            NoCharacterException, NoChildException, ExistingRelationshipException;

    /**
     * Adds a lovers relationship between the character with name
     * <code>lover1</code> and <code>lover2</code>.
     * 
     * @param lover1 A <code>String</code> with the name of the first lover
     *               character.
     * @param lover2 A <code>String</code> with the name of the second lover
     *               character.
     * @throws NoShowSelectedException
     * @throws SingleRelationshipException
     * @throws NoCharacterException
     * @throws NoChildException
     * @throws ExistingRelationshipException
     */
    void addLovers(String lover1, String lover2) throws NoShowSelectedException, SingleRelationshipException,
            NoCharacterException, NoChildException, ExistingRelationshipException;

    /**
     * Adds a quote <code>quote</code> said by the character <code>character</code>
     * to season <code>season</code>, episode <code>episode</code>.
     * 
     * @param season    An <code>int</code> with the number of the season this quote
     *                  was quoted.
     * @param episode   An <code>int</code> with the number of the episode this
     *                  quote was quoted.
     * @param character A <code>String</code> with the name of the character that
     *                  uttered this quote.
     * @param quote     A <code>String</code> containing the quote.
     * @throws NoShowSelectedException
     * @throws NoSeasonException
     * @throws NoEpisodeException
     * @throws NoCharacterException
     */
    void addQuote(int season, int episode, String character, String quote)
            throws NoShowSelectedException, NoSeasonException, NoEpisodeException, NoCharacterException;

    /**
     * Adds a an event to season <code>season</code>, episode <code>episode</code>.
     * 
     * @param description A <code>String</code> describing the event.
     * @param season      An <code>int</code> with the number of the season this
     *                    quote was quoted.
     * @param episode     An <code>int</code> with the number of the episode this
     *                    quote was quoted.
     * @param characters  A <code>List&lt;String&gt;</code> of characters that
     *                    participated in this event.
     * @throws NoShowSelectedException
     * @throws NoSeasonException
     * @throws NoEpisodeException
     * @throws NoCharacterException
     * @throws DuplicateCharacterException
     */
    void addEvent(String description, int season, int episode, List<String> characters) throws NoShowSelectedException,
            NoSeasonException, NoEpisodeException, NoCharacterException, DuplicateCharacterException;

    /**
     * Returns the currently selected show.
     * 
     * @return The <code>Show</code> object that is currently being viewed by the
     *         user.
     * @throws NoShowSelectedException
     */
    Show getCurrent() throws NoShowSelectedException;

    /**
     * Returns a pointer to the character with name <code>name</code>.
     * 
     * @param name A <code>String</code> with the name of the character.
     * @return The <code>Character</code> object pointer with name
     *         <code>name</code>.
     */
    Character getCharacter(String name);

    /**
     * Returns a pointer to the actor object with name <code>name</code>.
     * 
     * @param name A <code>String</code> with the name of the actor.
     * @return The <code>Actor</code> object with name <code>name</code>.
     */
    Actor getActor(String name);

    /**
     * Returns a pointer to the company with name <code>name</code>.
     * 
     * @param name A <code>String</code> with the name of the company.
     * @return The <code>Company</code> object pointer with name <code>name</code>.
     */
    Company getCompany(String name);

    /**
     * Retrieves a list of characters in the blood line between character
     * <code>character1</code> and <code>character2</code>.
     * 
     * @param character1 A <code>String</code> with the first character's name.
     * @param character2 A <code>String</code> with the second character's name.
     * @return A <code>List&lt;String&gt;</code> with a list of names in this
     *         charcter's blood line.
     * @throws NoShowSelectedException
     * @throws NoCharacterException
     * @throws NoChildException
     * @throws SingleRelationshipException
     * @throws NoRelationshipException
     */
    List<String> getRelation(String character1, String character2) throws NoShowSelectedException, NoCharacterException,
            NoChildException, SingleRelationshipException, NoRelationshipException;

    /**
     * Changes the currently viewed show to <code>show</code>.
     * 
     * @param show A <code>String</code> with the name of the show to view.
     * @throws NonExistingShowException
     */
    void switchToShow(String show) throws NonExistingShowException;

    /**
     * Returns a list of actors more romantic than the actor with name
     * <code>name</code>.
     * 
     * @param name A <code>String</code> with the name of the character to check
     *             their sexyness.
     * @return A <code>List&lt;Actor&gt;</code> with a list of actors more romantic
     *         than the actor with name <code>name</code>.
     * @throws NoCharacterException
     * @throws NoLoveException
     */
    List<Actor> mostRomantic(String name) throws NoCharacterException, NoLoveException;

    /**
     * Validates the character with name <code>name</code> for use with the
     * alsoApearsOn command.
     * 
     * @param name A <code>String</code> with the name of the character to validate.
     * @throws NoShowSelectedException
     * @throws NoCharacterException
     * @throws VirtualActorException
     */
    void alsoAppearsOn(String name) throws NoShowSelectedException, NoCharacterException, VirtualActorException;

    /**
     * Validates the quote with quote <code>quote</code> for use with the
     * famousQuotes command.
     * 
     * @param name A <code>String</code> with the quote.
     * @throws UnexistingQuoteException
     */
    void famousQuote(String quote) throws UnexistingQuoteException;

    /**
     * Returns a pointer to the company object that has spent the most on CGI.
     * 
     * @param name A <code>String</code> with the name of the actor.
     * @return A <code>Company</code> object that has spent the most on CGI.
     * @throws NoVirtualCharactersException
     */
    Company kingOfCGI() throws NoVirtualCharactersException;

}
