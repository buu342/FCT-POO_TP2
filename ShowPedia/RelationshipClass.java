/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Relationship class implementation
 */

package ShowPedia;

import exceptions.*;

public abstract class RelationshipClass implements Relationship {

    private Character character1;
    private Character character2;
    
    public RelationshipClass(Character character1, Character character2) throws SingleRelationshipException {
        this.character1 = character1;
        this.character2 = character2;
    }
    
    @Override
    public Character getCharacter1() {
        return this.character1;
    }

    @Override
    public Character getCharacter2() {
        return this.character2;
    }
    
}
