package ShowPedia;

import exceptions.ExistingShowException;
import exceptions.NoSeasonException;
import exceptions.NoShowSelectedException;
import exceptions.NonExistingShowException;

public interface ShowPedia {

	Show getCurrent() throws NoShowSelectedException;

	void addShow(String show) throws ExistingShowException;

	void switchToShow(String show) throws NonExistingShowException;

	void addSeason() throws NoShowSelectedException;

	void addEpisode(int season, String episode) throws NoShowSelectedException, NoSeasonException;

}
