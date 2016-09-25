package br.com.cubotecnologia.bo.ranking;

import java.io.File;
import java.util.Map;

import br.com.cubotecnologia.vo.RankingVO;

public interface IRankingBO {
	public Map<String, RankingVO> processesRanking(String sLogPath) throws Exception;

	public Map<String, RankingVO> processesRanking(File fFile) throws Exception;
}
