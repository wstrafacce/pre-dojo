package br.com.cubotecnologia.enuns;

/**
 * 
 * @author william.s.soares
 * 
 *         Enum to define Award Type
 */
public enum AwardType {
	LIFE(1), MONEY(2), POINTS(3);

	/**
	 * Award type id
	 */
	private transient final int iAwardTypeId;

	/**
	 * Constructor
	 * @param iAwardTypeId Award type Id
	 */
	private AwardType(final int iAwardTypeId) {
		this.iAwardTypeId = iAwardTypeId;
	}

	/**
	 * Method to return Award type id
	 * @return Award type id
	 */
	public int getAwardTypeId() {
		return iAwardTypeId;
	}
}
