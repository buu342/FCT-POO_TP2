/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Show class implementation
 */

package ShowPedia;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ShowClass implements Show {

	private int nrEpisodes;
    private Map <Integer, Map<Integer, Episode>> seasons;
    private Map <String, Character> characters;
    private String name;
    SortedMap <Integer, SortedMap<Integer, List<Event>>> events;

    public ShowClass(String name) {
        this.nrEpisodes = 0;
        this.seasons = new HashMap<Integer, Map<Integer,Episode>>();
        this.characters = new HashMap<String, Character>();
        this.events = new TreeMap <Integer, SortedMap<Integer, List<Event>>>();
        this.name = name;
        addSeason();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNrSeasons() {
        return this.seasons.size();
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
       
        SortedMap<Integer, List<Event>> eventsSeason = new TreeMap <Integer, List<Event>>();
        events.put(season, eventsSeason);
    }
    
    @Override
    public Map<Integer, Episode> getSeason(int season) {
        return this.seasons.get(season);
    }

    @Override
    public void addEpisode(int season, String episode) {
        int episodeNr = this.seasons.get(season).size();
        Episode tmp = new EpisodeClass(episode);
        this.seasons.get(season).put(episodeNr, tmp);
        this.nrEpisodes++;  
        List<Event> eventsInEpisode = new ArrayList <Event>();
        events.get(season).put(episodeNr, eventsInEpisode);
    }

	@Override
	public void addEvent(int season, int episode, Event event) {
		seasons.get(season).get(episode).addEvent(event);
		events.get(season).get(episode).add(event);

	}

	@Override
	public boolean hasCharacter(String name) {
		return characters.containsKey(name);
	}
    
}