package br.com.cubotecnologia.vo;

import java.util.List;

public class RankingVO {
	
	private String sStartedDate;
	private String sEndedDate;
	private String sMatchId;
	private List<RankingLineVO> lRankingLines;

	public RankingVO(String sMatchId) {
		super();
		this.sMatchId = sMatchId;
	}

	
	public String getStartedDate() {
		return sStartedDate;
	}


	public void setStartedDate(String sStartedDate) {
		this.sStartedDate = sStartedDate;
	}


	public String getEndedDate() {
		return sEndedDate;
	}


	public void setEndedDate(String sEndedDate) {
		this.sEndedDate = sEndedDate;
	}


	public String getMatchId() {
		return sMatchId;
	}
	
	public void setMatchId(String sMatchId) {
		this.sMatchId = sMatchId;
	}
	
	public List<RankingLineVO> getRankingLines() {
		return lRankingLines;
	}
	
	public void setRankingLines(List<RankingLineVO> lRankingLines) {
		this.lRankingLines = lRankingLines;
	}
}
