package ShowPedia;

import java.util.List;
import java.util.Map;

import exceptions.ExistingCharacterException;
import exceptions.ExistingShowException;
import exceptions.InvalidFeeException;
import exceptions.InvalidTypeException;
import exceptions.NoSeasonException;
import exceptions.NoShowSelectedException;
import exceptions.NonExistingShowException;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowPediaClass implements ShowPedia {
    
	Map <String, Show> shows;
	Map <String, Character> characters;
	List<Actor> actors;
    String current;
    
    public ShowPediaClass() {
        this.shows = new HashMap<String, Show>();
        this.actors = new ArrayList<Actor>();
        current = null;
        
    }

	@Override
	public Show getCurrent() throws NoShowSelectedException {
		if(current == null) {
			throw new NoShowSelectedException();
		}else {
			return shows.get(current);
		}
		
	}

	@Override
	public void addShow(String name) throws ExistingShowException {
		if(hasShow(name)) {
			throw new ExistingShowException();
		}else {
			Show tmp = new ShowClass(name);
			shows.put(name, tmp);
		}
		
	}

	private boolean hasShow(String show) {
		return shows.containsKey(show);
	}

	@Override
	public void switchToShow(String show) throws NonExistingShowException {
		if(!hasShow(show)) {
			throw new NonExistingShowException();
		}else {
			current = show;
		}
	}

	@Override
	public void addSeason() throws NoShowSelectedException {
		if(current == null) {
			throw new NoShowSelectedException();
		}else {
			shows.get(current).addSeason();
		}
		
	}

	@Override
	public void addEpisode(int season, String episode) throws NoShowSelectedException, NoSeasonException {
		if(current == null) {
			throw new NoShowSelectedException();
		}else if(!hasSeason(season)) {
			throw new NoSeasonException();
		}else {
			shows.get(current).addEpisode(season, episode);
		}
			
	}

	private boolean hasSeason(int season) {
		return shows.get(current).getSeason(season).size()<season;
	}

	@Override
	public void addCharacter(String type, String characterName, String name, int fee) throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException {
		if(current == null) {
			throw new NoShowSelectedException();
		}else if(!type.equalsIgnoreCase("virtual") && !type.equalsIgnoreCase("real")) {
			throw new InvalidTypeException();
		}else if(hasCharacter(characterName)) {
			throw new ExistingCharacterException();
		}else if(fee<0) {
			throw new InvalidFeeException();
		}
		
	}

	private boolean hasCharacter(String name) {
		return characters.containsKey(name);
	}
	

}
