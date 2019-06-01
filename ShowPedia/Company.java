/**
 * @author Andre Enes 51099
 * @author Lourenco Soares 54530
 * Company object interface
 */

package ShowPedia;

import java.util.Map;

public interface Company {

	void addCharacter(Character tmp);

	String getName();

	void setName(String name);

	Map<String, Character> getCharacters();

	int getRevenue();

	void setRevenue(int revenue);

}
