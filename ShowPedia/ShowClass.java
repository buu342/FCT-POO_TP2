/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Show class implementation
 */

package ShowPedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import Exceptions.*;

public class ShowClass implements Show {

    private int nrEpisodes;
    private Map<Integer, Map<Integer, Episode>> seasons;
    private Map<String, Character> characters;
    private String name;
    private Map<Integer, SortedMap<Integer, List<Event>>> events;
    private Map<String, Quote> quotes;
    private List<Character> parents;
    private List<Character> children;
    private List<Character> lovers;

    public ShowClass(String name) {
        this.nrEpisodes = 0;
        this.seasons = new HashMap<Integer, Map<Integer, Episode>>();
        this.characters = new HashMap<String, Character>();
        this.events = new TreeMap<Integer, SortedMap<Integer, List<Event>>>();
        this.quotes = new HashMap<String, Quote>();
        this.name = name;
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
        this.lovers = new LinkedList<>();
        addSeason();
    }

    @Override
    public void addSeason() {
        int season = this.seasons.size() + 1;

        Map<Integer, Episode> episodes = new HashMap<Integer, Episode>();
        this.seasons.put(season, episodes);

        SortedMap<Integer, List<Event>> eventsSeason = new TreeMap<Integer, List<Event>>();
        events.put(season, eventsSeason);
    }

    @Override
    public void addEpisode(int season, String episode) {
        int episodeNr = this.seasons.get(season).size() + 1;
        Episode tmp = new EpisodeClass(episode);
        this.seasons.get(season).put(episodeNr, tmp);
        this.nrEpisodes++;
        List<Event> eventsInEpisode = new ArrayList<Event>();
        events.get(season).put(episodeNr, eventsInEpisode);
    }

    @Override
    public void addCharacter(Character character) {
        this.characters.put(character.getName(), character);
    }

    @Override
    public void addFamily(Character parent, Character child) throws ExistingRelationshipException {
        if (child.getParents().contains(parent))
            throw new ExistingRelationshipException();

        if (parent.getChildren().contains(child))
            throw new ExistingRelationshipException();

        parent.addChild(child);
        child.addParent(parent);
        this.parents.add(child);
        this.children.add(parent);
    }

    @Override
    public void addLovers(Character lover1, Character lover2) throws ExistingRelationshipException {
        if (lover1.getLovers().contains(lover2))
            throw new ExistingRelationshipException();

        if (lover2.getLovers().contains(lover1))
            throw new ExistingRelationshipException();

        lover2.addLover(lover1);
        lover1.addLover(lover2);

        this.lovers.add(lover1);
        this.lovers.add(lover2);
    }

    @Override
    public void addQuote(Quote quote) {
        quotes.put(quote.getQuote(), quote);
    }

    @Override
    public void addEvent(int season, int episode, Event event) {
        seasons.get(season).get(episode).addEvent(event);
        events.get(season).get(episode).add(event);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<Integer, Episode> getSeason(int season) {
        return this.seasons.get(season);
    }

    @Override
    public String getEpisodeName(int season, int episode) {
        return this.seasons.get(season).get(episode).getName();
    }

    @Override
    public Character getCharacter(String name) {
        return this.characters.get(name);
    }

    @Override
    public List<Character> getParents() {
        return this.parents;
    }

    @Override
    public List<Character> getChildren() {
        return this.children;
    }

    @Override
    public List<Character> getLovers() {
        return this.lovers;
    }

    @Override
    public Quote getQuote(String quote) {
        return quotes.get(quote);
    }

    @Override
    public Map<Integer, SortedMap<Integer, List<Event>>> getEvents() {
        return this.events;
    }

    @Override
    public Map<Integer, List<Event>> getEventsPerSeason() {
        Map<Integer, List<Event>> retValue = new HashMap<Integer, List<Event>>();
        int numseasons = this.seasons.size();
        for (int i = 1; i <= numseasons; i++) {
            int numepisodes = seasons.get(i).size();
            List<Event> episodeeventlist = new LinkedList<>();
            for (int j = 1; j <= numepisodes; j++) {
                episodeeventlist.addAll(seasons.get(i).get(j).getEvents());
            }
            retValue.put(i, episodeeventlist);
        }
        return retValue;
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
    public boolean hasCharacter(String name) {
        return characters.containsKey(name);
    }

    @Override
    public boolean hasQuote(String quote) {
        return quotes.containsKey(quote);
    }

}