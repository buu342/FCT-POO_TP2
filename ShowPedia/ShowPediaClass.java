/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import Exceptions.*;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ShowPediaClass implements ShowPedia {
    
    private Map <String, Actor> actors;
    private Map <String, Character> characters;
    private Map <String, Company> companies;
    private Map <String, Show> shows;
    private Show current;
    
    public ShowPediaClass() {
        this.actors = new HashMap<String, Actor>();
        this.characters = new HashMap<String, Character>();
        this.companies = new HashMap<String, Company>();
        this.shows = new HashMap<String, Show>();
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
    public void addCharacter(String type, String characterName, String name, int fee) throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException {
        if (this.current == null)
            throw new NoShowSelectedException();
        
        if (!type.equalsIgnoreCase("virtual") && !type.equalsIgnoreCase("real"))
            throw new InvalidTypeException();
        
        if (hasCharacter(characterName))
            throw new ExistingCharacterException();
        
        if(fee<0) 
            throw new InvalidFeeException();
   
        Character tmp;
        if (type.equalsIgnoreCase("real")) {
            if(!this.actors.containsKey(name)) {
                Actor tmp2 = new ActorClass(name);
                tmp =new CharacterRealClass(this.current, characterName, tmp2, fee);
                this.actors.put(name, tmp2);
            }else {
            	 tmp =new CharacterRealClass(this.current, characterName, this.actors.get(name), fee);
            }
            this.actors.get(name).addShow(this.current);
            this.actors.get(name).addCharacter(tmp);
        } else {
            if(!this.companies.containsKey(name)) {
                Company tmp2 = new CompanyClass(name);
                tmp =new CharacterVirtualClass(this.current, characterName, tmp2, fee);
                this.companies.put(name, tmp2);
            }else {
            	 tmp =new CharacterVirtualClass(this. current, characterName, this.companies.get(name), fee);
            } 
           this.companies.get(name).addCharacter(tmp);
        }
        this.current.addCharacter(tmp);
        this.characters.put(characterName, tmp);
    }
    
    @Override
    public Company kingOfCGI() throws NoVirtualCharactersException {
        if(!hasVirtualCharacters()) {
            throw new NoVirtualCharactersException();
        }

        Company company = null;
        int max =0;
        Iterator<Entry<String, Company>> itCompanies = companies.entrySet().iterator();
        while(itCompanies.hasNext()) {
            int current = 0;
            Entry<String, Company> tmp = itCompanies.next();
            Iterator<String> itCharacters = tmp.getValue().getCharacters().keySet().iterator();
            while(itCharacters.hasNext()) {
                current += ((CharacterVirtualClass) characters.get(itCharacters.next())).totalRevenue();
            }
            
            if (company == null) {
                max=current;
                company = tmp.getValue();
                company.setRevenue(current);
                continue;
            }
            
            if (current < max) {
                continue;
            } else if (current == max && company.getCharacters().size() < tmp.getValue().getCharacters().size()) {
                continue;
            } else if (company.getCharacters().size() == tmp.getValue().getCharacters().size() && tmp.getValue().getName().compareTo(company.getName()) > 0) {
                continue;
            } else {
                max=current;
                company = tmp.getValue();
                company.setRevenue(current);   
            }
        }
        return company;
    }

    private boolean hasVirtualCharacters() {
    	/*
    	boolean ret = false;
    	Iterator<Entry<String, Character>> tmp = characters.entrySet().iterator();
        while(tmp.hasNext()) {
            if(tmp.next() instanceof CharacterVirtualClass) {
                ret = true;
            }
        }
    	return ret;
    	*/
    	return companies.size()>0;
	}

	@Override
    public Actor getActor(String name) {
        return actors.get(name);
    }
    
    // Check whether a show has already been registered
    @Override
    public boolean hasShow(String show) {
        return this.shows.containsKey(show);
    }
    
    // Check whether a season exists for a show
    @Override
    public boolean hasSeason(int season) {
        return (this.current.getNrSeasons() >= season && season > 0);
    }

    // Check whether a season exists for a show
    @Override
    public boolean hasEpisode(int season, int episode) {
        return this.current.getSeason(season).size() >= episode;
    }
    
    // Check whether a character has already been registered
    @Override
    public boolean hasCharacter(String name) {
        return current.hasCharacter(name);
    }

    @Override
    public void addEvent(String description, int season, int episode, List<String> characters) throws NoShowSelectedException, NoSeasonException, NoEpisodeException, NoCharacterException, DuplicateCharacterException {
        if (this.current == null)
            throw new NoShowSelectedException();
        
          if (!hasSeason(season))
                throw new NoSeasonException();
          
          if (!hasEpisode(season, episode))
                throw new NoEpisodeException();
        
          if (hasCharacters(characters) != null) 
              throw new NoCharacterException();
             
          if (hasDuplicateCharacter(characters)) 
              throw new DuplicateCharacterException();
          
        Map<String, Character> tmpCharacters = new HashMap<String, Character>();
        Iterator<String> it = characters.iterator();
        while(it.hasNext()) {
            String name= it.next();
            Character character = this.characters.get(name);
            tmpCharacters.put(name, character);
        }
        Event tmp = new EventClass(description, tmpCharacters);
        Iterator<Character> itCharacter = tmpCharacters.values().iterator();
        while(itCharacter.hasNext()) {
            itCharacter.next().addEvent(tmp);
        }
        current.addEvent(season, episode, tmp);
    }

	private boolean hasDuplicateCharacter(List<String> characters) {
		boolean ret = false;
		int i = 0;
		while(i<characters.size() && ret == false) {
			String name = characters.get(i);
			for(int j = i+1;j<characters.size();j++ ) {
				if(characters.get(j).equals(name)) {
					ret = true;
					break;
    			}
    		}
			i++;
		}
		return ret;
	}

	@Override
	public String hasCharacters(List<String> characters) {
		String ret = null;
		Iterator<String> it = characters.iterator();
		while(it.hasNext() && ret == null) {
			String name= it.next();
			if(!this.characters.containsKey(name)) {
				ret = name;
			}
		}
		return ret;
	}

	@Override
	public Company getCompany(String name) {
        return companies.get(name);

	}

	@Override
	public void addQuote(int season, int episode, String name, String quote) throws NoShowSelectedException, NoSeasonException, NoEpisodeException, NoCharacterException {
		if (this.current == null)
            throw new NoShowSelectedException();
        
		  if (!hasSeason(season))
	            throw new NoSeasonException();
		  
		  if (!hasEpisode(season, episode))
	            throw new NoEpisodeException();
		  
		  if (!hasCharacter(name)) 
			  throw new NoCharacterException();
		  
		  Character character =characters.get(name);
		  if(current.hasQuote(quote)) {
			  current.getQuote(quote).addCharacter(character); 
		  }else {
			 Quote tmp = new QuoteClass(quote, season, episode);
			 tmp.addCharacter(character);
			 character.addQuote(tmp);
			 current.addQuote(tmp);
		  }
		  
	}

	@Override
	public void famousQuote(String quote) throws UnexistingQuoteException {
		if(!current.hasQuote(quote)) {
			throw new UnexistingQuoteException();
		}
	}

	@Override
	public void alsoAppearsOn(String character) throws NoShowSelectedException, NoCharacterException, VirtualActorException {
		if (this.current == null)
            throw new NoShowSelectedException();
		
		if (!hasCharacter(character)) 
			  throw new NoCharacterException();
		
		if(characters.get(character) instanceof CharacterVirtualClass) {
            throw new VirtualActorException();
        }
		
	}

	@Override
	public Character getCharacter(String characterName) {
		return characters.get(characterName);
	}

	public void addRelationship(String parent, String child) throws NoShowSelectedException, SingleRelationshipException, NoCharacterException, NoChildException, ExistingRelationshipException {
	    
	    if (this.current == null)
            throw new NoShowSelectedException();
	    
	    if (parent.equals(child)) {
	        System.out.print("");
	        throw new SingleRelationshipException();
	    }
	    
	    if (!hasCharacter(parent)) 
            throw new NoCharacterException();
	    
	    if (!hasCharacter(child)) 
            throw new NoChildException();

	    this.current.addFamily(this.characters.get(parent), this.characters.get(child));
	}
	
	@Override
    public void addLovers(String lover1, String lover2) throws NoShowSelectedException, SingleRelationshipException, NoCharacterException, NoChildException, ExistingRelationshipException {
        
        if (this.current == null)
            throw new NoShowSelectedException();
        
        if (lover1.equals(lover2)) {
            System.out.print("");
            throw new SingleRelationshipException();
        }
        
        if (!hasCharacter(lover1)) 
            throw new NoCharacterException();
        
        if (!hasCharacter(lover2)) 
            throw new NoChildException();

        this.current.addLovers(this.characters.get(lover1), this.characters.get(lover2));
    }

	@Override
	public boolean isListEmpty(List<Character> list) {
		return list.size() == 0;
	}
	
    @Override
	public List<Actor> mostRomantic(String name) throws NoCharacterException, NoLoveException {
	    int numromances = 0;
	    
	    // Check the actor exists
	    if (!this.actors.containsKey(name)) 
            throw new NoCharacterException();
	    
	    Actor myself = this.actors.get(name);
	    int myromances = myself.getNrRomances();
	    
	    // Check if there are romances registered
	    Iterator<Entry<String, Character>> itCharacter = this.characters.entrySet().iterator();
	    if (this.characters.size() > 0)
	        numromances += itCharacter.next().getValue().getNumLovers();
	    while (itCharacter.hasNext()) {
	        numromances += itCharacter.next().getValue().getNumLovers();
	    }
	    if (numromances == 0)
	        throw new NoLoveException();
	    
	    // Populate a list
	    Iterator<Entry<String, Actor>> itActor = this.actors.entrySet().iterator();
	    List<Actor> moresexy = new LinkedList<>();
	    if (this.actors.size() > 0)
    	    do {
    	        Actor actor = itActor.next().getValue();
    	        
    	        // Skip the own actor
    	        if (actor.getName().equals(name))
    	            continue;
    	        
    	        // Check who is better
    	        if (actor.getNrRomances() < myromances) {
    	            //System.out.println(actor.getName()+" failed getnrRomances");
    	            continue;
    	        }
    	        else if (actor.getNrRomances() == myromances && actor.getShows().size() > myself.getShows().size()) {
    	            //System.out.println(actor.getName()+" failed showsize");
    	            continue;
    	        }
    	        else if (actor.getShows().size() == myself.getShows().size() && actor.getNrRomanticShows() < myself.getNrRomanticShows()) {
    	            //System.out.println(actor.getName()+" failed showromancesize");
    	            continue;
    	        }
    	        else if (actor.getNrRomanticShows() == myself.getNrRomanticShows() && actor.getName().compareTo(myself.getName()) > 0) {
    	            //System.out.println(actor.getName()+" failed name");
                    continue;
    	        }
    	        moresexy.add(actor);
    	    } while (itActor.hasNext());
	    return moresexy;
	}
    
    private List<Character> recursiveCheckRelation(Character character1, Character character2) {
        List<Character> relations = new LinkedList<>();
        List<Character> children = character1.getChildren();
        if (children.size() == 0) {
            if (character1.equals(character2)) {
                relations.add(character2);
                return relations;
            } else
                return null;
        }
        
        for (int i=0; i<children.size(); i++)
        {
            List<Character> result = recursiveCheckRelation(children.get(i), character2);
            if (result != null) {
                relations.add(character1);
                relations.addAll(result);
            }
        }
        return relations;
    }
    
    @Override 
    public List<String> getRelation(String character1, String character2) throws NoShowSelectedException, NoCharacterException, NoChildException, SingleRelationshipException, NoRelationshipException {
        List<String> result = new LinkedList<>();
        
        if (this.current == null)
            throw new NoShowSelectedException();
        
        if (!hasCharacter(character1)) 
            throw new NoCharacterException();
        
        if (!hasCharacter(character2)) 
            throw new NoChildException();
        
        if (character1.equals(character2)) {
            System.out.print("");
            throw new SingleRelationshipException();
        }
        
        List<Character> relations = recursiveCheckRelation(characters.get(character1), characters.get(character2));
        if (relations == null || relations.size() < 2) {
            relations = recursiveCheckRelation(characters.get(character2), characters.get(character1));
            if (relations == null || relations.size() < 2)
                throw new NoRelationshipException();
        }
        
        for (int i=0; i<relations.size(); i++) {
            result.add(relations.get(i).getCharacterName());
        }
        
        return result;
    }
}
