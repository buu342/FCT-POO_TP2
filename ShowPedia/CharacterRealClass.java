package ShowPedia;

public class CharacterRealClass extends CharacterClass{

	private String actor;

	public CharacterRealClass(String characterName, String actor, int fee) {
		super(characterName);
		setActor(actor);
	}

	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}

	/**
	 * @param actor2 the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}

}
