package ShowPedia;

public class CharacterVirtualClass extends CharacterClass {

	private String company;
	private int costPerSeason;

	public CharacterVirtualClass(String characterName, String company, int costPerSeason) {
		super(characterName);
		setCompany(company);
		setCostPerSeason(costPerSeason);
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return the costPerSeason
	 */
	public int getCostPerSeason() {
		return costPerSeason;
	}

	/**
	 * @param costPerSeason the costPerSeason to set
	 */
	public void setCostPerSeason(int costPerSeason) {
		this.costPerSeason = costPerSeason;
	}

}
