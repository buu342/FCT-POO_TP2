/**
 * @author Andr� Enes 51099
 * @author Lourenco Soares 54530
 * Virtual Character class implementation (extends CharacterClass)
 */

package ShowPedia;

public class CharacterVirtualClass extends CharacterClass {

	private String company;
	private int costPerSeason;

	public CharacterVirtualClass(String characterName, String company, int costPerSeason) {
		super(characterName);
		this.company = company;
		this.costPerSeason = costPerSeason;
	}

    /**
     * Retrieves the name of the company that produces this character's VFX.
     * @return A <code>String</code> with the name of the company that produces this character's VFX.
     */
	public String getCompany() {
		return this.company;
	}

    /**
     * Retrieves the cost of rendering this character per season.
     * @return An <code>int</code> with the cost of rendering this character per season.
     */
	public int getCostPerSeason() {
		return this.costPerSeason;
	}

}