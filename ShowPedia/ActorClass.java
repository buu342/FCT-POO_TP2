/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Actor class implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ActorClass implements Actor {

    private String name;
    private Map<String, Character> characters;
    private Map<String, Show> shows;

    public ActorClass(String name) {
        this.name = name;
        this.shows = new HashMap<String, Show>();
        this.characters = new HashMap<String, Character>();
    }

    @Override
    public void addShow(Show show) {
        this.shows.put(show.getName(), show);
    }

    @Override
    public void addCharacter(Character character) {
        this.characters.put(character.getName(), character);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<String, Show> getShows() {
        return this.shows;
    }

    @Override
    public int getNrShows() {
        return this.shows.size();
    }

    @Override
    public int getNrCharacters() {
        return this.characters.size();
    }

    @Override
    public int getNrRomances() {
        int numromances = 0;

        // Iterate through all this actor's characters and add their romances
        Iterator<Entry<String, Character>> itCharacter = this.characters.entrySet().iterator();
        if (this.characters.size() > 0)
            do {
                numromances += itCharacter.next().getValue().getLovers().size();
            } while (itCharacter.hasNext());
        return numromances;
    }

    @Override
    public int getNrRomanticShows() {
        int numromances = 0;

        // Iterate through all this actor's shows and add their romances
        Iterator<Entry<String, Show>> itShows = this.shows.entrySet().iterator();
        if (this.shows.size() > 0)
            do {
                if (itShows.next().getValue().getLovers().size() != 0)
                    numromances++;
            } while (itShows.hasNext());
        return numromances;
    }

}