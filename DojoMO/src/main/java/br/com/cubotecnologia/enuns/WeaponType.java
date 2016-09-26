package br.com.cubotecnologia.enuns;

/**
 * 
 * @author william.s.soares
 * 
 *         Enum to define Weapon Type
 */
public enum WeaponType {
	FIRE(1), WHITE(2), UNKNOW(999);
	
	/**
	 * Weapon type id
	 */
	private transient final int iWeaponTypeId;

	/**
	 * Constructor
	 * @param iWeaponTypeId Weapon type Id
	 */
	private WeaponType(final int iWeaponTypeId) {
		this.iWeaponTypeId = iWeaponTypeId;
	}

	/**
	 * Method to return Weapon type id
	 * @return Weapon type id
	 */
	public int getWeaponTypeId() {
		return iWeaponTypeId;
	}
}
