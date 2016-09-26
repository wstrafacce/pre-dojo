package br.com.cubotecnologia.entities.awards;

import br.com.cubotecnologia.entities.players.IPlayer;

/**
 * 
 * @author william.s.soares
 *
 *         Interface to create Award objects
 */
public interface IAward {

	/**
	 * Method to compute some Award to a Player
	 * 
	 * @param player
	 *            Instance of PLayer object
	 */
	void processesAward(final IPlayer player);
}
