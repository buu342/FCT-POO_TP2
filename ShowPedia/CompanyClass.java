/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Company class implementation
 */

package ShowPedia;

import java.util.HashMap;
import java.util.Map;

public class CompanyClass implements Company {

    private String name;
    private Map<String, Character> characters;
    private int revenue;

    public CompanyClass(String name) {
        this.name = name;
        characters = new HashMap<String, Character>();
        setRevenue(0);
    }

    @Override
    public void addCharacter(Character character) {
        characters.put(character.getName(), character);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, Character> getCharacters() {
        return characters;
    }

    @Override
    public int getRevenue() {
        return revenue;
    }

    @Override
    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

}
