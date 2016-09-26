package br.com.cubotecnologia.entities.players.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import br.com.cubotecnologia.entities.death.Death;
import br.com.cubotecnologia.entities.killer.Killer;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.entities.weapons.impl.AWeapon;
import br.com.cubotecnologia.utils.DateUtil;
import br.com.cubotecnologia.utils.MapUtils;

/**
 * 
 * @author william.s.soares
 * 
 *         Class to model Player object
 */
public class Player implements IPlayer {

	/**
	 * Player's name
	 */
	private transient final String sName;

	/**
	 * Player's alias
	 */
	private transient final String sNickName;

	/**
	 * Value of quantity of player's money
	 */
	private transient double dMoney;

	/**
	 * Value of quantity player's points
	 */
	private transient int iPoints;

	/**
	 * Value of max Player's streak
	 */
	private transient int iStreak;

	/**
	 * Value of quantity of Player's award
	 */
	private transient int iNumberOfAward;

	/**
	 * Value of current Player's Streak
	 */
	private transient int iCurrentStreak;

	/**
	 * Date of last player's death
	 */
	private transient Date dtLastDeath;

	/**
	 * List of weapons uses to kill
	 */
	private transient final List<AWeapon> lWeapons;

	/**
	 * List of Player's killer
	 */
	private transient final List<Killer> lKiller;

	/**
	 * List of Player's death
	 */
	private transient final List<Death> lDeaths;

	/**
	 * Constructor
	 * 
	 * @param sName
	 *            Player's name
	 * @param sNickName
	 *            Player's alias
	 */
	public Player(final String sName, final String sNickName) {
		super();
		this.sName = sName;
		this.sNickName = sNickName;
		this.dMoney = 5000.0;
		this.lWeapons = new ArrayList<AWeapon>();
		this.lKiller = new ArrayList<Killer>();
		this.lDeaths = new ArrayList<Death>();
	}

	/**
	 * Constructor
	 * 
	 * @param sNickName
	 *            Player's alias
	 */
	public Player(final String sNickName) {
		super();
		this.sName = sNickName;
		this.sNickName = sNickName;
		this.dMoney = 5000.0;
		this.lWeapons = new ArrayList<AWeapon>();
		this.lKiller = new ArrayList<Killer>();
		this.lDeaths = new ArrayList<Death>();
	}

	/**
	 * Method to return Player's name
	 * 
	 * @return Player's name
	 */
	public String getName() {
		return sName;
	}

	/**
	 * Method to return Player's alias
	 * 
	 * @return Player's alias
	 */
	public String getNickName() {
		return sNickName;
	}

	/**
	 * Method to return quantity of Player's money
	 * 
	 * @return Player's money
	 */
	public double getMoney() {
		return dMoney;
	}

	/**
	 * Method to set value of quantity of Player's money
	 * 
	 * @param dMoney
	 *            new value of Player's money
	 */
	public void setMoney(final double dMoney) {
		this.dMoney = dMoney;
	}

	/**
	 * Method to return quantity of Player's points
	 * 
	 * @return Player's points
	 */
	public int getPoints() {
		return iPoints;
	}

	/**
	 * Method to set valuer of Player's points
	 * 
	 * @param iPoints
	 *            new value of Player's points
	 */
	public void setPoints(final int iPoints) {
		this.iPoints = iPoints;
	}

	/**
	 * Method to return Player's streak in a match
	 * 
	 * @return Player' streak
	 */
	@Override
	public int getStreak() {
		return iStreak;
	}

	/**
	 * Method to set value of Player' streak
	 * 
	 * @param iStreak
	 *            new value of Player' streak
	 */
	public void setStreak(final int iStreak) {
		this.iStreak = iStreak;
	}

	/**
	 * Method to return number of Player' award in a match
	 * 
	 * @return
	 */
	@Override
	public int getNumberOfAward() {
		return iNumberOfAward;
	}

	/**
	 * Method to set value of number of Player's award
	 * 
	 * @param iNumberOfAward
	 *            Number of Player's award
	 */
	public void setNumberOfAward(final int iNumberOfAward) {
		this.iNumberOfAward = iNumberOfAward;
	}

	/**
	 * Method to return current Player's streak in a match
	 * 
	 * @return current Player' streak
	 */
	public int getCurrentStreak() {
		return iCurrentStreak;
	}

	/**
	 * Method to set value of current Player's streak
	 * 
	 * @param iStreak
	 *            new value of Player' streak
	 */
	public void setCurrentStreak(final int iCurrentStreak) {
		this.iCurrentStreak = iCurrentStreak;
	}

