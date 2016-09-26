package br.com.cubotecnologia;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import br.com.cubotecnologia.bo.ranking.IRankingBO;
import br.com.cubotecnologia.bo.ranking.impl.RankingBO;
import br.com.cubotecnologia.utils.ListUtils;
import br.com.cubotecnologia.vo.RankingLineVO;
import br.com.cubotecnologia.vo.RankingVO;

public class RankingBOTest {

	@Test
	public void processesRankingTest() {
		IRankingBO irkbRankingBO = new RankingBO();
		
		Map<String, RankingVO> mapRankingVO = null;
		
		try {
			mapRankingVO = irkbRankingBO.processesRanking("src/main/resources/dojo.log");
			
			List<Map.Entry<String, RankingVO>> lRanking = new LinkedList<Map.Entry<String, RankingVO>>(mapRankingVO.entrySet());
			
			for (Map.Entry<String, RankingVO> entry : lRanking) {
				RankingVO rkvRankingVO = entry.getValue();
				List<RankingLineVO> lRankingLineVO = rkvRankingVO.getRankingLines();
				ListUtils.sortList(lRankingLineVO);
				
				assertEquals("23/04/2013 15:34:22", rkvRankingVO.getStartedDate());
				assertEquals("11348965", rkvRankingVO.getMatchId());
				
				
				compareAssert(lRankingLineVO.get(0), "Roman", "4", "3", "MAGNUM");
				compareAssert(lRankingLineVO.get(1), "Nick", "3", "5", "PISTOL");
				
				assertEquals("23/04/2013 15:42:22", rkvRankingVO.getEndedDate()); 
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void compareAssert
					(RankingLineVO rlvRankingLineVO, String sNickName, String sNumberOfKillers, 
							String sNumeberOfDeaths, String sFavoriteWeapon) {
		assertEquals(sNickName, rlvRankingLineVO.getPlayerNickName());
		assertEquals(sNumberOfKillers, rlvRankingLineVO.getPlayerKillers());
		assertEquals(sNumeberOfDeaths, rlvRankingLineVO.getPlayerDeaths());
		assertEquals(sFavoriteWeapon, rlvRankingLineVO.getFavoriteWeapon());
	}

}
