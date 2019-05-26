package ShowPedia;

import java.util.HashMap;
import java.util.Map;


public class ShowClass implements Show {

    private Map<Integer, Map<Integer, Episode>> seasons;
	private String name;
	private int nrSeasons;
	private int nrEpisodes;

    public ShowClass(String name) {
        seasons = new HashMap<Integer, Map<Integer,Episode>>();
        this.name=name;
        nrSeasons = 0;
        nrEpisodes = 0;
    }

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getNrSeasons() {
		return nrSeasons;
	}

	@Override
	public int getNrEpisodes() {
		return nrEpisodes;
	}

	@Override
	public void addSeason() {
		int season = seasons.size()+1;
		Map<Integer, Episode> episodes = new HashMap<Integer, Episode>();
		seasons.put(season, episodes);
		nrSeasons++;
	}

	@Override
	public Map<Integer, Episode> getSeason(int season) {
		return seasons.get(season);
	}

	@Override
	public void addEpisode(int season, String episode) {
		
		int episodeNr = seasons.get(season).size()+1;
		Episode tmp = new EpisodeClass(episode);
		seasons.get(season).put(episodeNr, tmp);
		nrEpisodes++;		
	}
    
}