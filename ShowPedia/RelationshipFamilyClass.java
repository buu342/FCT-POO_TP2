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
    
}
