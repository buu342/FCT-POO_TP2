package ShowPedia;

public class EpisodeClass implements Episode {

	private String name;
	
	public EpisodeClass(String episode) {
		setName(episode);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
