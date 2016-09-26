package br.com.cubotecnologia.entities.killer;

import java.util.Date;

import br.com.cubotecnologia.entities.weapons.impl.AWeapon;

/**
 * 
 * @author william.s.soares
 *
 *         Class to model Killer object. Uses to processes Player's Killer
 */
public class Killer {

	/**
	 * Date and time of death
	 */
	private transient Date dtKillerDateTime;

	/**
	 * Weapon uses to kill
	 */
	private transient AWeapon wpnWeapon;

	/**
	 * Constructor
	 * 
	 * @param dtKillerDateTime
	 *            Date and Time of killer
	 * @param wpnWeapon
	 *            Weapon uses to kill
	 */
	public Killer(final Date dtKillerDateTime, final AWeapon wpnWeapon) {
		super();
		this.dtKillerDateTime = dtKillerDateTime;
		this.wpnWeapon = wpnWeapon;
	}

	/**
	 * Method to return Date and Time of killer
	 * 
	 * @return
	 */
	public Date getKillerDateTime() {
		return dtKillerDateTime;
	}

	/**
	 * Method to return Weapon uses to killer
	 * 
	 * @return
	 */
	public AWeapon getWeapon() {
		return wpnWeapon;
	}
}
