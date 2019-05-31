/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Real Character class implementation (extends CharacterClass)
 */

package ShowPedia;

public class CharacterRealClass extends CharacterClass{

    private Actor actor;
    private int fee;

    public CharacterRealClass(String characterName, Actor actor, int fee) {
        super(characterName);
        this.actor = actor;
        this.fee = fee;
    }

    /**
     * Retrieves the name of this actor who portrays this character.
     * @return A <code>String</code> with the name of actor who portrays this character.
     */
    public Actor getActor() {
        return this.actor;
    }
    
    
    /**
     * Retrieves the cost of paying this actor per episode.
     * @return An <code>int</code> with the cost of paying this actor per episode.
     */
    public int getFee() {
        return this.fee;
    }


}
