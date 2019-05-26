package ShowPedia;

import java.util.Map;

public interface Show {
	
	String getName();

	int getNrSeasons();

	int getNrEpisodes();

	void addSeason();

	Map<Integer, Episode> getSeason(int season);

	void addEpisode(int season, String episode);

	
}
