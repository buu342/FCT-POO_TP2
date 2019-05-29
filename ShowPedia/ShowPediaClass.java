/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System implementation
 */

package ShowPedia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.*;

public class ShowPediaClass implements ShowPedia {
    
	Map <String, Show> shows;
	Map <String, Character> characters;
	List<Actor> actors;
    String current;
    
    public ShowPediaClass() {
        this.shows = new HashMap<String, Show>();
        this.actors = new ArrayList<Actor>();
        this.current = "";
        
    }

	@Override
	public Show getCurrent() throws NoShowSelectedException {
		if(this.current == "") {
			throw new NoShowSelectedException();
		}else {
			return this.shows.get(this.current);
		}
		
	}

	@Override
	public void addShow(String name) throws ExistingShowException {
		if(hasShow(name)) {
			throw new ExistingShowException();
		}else {
			Show tmp = new ShowClass(name);
			this.shows.put(name, tmp);
		}
		
	}

	@Override
	public void switchToShow(String show) throws NonExistingShowException {
		if(!hasShow(show)) {
			throw new NonExistingShowException();
		}else {
		    this.current = show;
		}
	}

	@Override
	public void addSeason() throws NoShowSelectedException {
		if(this.current == "") {
			throw new NoShowSelectedException();
		}else {
		    this.shows.get(this.current).addSeason();
		}
		
	}

	@Override
	public void addEpisode(int season, String episode) throws NoShowSelectedException, NoSeasonException {
		if(this.current == "") {
			throw new NoShowSelectedException();
		}else if(!hasSeason(season)) {
			throw new NoSeasonException();
		}else {
		    this.shows.get(this.current).addEpisode(season, episode);
		}
			
	}

	@Override
	public void addCharacter(String type, String characterName, String actorName, int fee) throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException {
		if(this.current == "") {
			throw new NoShowSelectedException();
		}else if(!type.equalsIgnoreCase("virtual") && !type.equalsIgnoreCase("real")) {
			throw new InvalidTypeException();
		}else if(hasCharacter(characterName)) {
			throw new ExistingCharacterException();
		}else if(fee<0) {
			throw new InvalidFeeException();
		}
		
	}
	
	// Check whether a show has already been registered
	private boolean hasShow(String show) {
        return this.shows.containsKey(show);
    }
	
	// Check whether a season has already been registered
	private boolean hasSeason(int season) {
	    return this.shows.get(this.current).getSeason(season).size()<season;
	}

	// Check whether a character has already been registered
	private boolean hasCharacter(String name) {
		return this.characters.containsKey(name);
	}

}
