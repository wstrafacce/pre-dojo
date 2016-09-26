package br.com.cubotecnologia.entities.awards.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.AwardType;

/**
 * 
 * @author william.s.soares
 * 
 *         Class to model AwardPoints object. Use to processes Points as Award
 *
 */
public class AwardPoints extends AAward {

	/**
	 * Instance of AwardPoints
	 */
	private static AwardPoints aptAwardPoints = new AwardPoints();

	/**
	 * Constructor
	 */
	private AwardPoints() {
		super();
		awtAwardType = AwardType.POINTS;
		dBaseValue = 1000.0;
	}

	/**
	 * Method to get only one instance of AwardPoints object in software life
	 * cycle
	 * 
	 * @return
	 */
	public static AwardPoints getAwardPointsInstance() {
		return aptAwardPoints;
	}

	/**
	 * @see br.com.cubotecnologia.entities.awards.impl.AAward.getAwardType()
	 */
	@Override
	public AwardType getAwardType() {
		return awtAwardType;
	}

	/**
	 * Method TODO anywhere when a Player received Points as Award
	 */
	public void processesAward(final IPlayer player) {
		// TODO Auto-generated method stub

	}

}
