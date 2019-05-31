/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Relationship class implementation
 */

package ShowPedia;

import exceptions.*;

public class RelationshipFamilyClass extends RelationshipClass {
    
    public RelationshipFamilyClass(Character parent, Character child) throws SingleRelationshipException {
        super(parent, child);
    }
    
    public Character getParent() {
        return this.getCharacter1();
    }
    
    public Character getChild() {
        return this.getCharacter2();
    }
    
}
