package ShowPedia;

import java.util.HashMap;
import java.util.Map;

public class ActorClass implements Actor {

	private String name;
	Map <String, Character> characters;
	Map <String, Show> shows;
	
	

	public ActorClass(String actor) {
		setName(actor);
		 this.shows = new HashMap<String, Show>();
	        this.characters = new HashMap<String, Character>();
	}

	
	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int getNrShows() {
		return shows.size();
	}


	@Override
	public void addShow(Show current) {
	shows.put(current.getName(), current);
		
	}

	

	
}
