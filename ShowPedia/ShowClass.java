/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Show class implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;

public class ShowClass implements Show {

    private int nrEpisodes;
    private int nrSeasons;
    private Map <Integer, Map<Integer, Episode>> seasons;
    private Map <String, Character> characters;
    private String name;

    public ShowClass(String name) {
        this.nrEpisodes = 0;
        this.nrSeasons = 0;
        this.seasons = new HashMap<Integer, Map<Integer,Episode>>();
        this.characters = new HashMap<String, Character>();
        this.name = name;
    }

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getNrSeasons() {
		return this.nrSeasons;
	}

	@Override
	public int getNrEpisodes() {
		return this.nrEpisodes;
	}

	@Override
	public void addSeason() {
		int season = this.seasons.size()+1;
		Map<Integer, Episode> episodes = new HashMap<Integer, Episode>();
		this.seasons.put(season, episodes);
		this.nrSeasons++;
	}

	@Override
	public Map<Integer, Episode> getSeason(int season) {
		return this.seasons.get(season);
	}

	@Override
	public void addEpisode(int season, String episode) {
		int episodeNr = this.seasons.get(season).size()+1;
		Episode tmp = new EpisodeClass(episode);
		this.seasons.get(season).put(episodeNr, tmp);
		this.nrEpisodes++;		
	}
    
}