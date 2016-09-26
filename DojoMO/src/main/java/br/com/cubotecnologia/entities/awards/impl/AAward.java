package br.com.cubotecnologia.entities.awards.impl;

import br.com.cubotecnologia.entities.awards.IAward;
import br.com.cubotecnologia.enuns.AwardType;

/**
 * 
 * @author william.s.soares
 *
 *         Abstract class to standard fields in Award objects
 */
public abstract class AAward implements IAward {

	/**
	 * Type of Award
	 */
	protected AwardType awtAwardType;

	/**
	 * Base value to increase Player's field
	 */
	protected double dBaseValue;

	/**
	 * 
	 * Method to get type of Award
	 * 
	 * @return br.com.cubotecnologia.AwardType
	 */
	public abstract AwardType getAwardType();
}
