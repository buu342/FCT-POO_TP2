package ShowPedia;

import exceptions.ExistingCharacterException;
import exceptions.ExistingShowException;
import exceptions.InvalidFeeException;
import exceptions.InvalidTypeException;
import exceptions.NoSeasonException;
import exceptions.NoShowSelectedException;
import exceptions.NonExistingShowException;

public interface ShowPedia {

	Show getCurrent() throws NoShowSelectedException;

	void addShow(String show) throws ExistingShowException;

	void switchToShow(String show) throws NonExistingShowException;

	void addSeason() throws NoShowSelectedException;

	void addEpisode(int season, String episode) throws NoShowSelectedException, NoSeasonException;

	void addCharacter(String type, String name, String name2, int fee) throws NoShowSelectedException, InvalidTypeException, ExistingCharacterException, InvalidFeeException;

}
