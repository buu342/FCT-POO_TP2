package ShowPedia;

public abstract class CharacterClass implements Character {

	
	private String characterName;

	public CharacterClass(String characterName) {
		setCharacterName(characterName);
	}

	/**
	 * @return the characterName
	 */
	@Override
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * @param characterName the characterName to set
	 */
	@Override
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
}
