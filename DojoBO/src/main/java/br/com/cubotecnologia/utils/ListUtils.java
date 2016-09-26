package br.com.cubotecnologia.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.cubotecnologia.vo.RankingLineVO;

public class ListUtils {
	
	public static void sortList(List<RankingLineVO> lRankingLineVO) {
		
		Collections.sort(lRankingLineVO, new Comparator<RankingLineVO>() {
	        @Override
	        public int compare(RankingLineVO rlvRankingLineVO_1, RankingLineVO rlvRankingLineVO_2)
	        {
	        	int iNumberOfKillers_1 = Integer.parseInt(rlvRankingLineVO_1.getPlayerKillers());
	        	int iNumberOrDeaths_1 = Integer.parseInt(rlvRankingLineVO_1.getPlayerDeaths());
	        	int diff_1 = iNumberOfKillers_1 - iNumberOrDeaths_1;
	        	
	        	int iNumberOfKillers_2 = Integer.parseInt(rlvRankingLineVO_2.getPlayerKillers());
	        	int iNumberOrDeaths_2 = Integer.parseInt(rlvRankingLineVO_2.getPlayerDeaths());
	        	int diff_2 = iNumberOfKillers_2 - iNumberOrDeaths_2;
	        	
	        	int result = 0;
	        	
	        	if (diff_1 == diff_2) {
	        		result = iNumberOfKillers_1 > iNumberOfKillers_2 ? -10 : 10;
	        	} else {
	        		result = diff_1 > diff_2 ? -10 : 10;
	        	}
	        	
	            return  result;
	        }
	    });
	}

}
