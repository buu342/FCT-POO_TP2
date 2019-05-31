/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Virtual Character class implementation (extends CharacterClass)
 */

package ShowPedia;

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

    /**
     * Retrieves the cost of rendering this character per season.
     * @return An <code>int</code> with the cost of rendering this character per season.
     */
    public int getCostPerSeason() {
        return this.costPerSeason;
    }

    public int totalRevenue() {	
    	return this.getShow().getNrSeasons()*this.getCostPerSeason();
    }
    
}
