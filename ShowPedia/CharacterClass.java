/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Character class implementation
 */

package ShowPedia;

public abstract class CharacterClass implements Character {

	private String characterName;

	public CharacterClass(String characterName) {
		this.characterName = characterName;
	}

	@Override
	public String getCharacterName() {
		return this.characterName;
	}

}
