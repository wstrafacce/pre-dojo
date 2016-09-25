package br.com.cubotecnologia.utils;

import java.util.Map;

import br.com.cubotecnologia.vo.RankingVO;

public class MapRankingUtils extends MapUtils{
	
	public static void clearRankingVOMap(Map<String, RankingVO> mapRankingVO){
		if (mapRankingVO != null){
			mapRankingVO.clear();
		}
	}

}
