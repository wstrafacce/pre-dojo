package br.com.cubotecnologia.main;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import br.com.cubotecnologia.bo.ranking.IRankingBO;
import br.com.cubotecnologia.bo.ranking.impl.RankingBO;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.utils.DateUtil;
import br.com.cubotecnologia.vo.RankingVO;
import br.com.cubotecnologia.vo.RankingLineVO;

public class ProcessessRanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			args = new String[] { "dojo.log", "dojo2.log" };
			System.out.println("File didn't informed! Will be showing results for standard log.");
		}
		
		processesLog(args[0]);

	}

	private static void processesLog(String sPath) {
		IRankingBO irkbRankingBO = new RankingBO();

		try {
			Map<String, RankingVO> mapRankings = irkbRankingBO.processesRanking(new File(sPath));

			List<Map.Entry<String, RankingVO>> lRankings = new LinkedList<Map.Entry<String, RankingVO>>(
					mapRankings.entrySet());

			for (Map.Entry<String, RankingVO> entry : lRankings) {
				RankingVO rkvRankingVO = entry.getValue();
				System.out.println("============================================================================================");
				System.out.println("||" + fixedLengthString("Match", 14) + "|" + fixedLengthString(rkvRankingVO.getMatchId(), 73) + "||");
				System.out.println("||--------------|-------------------------------------------------------------------------||");
				System.out.println("||" + fixedLengthString("Started", 14) + "|" + fixedLengthString(DateUtil.getDateFromString(rkvRankingVO.getStartedDate()).toString(), 73) + "||");
				System.out.println("||--------------|-------------------------------------------------------------------------||");
				System.out.println("||" + fixedLengthString("Ended", 14) + "|" + fixedLengthString(DateUtil.getDateFromString(rkvRankingVO.getEndedDate()).toString(), 73) + "||");
				System.out.println("||========================================================================================||");
				System.out.println("||" + fixedLengthString("Nickname", 13) + "||" + fixedLengthString("Killers", 13) + "||" + fixedLengthString("Deaths", 13)
										+ "||" + fixedLengthString("Fav. Weapon", 13) + "||" + fixedLengthString("Streak", 13) + "||" + fixedLengthString("Award", 13) + "||");
				System.out.println("||=============||=============||=============||=============||=============||=============||");
				
				int count = 1;
				for (RankingLineVO rlvRankinLineVO : rkvRankingVO.getRankingLines()) {
					if (count > 1) {
						System.out.println("||-------------||-------------||-------------||-------------||-------------||-------------||");
					}
					
					System.out.println("||" + fixedLengthString(rlvRankinLineVO.getPlayerNickName(), 13) + "||" + fixedLengthString(rlvRankinLineVO.getPlayerKillers(), 13) 
											+ "||" + fixedLengthString(rlvRankinLineVO.getPlayerDeaths(), 13) + "||" + fixedLengthString(rlvRankinLineVO.getFavoriteWeapon(), 13) 
											+ "||" + fixedLengthString(rlvRankinLineVO.getStreak(), 13) + "||" + fixedLengthString(rlvRankinLineVO.getAward(), 13) + "||");
					
					count++;				
				}
				
				System.out.println("============================================================================================\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String fixedLengthString(String string, int length) {
	    return String.format("%1$"+length+ "s", string);
	}

}
