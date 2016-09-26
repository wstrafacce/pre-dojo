package br.com.cubotecnologia.entities.weapons;

import br.com.cubotecnologia.entities.players.IPlayer;

/**
 * 
 * @author william.s.soares
 *
 *         Interface to create Weapons objects
 */
public interface IWeapon {

	/**
	 * Method to compute damage to Player
	 * 
	 * @param player
	 *            Player object
	 */
	void processesDamage(final IPlayer player);
}
