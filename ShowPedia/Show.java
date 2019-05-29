/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Show object interface
 */

package ShowPedia;

import java.util.Map;

public interface Show {
	
    /**
     * Retrieves the name of this show.
     * @return A <code>String</code> with the name of this show.
     */
	String getName();

    /**
     * Retrieves the number of seasons in this show.
     * @return An <code>int</code> with the number of seasons in this show.
     */
	int getNrSeasons();

    /**
     * Retrieves the number of episodes in this show.
     * @return An <code>int</code> with the number of episodes in this show.
     */
	int getNrEpisodes();

    /**
     * Adds a new season to this show.
     */
	void addSeason();

    /**
     * Returns a list of all the episodes in the season <code>season</code> of this show.
     * @param season    An <code>int</code> with the number of the season to return.
     * @return A <code>Map<Integer, Episode></code> that contains all the episodes in the season <code>season</code>.
     */
	Map<Integer, Episode> getSeason(int season);

    /**
     * Adds an episode with the name <code>episode</code> to the season <code>season</code> of this show.
     * @param season    An <code>int</code> with the number of the season to insert the episode to.
     * @param episode   A <code>String</code> with the name of the episode.
     */
	void addEpisode(int season, String episode);

	Map<String, Character> getCharacters();
	
}
