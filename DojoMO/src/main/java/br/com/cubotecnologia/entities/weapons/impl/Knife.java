package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.WeaponType;

/**
 * 
 * @author william.s.soares
 *
 *         Class to model Knife Weapon object
 */
public class Knife extends AWeapon {

	/**
	 * Knife object instance
	 */
	private static Knife knfKinfeInstance = new Knife();

	/**
	 * Knife alias
	 */
	private static final String ALIAS = "KNIFE";

	/**
	 * Constructor
	 */
	private Knife() {
		super(ALIAS);
		wptWeaponType = WeaponType.WHITE;
		iDamage = 10;
	}

	/**
	 * Method to return Knife object instance
	 * 
	 * @return Knife object
	 */
	public static Knife getKnifeInstance() {
		return knfKinfeInstance;
	}

	/**
	 * @see br.com.cubotecnologia.entities.weapons.impl.AWeapon.getWeponType()
	 */
	@Override
	public WeaponType getWeponType() {
		return wptWeaponType;
	}

	/**
	 * @see br.com.cubotecnologia.entities.weapons.impl.AWeapon.getAlias()
	 */
	@Override
	public String getAlias() {
		return sAlias;
	}

	/**
	 * @see br.com.cubotecnologia.entities.weapons.impl.AWeapon.getDamage()
	 */
	@Override
	public int getDamage() {
		return iDamage;
	}

	/**
	 * Method to processes Weapon damage to Player
	 * 
	 * @param Player
	 *            Player object
	 */
	@Override
	public void processesDamage(final IPlayer player) {
		// TODO Auto-generated method stub

	}

}
