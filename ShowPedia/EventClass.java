/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Event class implementation
 */

package ShowPedia;
import java.util.Map;

public class EventClass implements Event {

    String description;
    Map<String, Character> characters;
	private int season;
	private int episode;
    
    public EventClass(int season, int episode, String description, Map<String, Character> tmpCharacters) {
        this.description = description;
        this.characters = tmpCharacters;
        this.setSeason(season);
        this.setEpisode(season);

    }
    @Override
    public String getDescription() {
        return this.description;
    }
   
    @Override
    public Map<String, Character> getCharacters() {
        return this.characters;
    }

	/**
	 * @return the season
	 */
    @Override
	public int getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
    @Override
	public void setSeason(int season) {
		this.season = season;
	}

	/**
	 * @return the episode
	 */
    @Override
	public int getEpisode() {
		return episode;
	}

	/**
	 * @param episode the episode to set
	 */
    @Override
	public void setEpisode(int episode) {
		this.episode = episode;
	}
    
    

}
