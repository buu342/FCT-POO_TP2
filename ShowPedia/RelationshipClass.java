/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Relationship class implementation
 */

package ShowPedia;

import exceptions.*;

public class RelationshipClass implements Relationship {

    private Character character1;
    private Character character2;
    private String type;
    
    public RelationshipClass(Character character1, Character character2, String type) throws SingleRelationshipException {
        if (this.character1 == this.character2)
            throw new SingleRelationshipException();
        
        this.character1 = character1;
        this.character2 = character2;
        this.type = type;
    }
    
    @Override
    public Character getCharacter1() {
        return this.character1;
    }

    @Override
    public Character getCharacter2() {
        return this.character2;
    }
    
    @Override
    public String getType() {
        return this.type;
    }
    
}
