/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * ShowPedia System implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Comparators.*;
import Exceptions.*;

public class ShowPediaClass implements ShowPedia {

    private Map<String, Actor> actors;
    private Map<String, Character> characters;
    private Map<String, Company> companies;
    private Map<String, Show> shows;
    private Show current;

    public ShowPediaClass() {
        this.actors = new HashMap<String, Actor>();
        this.characters = new HashMap<String, Character>();
        this.companies = new HashMap<String, Company>();
        this.shows = new HashMap<String, Show>();
        this.current = null;
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
    public void addCharacter(String type, String characterName, String name, int fee)
            throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException {
        if (this.current == null)
            throw new NoShowSelectedException();

        if (!type.equalsIgnoreCase("virtual") && !type.equalsIgnoreCase("real"))
            throw new InvalidTypeException();

        if (hasCharacter(characterName))
            throw new ExistingCharacterException();

        if (fee < 0)
            throw new InvalidFeeException();

        Character tmp;
        if (type.equalsIgnoreCase("real")) {
            if (!this.actors.containsKey(name)) {
                Actor tmp2 = new ActorClass(name);
                tmp = new CharacterRealClass(this.current, characterName, tmp2, fee);
                this.actors.put(name, tmp2);
            } else {
                tmp = new CharacterRealClass(this.current, characterName, this.actors.get(name), fee);
            }
            this.actors.get(name).addShow(this.current);
            this.actors.get(name).addCharacter(tmp);
        } else {
            if (!this.companies.containsKey(name)) {
                Company tmp2 = new CompanyClass(name);
                tmp = new CharacterVirtualClass(this.current, characterName, tmp2, fee);
                this.companies.put(name, tmp2);
            } else {
                tmp = new CharacterVirtualClass(this.current, characterName, this.companies.get(name), fee);
            }
            this.companies.get(name).addCharacter(tmp);
        }
        this.current.addCharacter(tmp);
        this.characters.put(characterName, tmp);
    }

    public void addRelationship(String parent, String child) throws NoShowSelectedException,
            SingleRelationshipException, NoCharacterException, NoChildException, ExistingRelationshipException {

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
    public void addLovers(String lover1, String lover2) throws NoShowSelectedException, SingleRelationshipException,
            NoCharacterException, NoChildException, ExistingRelationshipException {

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
    public void addQuote(int season, int episode, String name, String quote)
            throws NoShowSelectedException, NoSeasonException, NoEpisodeException, NoCharacterException {
        if (this.current == null)
            throw new NoShowSelectedException();

        if (!hasSeason(season))
            throw new NoSeasonException();

        if (!hasEpisode(season, episode))
            throw new NoEpisodeException();

        if (!hasCharacter(name))
            throw new NoCharacterException();

        Character character = characters.get(name);
        if (this.current.hasQuote(quote)) {
            this.current.getQuote(quote).addCharacter(character);
        } else {
            Quote tmp = new QuoteClass(quote, season, episode);
            tmp.addCharacter(character);
            character.addQuote(tmp);
            this.current.addQuote(tmp);
        }

    }

    @Override
    public void addEvent(String description, int season, int episode, List<String> characters)
            throws NoShowSelectedException, NoSeasonException, NoEpisodeException, NoCharacterException,
            DuplicateCharacterException {
        if (this.current == null)
            throw new NoShowSelectedException();

        if (!hasSeason(season))
            throw new NoSeasonException();

        if (!hasEpisode(season, episode))
            throw new NoEpisodeException();

        if (!validCharacters(characters))
            throw new NoCharacterException();

        if (hasDuplicateCharacter(characters))
            throw new DuplicateCharacterException();

        Map<String, Character> tmpCharacters = new HashMap<String, Character>();
        Iterator<String> it = characters.iterator();
        while (it.hasNext()) {
            String name = it.next();
            Character character = this.characters.get(name);
            tmpCharacters.put(name, character);
        }
        Event tmp = new EventClass(description, tmpCharacters);
        Iterator<Character> itCharacter = tmpCharacters.values().iterator();
        while (itCharacter.hasNext()) {
            itCharacter.next().addEvent(tmp);
        }
        this.current.addEvent(season, episode, tmp);
    }

    @Override
    public Show getCurrent() throws NoShowSelectedException {
        if (this.current == null)
            throw new NoShowSelectedException();

        return this.current;
    }

    @Override
    public Character getCharacter(String characterName) {
        return this.characters.get(characterName);
    }

    @Override
    public Actor getActor(String name) {
        return this.actors.get(name);
    }

    @Override
    public Company getCompany(String name) {
        return this.companies.get(name);
    }

    @Override
    public void switchToShow(String show) throws NonExistingShowException {
        if (!hasShow(show))
            throw new NonExistingShowException();

        this.current = this.shows.get(show);
    }

    @Override
    public List<Actor> mostRomantic(String name) throws NoCharacterException, NoLoveException {
        int numromances = 0;

        // Check the actor exists
        if (!this.actors.containsKey(name))
            throw new NoCharacterException();

        Actor myself = this.actors.get(name);

        // Check if there are romances registered
        Iterator<Entry<String, Character>> itCharacter = this.characters.entrySet().iterator();
        if (this.characters.size() > 0)
            numromances += itCharacter.next().getValue().getLovers().size();
        while (itCharacter.hasNext()) {
            numromances += itCharacter.next().getValue().getLovers().size();
        }
        if (numromances == 0)
            throw new NoLoveException();

        // Populate a list
        Iterator<Entry<String, Actor>> itActor = this.actors.entrySet().iterator();
        LoversComparatorClass comparator = new LoversComparatorClass();
        List<Actor> moresexy = new LinkedList<>();
        if (this.actors.size() > 0)
            do {
                Actor actor = itActor.next().getValue();

                // Skip the own actor
                if (actor.getName().equals(name))
                    continue;

                // Check who is better
                if (comparator.compare(actor, myself) == -1)
                    moresexy.add(actor);

            } while (itActor.hasNext());
        return moresexy;
    }

    @Override
    public void alsoAppearsOn(String character)
            throws NoShowSelectedException, NoCharacterException, VirtualActorException {
        if (this.current == null)
            throw new NoShowSelectedException();

        if (!hasCharacter(character))
            throw new NoCharacterException();

        if (this.characters.get(character) instanceof CharacterVirtualClass) {
            throw new VirtualActorException();
        }

    }

    @Override
    public void famousQuote(String quote) throws UnexistingQuoteException {
        if (!this.current.hasQuote(quote)) {
            throw new UnexistingQuoteException();
        }
    }

    @Override
    public Company kingOfCGI() throws NoVirtualCharactersException {
        if (this.companies.size() == 0) {
            throw new NoVirtualCharactersException();
        }

        Company company = null;
        int max = 0;
        Iterator<Entry<String, Company>> itCompanies = this.companies.entrySet().iterator();
        while (itCompanies.hasNext()) {
            int current = 0;
            Entry<String, Company> tmp = itCompanies.next();
            Iterator<String> itCharacters = tmp.getValue().getCharacters().keySet().iterator();
            while (itCharacters.hasNext()) {
                current += ((CharacterVirtualClass) this.characters.get(itCharacters.next())).totalRevenue();
            }

            if (company == null) {
                max = current;
                company = tmp.getValue();
                company.setRevenue(current);
                continue;
            }

            if (current < max) {
                continue;
            } else if (current == max && company.getCharacters().size() < tmp.getValue().getCharacters().size()) {
                continue;
            } else if (company.getCharacters().size() == tmp.getValue().getCharacters().size()
                    && tmp.getValue().getName().compareTo(company.getName()) > 0) {
                continue;
            } else {
                max = current;
                company = tmp.getValue();
                company.setRevenue(current);
            }
        }
        return company;
    }

    @Override
    public List<String> getRelation(String character1, String character2) throws NoShowSelectedException,
            NoCharacterException, NoChildException, SingleRelationshipException, NoRelationshipException {
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

        List<Character> relations = recursiveCheckRelation(this.characters.get(character1),
                this.characters.get(character2));
        if (relations == null || relations.size() < 2) {
            relations = recursiveCheckRelation(this.characters.get(character2), this.characters.get(character1));
            if (relations == null || relations.size() < 2)
                throw new NoRelationshipException();
        }

        for (int i = 0; i < relations.size(); i++) {
            result.add(relations.get(i).getName());
        }

        return result;
    }

    /**
     * Checks if the supplied list has duplicate characters.
     * 
     * @param characters A <code>List&lt;String&gt;</code> of characters to search
     *                   for duplicates of
     * @return <code>true</code> if the list has duplicate characters or
     *         <code>false</code> if it does not.
     */
    private boolean hasDuplicateCharacter(List<String> characters) {
        boolean ret = false;
        int i = 0;
        while (i < characters.size() && ret == false) {
            String name = characters.get(i);
            for (int j = i + 1; j < characters.size(); j++) {
                if (characters.get(j).equals(name)) {
                    ret = true;
                    break;
                }
            }
            i++;
        }
        return ret;
    }

    /**
     * Checks if the supplied list has valid characters.
     * 
     * @param characters A <code>List&lt;String&gt;</code> of characters to search
     *                   for duplicates of
     * @return <code>true</code> if the list has valid characters or
     *         <code>false</code> if it does not.
     */
    private boolean validCharacters(List<String> characters) {
        boolean ret = false;
        Iterator<String> it = characters.iterator();
        while (it.hasNext() && ret == false) {
            String name = it.next();
            if (!this.characters.containsKey(name)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Checks if the show <code>show</code> has been registered
     * 
     * @param show A <code>String</code> with the name of the show.
     * @return <code>true</code> if the show has been registered or
     *         <code>false</code> if it has not.
     */
    private boolean hasShow(String show) {
        return this.shows.containsKey(show);
    }

    /**
     * Checks if the season <code>season</code> has been registered in the current
     * show
     * 
     * @param season An <code>int</code> with the number of the season.
     * @return <code>true</code> if the season has been registered in the current
     *         show or <code>false</code> if it has not.
     */
    private boolean hasSeason(int season) {
        return (this.current.getNrSeasons() >= season && season > 0);
    }

    /**
     * Checks if the episode <code>episode</code> has been registered in the current
     * show
     * 
     * @param episode An <code>int</code> with the number of the episode.
     * @return <code>true</code> if the episode has been registered in the current
     *         show or <code>false</code> if it has not.
     */
    private boolean hasEpisode(int season, int episode) {
        return this.current.getSeason(season).size() >= episode;
    }

    /**
     * Checks if the character with name <code>name</code> has been registered
     * 
     * @param name A <code>String</code> with the name of the character.
     * @return <code>true</code> if the character has been registered or
     *         <code>false</code> if it has not.
     */
    private boolean hasCharacter(String name) {
        return current.hasCharacter(name);
    }

    /**
     * A recursive function that returns a list of the blood line between characters
     * <code>character1</code> and <code>character2</code>.
     * 
     * @param character1 A <code>Character<code> object pointer of the father
     * @param character2    A <code>Character<code> object pointer of the child
     * @return A <code>List&lt;Character&gt;</code> of character relations, or null
     *         if there are none.
     */
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

        for (int i = 0; i < children.size(); i++) {
            List<Character> result = recursiveCheckRelation(children.get(i), character2);
            if (result != null) {
                relations.add(character1);
                relations.addAll(result);
                return relations;
            }
        }
        return null;
    }
}
