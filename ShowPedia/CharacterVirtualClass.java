/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Virtual Character class implementation (extends CharacterClass)
 */

package ShowPedia;

import java.util.List;
import java.util.Map;

public class CharacterVirtualClass extends CharacterClass {

    private Company company;
    private int costPerSeason;

    public CharacterVirtualClass(Show current, String characterName, Company company, int costPerSeason) {
        super(current, characterName);
        this.company = company;
        this.costPerSeason = costPerSeason;
    }

    /**
     * Retrieves the company that produces this character's VFX.
     * 
     * @return A <code>Company</code> object pointer of the company that produces
     *         this character's VFX.
     */
    public Company getCompany() {
        return this.company;
    }

    /**
     * Retrieves the total revenue this character has made for the company.
     * 
     * @return An <code>int</code> with the total revenue this character has made
     *         for the company.
     */
    public int totalRevenue() {
        int revenue = 0;
        Map<Integer, List<Event>> events = this.getShow().getEventsPerSeason();
        int numseasons = events.size();
        for (int i = 1; i <= numseasons; i++) {
            Boolean addedthisseason = false;
            List<Event> seasoneventlist = events.get(i);

            // Check if the character said something this season
            if (this.getQuotes().size() > 0) {
                for (int j = 0; j < this.getQuotes().size() && !addedthisseason; j++)
                    if (this.getQuotes().get(j).getSeason() == i) {
                        revenue += this.costPerSeason;
                        addedthisseason = true;
                    }
            }

            // Check if the character is in an event this season
            if (seasoneventlist.size() == 0)
                continue;
            for (int j = 0; j < seasoneventlist.size() && !addedthisseason; j++) {
                if (seasoneventlist.get(j).getCharacters().containsKey(this.getName())) {
                    revenue += this.costPerSeason;
                    addedthisseason = true;
                }
            }

        }

        return revenue;
    }

}
