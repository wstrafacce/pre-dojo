package br.com.cubotecnologia.entities.awards.impl;

import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.enuns.AwardType;

/**
 * 
 * @author william.s.soares
 * 
 *         Class to model AwardMoney object. Uses to processes Money as Award
 *
 */
public class AwardMoney extends AAward {

	/**
	 * Instance of AwardMoney
	 */
	private static AwardMoney amyAwardMoney = new AwardMoney();

	/**
	 * Constructor
	 */
	private AwardMoney() {
		super();
		awtAwardType = AwardType.MONEY;
		dBaseValue = 100.0;
	}

	/**
	 * Method to get only one instance of AwardMoney object in software life
	 * cycle
	 * 
	 * @return
	 */
	public static AwardMoney getAwardMoneyInstance() {
		return amyAwardMoney;
	}

	/**
	 * @see br.com.cubotecnologia.entities.awards.impl.AAward.getAwardType()
	 */
	@Override
	public AwardType getAwardType() {
		return awtAwardType;
	}

	/**
	 * Method TODO anywhere when a Player received a Money as Award
	 */
	public void processesAward(final IPlayer player) {
		// TODO Auto-generated method stub

	}

}
