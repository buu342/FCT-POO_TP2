/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Virtual Character class implementation (extends CharacterClass)
 */

package ShowPedia;

import java.util.Map;
import java.util.List;

public class CharacterVirtualClass extends CharacterClass {

    private Company company;
    private int costPerSeason;
    
    

    public CharacterVirtualClass(Show current, String characterName, Company company, int costPerSeason) {
        super(current, characterName);
        this.company = company;
        this.costPerSeason = costPerSeason;
    }

    /**
     * Retrieves the name of the company that produces this character's VFX.
     * @return A <code>String</code> with the name of the company that produces this character's VFX.
     */
    public Company getCompany() {
        return this.company;
    }

    public int totalRevenue() {
        int revenue = 0;
        Map<Integer, List<Event>> events = this.getShow().getEventsPerSeason();
        int numseasons = events.size();
        for (int i=1; i<=numseasons; i++) {
            List<Event> seasoneventlist = events.get(i);
            
            // Check if the character said something this season
            if (this.getQuotes().size() > 0)
            {
                for (int j=0; j<this.getQuotes().size(); j++)
                    if (this.getQuotes().get(j).getSeason() == i) {
                        revenue += this.costPerSeason;
                        break;
                    }
            }
            
            // Check if the character is in an event this season
            if (seasoneventlist.size() == 0)
                continue;
            for (int j=0; j<seasoneventlist.size(); j++) {
                if (seasoneventlist.get(j).getCharacters().containsKey(this.getCharacterName())) {
                    revenue += this.costPerSeason;
                    break;
                }
            }
            
        }
            
    	return revenue;
    }
    
}
