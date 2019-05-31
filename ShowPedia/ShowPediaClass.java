/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

import exceptions.*;

public class ShowPediaClass implements ShowPedia {
    
    private Map <String, Actor> actors;
    private Map <String, Character> characters;
    private Map <String, Company> companies;
    private Map <String, Show> shows;
    private Map <String, Quote> quotes;
    private Show current;
    
    public ShowPediaClass() {
        this.actors = new HashMap<String, Actor>();
        this.characters = new HashMap<String, Character>();
        this.companies = new HashMap<String, Company>();
        this.shows = new HashMap<String, Show>();
        this.quotes = new HashMap<String, Quote>();
        this.current = null;
    }

    @Override
    public Show getCurrent() throws NoShowSelectedException {
        if (this.current == null) 
            throw new NoShowSelectedException();

        return this.current;
    }

    @Override
    public void addShow(String name) throws ExistingShowException {
        if (hasShow(name)) 
            throw new ExistingShowException();

        Show tmp = new ShowClass(name);
        this.shows.put(name, tmp);
        this.current = tmp;
    }

    @Override
    public void switchToShow(String show) throws NonExistingShowException {
        if (!hasShow(show)) 
            throw new NonExistingShowException();
     
        this.current = this.shows.get(show);
    }

    @Override
    public void addSeason() throws NoShowSelectedException {
        if (this.current == null)
            throw new NoShowSelectedException();

        this.current.addSeason();
    }

    @Override
    public void addEpisode(int season, String episode) throws NoShowSelectedException, NoSeasonException {
        if (this.current == null)
            throw new NoShowSelectedException();
        
        if (!hasSeason(season))
            throw new NoSeasonException();

        this.current.addEpisode(season, episode);
    }

    @Override
    public void addCharacter(String type, String characterName, String actorName, int fee) throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException {
        if (this.current == null)
            throw new NoShowSelectedException();
        
        if (!type.equalsIgnoreCase("virtual") || !type.equalsIgnoreCase("real"))
            throw new InvalidTypeException();
        
        if (hasCharacter(characterName))
            throw new ExistingCharacterException();
        
        if(fee<0) 
            throw new InvalidFeeException();
    }
    
    @Override
    public Company kingOfCGI() {
         Iterator<Entry<String, Character>> tmp = characters.entrySet().iterator();
             while(tmp.hasNext()) {
                 if(tmp.next() instanceof CharacterRealClass) {
                     
                 }
             }
        return null;
    }

    @Override
    public Actor getActor(String name) {
        return actors.get(name);
    }
    
    // Check whether a show has already been registered
    private boolean hasShow(String show) {
        return this.shows.containsKey(show);
    }
    
    // Check whether a season exists for a show
    private boolean hasSeason(int season) {
        return (this.current.getSeason(season) != null);
    }

    // Check whether a character has already been registered
    private boolean hasCharacter(String name) {
        return false;
    }

}
