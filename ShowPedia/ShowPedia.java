/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System interface
 */

package ShowPedia;

import java.util.List;

import Exceptions.*;

public interface ShowPedia {

    /**
     * Returns the currently selected show.
     * @return The <code>Show</code> object that is currently being viewed by the user.
     */
    Show getCurrent() throws NoShowSelectedException;

    /**
     * Adds a show with name <code>show</code> to the database.
     * @param show  A <code>String</code> with the name of the show.
     */
    void addShow(String show) throws ExistingShowException;

    /**
     * Changes the currently viewed show to <code>show</code>.
     * @param show  A <code>String</code> with the name of the show to view.
     */
    void switchToShow(String show) throws NonExistingShowException;

    /**
     * Adds a new season to the list of seasons of the currently viewed show.
     */
    void addSeason() throws NoShowSelectedException;

    /**
     * Adds an episode with the name <code>episode</code> to the season <code>season</code> of the currently viewed show.
     * @param season    An <code>int</code> with the number of the season to insert the episode to.
     * @param episode   A <code>String</code> with the name of the episode.
     */
    void addEpisode(int season, String episode) throws NoShowSelectedException, NoSeasonException;

    /**
     * Adds a character of type <code>type</code>, name <code>name</code>, actor <code>actor</code> and fee <code>fee</code> to the database.
     * @param type          A <code>String</code> with the type of character. Acceptable values are <code>"virtual"</code> and <code>"real"</code>
     * @param characterName A <code>String</code> with the name of the actor who portrays/voices this character.
     * @param actorName     A <code>String</code> with the name of this character.
     * @param fee           An <code>int</code> with the cost of paying for this character.
     */
    void addCharacter(String type, String characterName, String actorName, int fee) throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException;

       /**
     * Returns a pointer to the company object that has spent the most on CGI.
     * @param name          A <code>String</code> with the name of the actor.
     * @return A <code>Company</code> object that has spent the most on CGI.
     * @throws NoVirtualCharactersException 
     */
    Company kingOfCGI() throws NoVirtualCharactersException;

    /**
     * Returns a pointer to the actor object with name <code>name</code>.
     * @param name          A <code>String</code> with the name of the actor.
     * @return The <code>Actor</code> object with name <code>name</code>.
     */
    Actor getActor(String name);

	void addEvent(String description, int season, int episode, List<String> characters) throws NoShowSelectedException, NoSeasonException, NoEpisodeException, NoCharacterException, DuplicateCharacterException;

	boolean hasCharacter(String name);

	boolean hasEpisode(int season, int episode);

	boolean hasShow(String show);

	boolean hasSeason(int season);
	
	String hasCharacters(List<String> characters);

	Company getCompany(String name);

	Character getCharacter(String characterName);
	
	void addQuote(int season, int episode, String character, String quote) throws NoShowSelectedException, NoSeasonException, NoEpisodeException, NoCharacterException;

	void famousQuote(String quote) throws UnexistingQuoteException;
  
	void alsoAppearsOn(String character) throws NoShowSelectedException, NoCharacterException, VirtualActorException;
	
	void addRelationship(String parent, String child) throws NoShowSelectedException, SingleRelationshipException, NoCharacterException, NoChildException, ExistingRelationshipException;

	void addLovers(String lover1, String lover2) throws NoShowSelectedException, SingleRelationshipException, NoCharacterException, NoChildException, ExistingRelationshipException;

	List<Actor> mostRomantic(String name) throws NoCharacterException, NoLoveException;
}