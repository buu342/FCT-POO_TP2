/**
 * @author André Enes 51099
 * @author Lourenco Soares 54530
 * Episode class implementation
 */

package ShowPedia;

public class EpisodeClass implements Episode {

	private String name;
	
	public EpisodeClass(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
