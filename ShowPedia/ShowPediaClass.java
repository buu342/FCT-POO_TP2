/**
 * @author Andr� Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.util.List;

import exceptions.*;

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
        	  Entry<String, Company> tmp =itCompanies.next();
               Iterator<String> itCharacters =tmp.getValue().getCharacters().keySet().iterator();
        	   while(itCharacters.hasNext()) {
        		   current = current + ((CharacterVirtualClass) characters.get(itCharacters.next())).totalRevenue();
        	   }
        	   if(current> max) {
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
        return this.current.getSeason(season).size()< episode;
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
			String name= characters.get(i);
			for(int j = i+1;j<characters.size();j++ ) {
				if(characters.get(j).equals(name)) {
					ret = true;
			}
		}
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
			 Quote tmp = new QuoteClass(quote);
			 tmp.addCharacter(character);
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

	    Relationship relationship = new RelationshipFamilyClass(this.current.getCharacter(parent), this.current.getCharacter(child));
	    
	    if (this.current.hasRelationship(relationship))
	        throw new ExistingRelationshipException();
	    
	    this.current.addRelationship(relationship);
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

        Relationship relationship = new RelationshipLoversClass(this.current.getCharacter(lover1), this.current.getCharacter(lover2));
        
        if (this.current.hasRelationship(relationship))
            throw new ExistingRelationshipException();
        
        this.current.addRelationship(relationship);
    }
}
