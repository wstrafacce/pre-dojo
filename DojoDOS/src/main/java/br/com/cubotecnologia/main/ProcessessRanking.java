package br.com.cubotecnologia.main;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import br.com.cubotecnologia.bo.ranking.IRankingBO;
import br.com.cubotecnologia.bo.ranking.impl.RankingBO;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.vo.RankingVO;
import br.com.cubotecnologia.vo.RankingLineVO;

public class ProcessessRanking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			args = new String[] { "dojo.log", "dojo2.log" };
		}
		
		processesLog(args[0]);
		processesLog(args[1]);

	}

	private static void processesLog(String sPath) {
		IRankingBO irkbRankingBO = new RankingBO();

		try {
			Map<String, RankingVO> mapRankings = irkbRankingBO.processesRanking(new File(sPath));

			List<Map.Entry<String, RankingVO>> lRankings = new LinkedList<Map.Entry<String, RankingVO>>(
					mapRankings.entrySet());

			for (Map.Entry<String, RankingVO> entry : lRankings) {
				RankingVO rkvRankingVO = entry.getValue();

				System.out.println("Match: " + rkvRankingVO.getMatchId());
				System.out.println("Started: " + rkvRankingVO.getStartedDate());
				System.out.println("Ended: " + rkvRankingVO.getEndedDate());

				for (RankingLineVO rlvRankinLineVO : rkvRankingVO.getRankingLines()) {
					System.out.println("Nickname: " + rlvRankinLineVO.getPlayerNickName());
					System.out.println("Murders: " + rlvRankinLineVO.getPlayerMurders());
					System.out.println("Deaths: " + rlvRankinLineVO.getPlayerDeaths());
					System.out.println("Favorite Weapon: " + rlvRankinLineVO.getFavoriteWeapon());
				}
				System.out.println("==============================================================");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
