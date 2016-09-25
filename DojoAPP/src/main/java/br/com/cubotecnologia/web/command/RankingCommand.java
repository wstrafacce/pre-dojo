package br.com.cubotecnologia.web.command;

public class RankingCommand {

	private String sMatchId;
	private String sStartedDate;
	private String sEndedDate;

	public String getsMatchId() {
		return sMatchId;
	}

	public void setsMatchId(String sMatchId) {
		this.sMatchId = sMatchId;
	}

	public String getsStartedDate() {
		return sStartedDate;
	}

	public void setsStartedDate(String sStartedDate) {
		this.sStartedDate = sStartedDate;
	}

	public String getsEndedDate() {
		return sEndedDate;
	}

	public void setsEndedDate(String sEndedDate) {
		this.sEndedDate = sEndedDate;
	}

}
