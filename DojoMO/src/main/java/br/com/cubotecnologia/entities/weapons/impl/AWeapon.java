package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.weapons.IWeapon;
import br.com.cubotecnologia.enuns.WeaponType;

/**
 * 
 * @author william.s.soares
 * 
 *         Abstract class to standard fields in Weapons objects
 */
public abstract class AWeapon implements IWeapon {

	/**
	 * Type of weapon
	 */
	protected WeaponType wptWeaponType;

	/**
	 * Weapon alias
	 */
	protected transient String sAlias;

	/**
	 * Damage of weapon attack
	 */
	protected int iDamage;

	/**
	 * Constructor
	 *
	 * @param sAlias
	 *            Weapon Alias
	 */
	public AWeapon(final String sAlias) {
		super();
		this.sAlias = sAlias;
	}

	/**
	 * Method to return Type of Weapon
	 * 
	 * @return Type of Weapon
	 */
	public abstract WeaponType getWeponType();

	/**
	 * Method to return Weapon alias
	 * 
	 * @return Weapon Alias
	 */
	public abstract String getAlias();

	/**
	 * Method to return Weapon damage attack
	 * 
	 * @return Damage attack
	 */
	public abstract int getDamage();
}
