package br.com.cubotecnologia.entities.death;

import java.util.Date;

/**
 * 
 * @author william.s.soares
 *
 *         Class to model Death object. Uses to processes Player's death
 */
public class Death {

	/**
	 * Date and time of death
	 */
	private transient Date dtDeathDateTime;

	/**
	 * Constructor
	 * 
	 * @param dtDeathDateTime
	 *            Date and Time of death
	 */
	public Death(final Date dtDeathDateTime) {
		super();
		this.dtDeathDateTime = dtDeathDateTime;
	}

	/**
	 * Method to return Date and Time of death
	 * 
	 * @return
	 */
	public Date getDeathDateTime() {
		return dtDeathDateTime;
	}
}
