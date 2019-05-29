/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System interface
 */

package ShowPedia;

import exceptions.*;

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
     */
	Company kingOfCGI();

	/**
     * Returns a pointer to the actor object with name <code>name</code>.
     * @param name          A <code>String</code> with the name of the actor.
     * @return The <code>Actor</code> object with name <code>name</code>.
     */
	Actor getActor(String name);
}