	/**
	 * Method to return date and time of last Player's death
	 * 
	 * @return Date Date and time of last Player's death
	 */
	public Date getLastDeath() {
		return dtLastDeath;
	}

	/**
	 * Method to set date and time of last Player's death
	 * 
	 * @param dtLastDeath
	 *            new value of last Player's death
	 */
	public void setLastDeath(final Date dtLastDeath) {
		this.dtLastDeath = dtLastDeath;
	}

	/**
	 * Method to return a list of Player's killer
	 * 
	 * @return List of Player's killer
	 */
	public List<Killer> getKiller() {
		return lKiller;
	}

	/**
	 * Method to add one register of Player's killer
	 * 
	 * @param Killer
	 *            Register of Player's killer
	 */
	public void addKiller(final Killer mrdKiller) {
		this.lKiller.add(mrdKiller);
	}

	/**
	 * Method to return a list of Player's death
	 * 
	 * @return List of Player's death
	 */
	public List<Death> getDeaths() {
		return lDeaths;
	}

	/**
	 * Method to add one register of Player's death
	 * 
	 * @param Death
	 *            Register of Player's death
	 */
	public void addDeath(final Death dthDeath) {
		this.lDeaths.add(dthDeath);
	}

	/**
	 * Method to return a list of Player's weapons
	 * 
	 * @return List of Player's weapons
	 */
	public List<AWeapon> getWeapons() {
		return lWeapons;
	}

	/**
	 * Method to add one Weapon object to Player
	 * 
	 * @param wpnWeapons
	 *            Weapon object
	 */
	public void addWeapons(final AWeapon wpnWeapons) {
		this.lWeapons.add(wpnWeapons);
	}

	/**
	 * Method to return the favorite weapon uses in Player's killer
	 * 
	 * @return Name of favorite weapon
	 */
	public String getFavoriteWeapon() {
		Map<String, Integer> mapFavoriteWeapon = new LinkedHashMap<String, Integer>();

		for (final Killer mrdKiller : lKiller) {
			final AWeapon wpnWeapon = mrdKiller.getWeapon();
			if (mapFavoriteWeapon.containsKey(wpnWeapon.getAlias())) {
				int iCount = mapFavoriteWeapon.get(wpnWeapon.getAlias());
				mapFavoriteWeapon.replace(wpnWeapon.getAlias(), iCount, ++iCount);
			} else {
				mapFavoriteWeapon.put(wpnWeapon.getAlias(), 1);
			}
		}

		mapFavoriteWeapon = MapUtils.sortByValue(mapFavoriteWeapon);

		String sFavoriteWeapon = StringUtils.EMPTY;

		if (!mapFavoriteWeapon.isEmpty()) {
			final Entry<String, Integer> lastEntry = MapUtils.getEntryByIndex(mapFavoriteWeapon,
					mapFavoriteWeapon.size() - 1);
			sFavoriteWeapon = lastEntry.getKey();
		}

		return sFavoriteWeapon;
	}

	/**
	 * Method to return number of Player's death
	 * 
	 * @return Number of Player's death
	 */
	public int getNumberOfDeaths() {
		return this.lDeaths.size();
	}

	/**
	 * Method to return number of Player's killer
	 * 
	 * @return Number of Player's killer
	 */
	public int getNumberOfKillers() {
		return this.lKiller.size();
	}

	/**
	 * Method to processes sequence of Player's killer without death
	 * 
	 * @param Flag
	 *            to indicate Player' streak
	 */
	@Override
	public void processessStreak(final boolean isStreak) {
		if (isStreak) {
			this.iCurrentStreak++;
		} else if (this.iCurrentStreak > this.iStreak) {
			this.iStreak = this.iCurrentStreak;
			this.iCurrentStreak = 0;
		}
	}

	/**
	 * Method to increase the number of Player's award to ended the match
	 * without deaths
	 */
	@Override
	public void processessAward() {
		if (this.lDeaths.isEmpty()) {
			this.iNumberOfAward++;
		}
	}

	/**
	 * Method to increase the number of Player's award. Player keep yourself
	 * more than 5 minutes without deaths
	 */
	@Override
	public void processessAward(final Date dtLastDeath) {
		if (this.dtLastDeath != null) {
			long iDateDiff = DateUtil.dateDiff(this.dtLastDeath, dtLastDeath, DateUtil.MINUTES);
			if (iDateDiff >= 5) {
				this.iNumberOfAward += (int) (iDateDiff / 5);
			}
		}

		this.dtLastDeath = dtLastDeath;
	}
}
