/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Relationship lovers class implementation (extends RelationshipClass)
 */

package ShowPedia;

import exceptions.*;

public class RelationshipLoversClass extends RelationshipClass {
    
    public RelationshipLoversClass(Character lover1, Character lover2) throws SingleRelationshipException {
        super(lover1, lover1);
    }
    
    public Character getLover1() {
        return this.getCharacter1();
    }
    
    public Character getLover2() {
        return this.getCharacter2();
    }
    
}