package br.com.cubotecnologia.entities.weapons.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.WeaponType;

/**
 * 
 * @author william.s.soares
 *
 *         Class to model AK47 Weapon object
 */
public class AK47 extends AWeapon{
	
	/**
	 * AK47 alias
	 */
	private static final String ALIAS = "AK47";

	/**
	 * Constructor
	 */
	public AK47() {
		super(ALIAS);
		wptWeaponType = WeaponType.FIRE;
		iDamage = 35;
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
		return ALIAS;
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
