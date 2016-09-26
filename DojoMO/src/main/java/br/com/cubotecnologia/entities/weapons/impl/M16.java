package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.WeaponType;

/**
 * 
 * @author william.s.soares
 *
 *         Class to model M16 Weapon object
 */
public class M16 extends AWeapon{

	/**
	 * Knife alias
	 */
	private static final String ALIAS = "M16";
	
	/**
	 * Constructor
	 */
	public M16() {
		super(ALIAS);
		wptWeaponType = WeaponType.FIRE;
		iDamage = 60;
	}

	/**
	 * Method to return Knife object instance
	 * 
	 * @return Knife object
	 */
	@Override
	public WeaponType getWeponType() {
		return wptWeaponType;
	}

	/**
	 * @see br.com.cubotecnologia.entities.weapons.impl.AWeapon.getWeponType()
	 */
	@Override
	public String getAlias() {
		return sAlias;
	}

	/**
	 * @see br.com.cubotecnologia.entities.weapons.impl.AWeapon.getAlias()
	 */
	@Override
	public int getDamage() {
		return iDamage;
	}

	/**
	 * @see br.com.cubotecnologia.entities.weapons.impl.AWeapon.getDamage()
	 */
	@Override
	public void processesDamage(final IPlayer player) {
		// TODO Auto-generated method stub
		
	}
	
}
