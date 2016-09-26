package br.com.cubotecnologia.entities.players;

import java.util.Date;

import br.com.cubotecnologia.entities.death.Death;
import br.com.cubotecnologia.entities.killer.Killer;

/**
 * 
 * @author william.s.soares
 *
 *         Interface of Player object
 */
public interface IPlayer {

	/**
	 * Method to get the favorite Player's weapon uses to kill
	 * 
	 * @return String Name of favorite Player weapon
	 */
	String getFavoriteWeapon();

	/**
	 * Method to add one register of Player's killer
	 * 
	 * @param kllKiller
	 *            Killer object
	 */
	void addKiller(final Killer kllKiller);

	/**
	 * Method to add one register of Player's death
	 * 
	 * @param dthDeath
	 *            Death object
	 */
	void addDeath(final Death dthDeath);

	/**
	 * Method to get number of Player's death in one match
	 * 
	 * @return Number of Player's death
	 */
	int getNumberOfDeaths();

	/**
	 * Method to get number of Player's killer in one match
	 * 
	 * @return Number of Player's killer
	 */
	int getNumberOfKillers();

	/**
	 * Method to get Player's streak
	 * 
	 * @return Player's streak
	 */
	int getStreak();
	
	/**
	 * Method to get number of Player's award
	 * @return Number of Player's award
	 */
	int getNumberOfAward();

	/**
	 * Method to processes sequence of Player's killer without death
	 *
	 * @param isStreak Flag to signalizes Player's streak
	 */
	void processessStreak(final boolean isStreak);

	/**
	 * Method to increase Player's Award by time without death
	 * @param dtLastDeath
	 */
	void processessAward(final Date dtLastDeath);
	
	/**
	 * Method to increase Player's Award by ended match without death
	 * @param dtLastDeath
	 */
	void processessAward();
}
