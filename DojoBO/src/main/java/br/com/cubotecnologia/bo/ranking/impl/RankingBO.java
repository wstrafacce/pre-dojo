package br.com.cubotecnologia.bo.ranking.impl;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import br.com.cubotecnologia.bo.logline.ILogLineBO;
import br.com.cubotecnologia.bo.logline.impl.LogLineBO;
import br.com.cubotecnologia.bo.ranking.IRankingBO;
import br.com.cubotecnologia.bo.weapon.IWeaponBO;
import br.com.cubotecnologia.bo.weapon.impl.WeaponBO;
import br.com.cubotecnologia.entities.death.Death;
import br.com.cubotecnologia.entities.killer.Killer;
import br.com.cubotecnologia.entities.players.IPlayer;
import br.com.cubotecnologia.entities.players.impl.Player;
import br.com.cubotecnologia.entities.weapons.impl.AWeapon;
import br.com.cubotecnologia.enuns.ActionsEnum;
import br.com.cubotecnologia.utils.DateUtil;
import br.com.cubotecnologia.utils.FileUtils;
import br.com.cubotecnologia.utils.ListUtils;
import br.com.cubotecnologia.utils.MapRankingUtils;
import br.com.cubotecnologia.vo.LogLineVO;
import br.com.cubotecnologia.vo.RankingLineVO;
import br.com.cubotecnologia.vo.RankingVO;


public class RankingBO implements IRankingBO {

	private static Map<String, RankingVO> mapRankingVO;
	private static Map<String, IPlayer> mapPlayers;
	private static String sCurrentMatchId;
	private static RankingVO rknCurrentRankinVO;

	private void instantiateNewRankingVO(String sMatchId, String sDateTime) {

		if (rknCurrentRankinVO != null && !rknCurrentRankinVO.getMatchId().equalsIgnoreCase(sMatchId)
				&& (rknCurrentRankinVO.getEndedDate() == null
						|| StringUtils.isEmpty(rknCurrentRankinVO.getEndedDate()))) {

			rknCurrentRankinVO.setEndedDate(sDateTime);
		}

		if (mapPlayers != null) {
			mapPlayers.clear();
		}

		sCurrentMatchId = sMatchId;
		rknCurrentRankinVO = getRankinVOInstance(sCurrentMatchId);
		rknCurrentRankinVO.setStartedDate(sDateTime);
	}
	
	private static RankingVO getRankinVOInstance(String sMatchId) {
		RankingVO rknRankinVO = null;

		if (mapRankingVO == null) {
			mapRankingVO = new LinkedHashMap<String, RankingVO>();
		}

		if (mapRankingVO.containsKey(sMatchId)) {
			rknRankinVO = mapRankingVO.get(sMatchId);
		} else {
			rknRankinVO = new RankingVO(sMatchId);
			mapRankingVO.put(sMatchId, rknRankinVO);
		}

		return rknRankinVO;
	}

	private static IPlayer getPlayerInstance(String sNickName) throws Exception {
		IPlayer iplyPlayer = null;

		if (mapPlayers == null) {
			mapPlayers = new LinkedHashMap<String, IPlayer>();
		}

		if (mapPlayers.containsKey(sNickName)) {
			iplyPlayer = mapPlayers.get(sNickName);
		} else {
			iplyPlayer = new Player(sNickName);
			iplyPlayer.processessAward(DateUtil.getDateFromString(rknCurrentRankinVO.getStartedDate()));
			mapPlayers.put(sNickName, iplyPlayer);
		}

		return iplyPlayer;
	}

	@Override
	public Map<String, RankingVO> processesRanking(String sLogPath) throws Exception {

		List<String> lLines = FileUtils.getLines(sLogPath);
		processesRanking(lLines);

		return mapRankingVO;
	}

	@Override
	public Map<String, RankingVO> processesRanking(File fFile) throws Exception {

		List<String> lLines = FileUtils.getLines(fFile);
		processesRanking(lLines);

		return mapRankingVO;
	}

	private void processesRanking(List<String> lLines) throws Exception {
		MapRankingUtils.clearRankingVOMap(mapRankingVO);
		ILogLineBO illbLogLineBO = new LogLineBO();
		

		IPlayer iplyPlayer = null;
		
		
		

		for (String sLogLine : lLines) {
			LogLineVO llvlLogLineVO = illbLogLineBO.processesLogLine(sLogLine);

			ActionsEnum actAction = ActionsEnum.getActionByStrAction(llvlLogLineVO.getActionEnum());

			switch (actAction) {
			case STARTED:
				instantiateNewRankingVO(llvlLogLineVO.getMatchId(), llvlLogLineVO.getDateTime());
				break;

			case ENDED:
				rknCurrentRankinVO.setEndedDate(llvlLogLineVO.getDateTime());

				final List<Map.Entry<String, IPlayer>> lPlayers = new LinkedList<Map.Entry<String, IPlayer>>(
						mapPlayers.entrySet());
				final List<RankingLineVO> lRankingLineVO = new ArrayList<RankingLineVO>();

				for (Map.Entry<String, IPlayer> entry : lPlayers) {
					RankingLineVO rlvRankingLineVO = processessRankingLine(entry.getKey(), entry.getValue());
					lRankingLineVO.add(rlvRankingLineVO);
				}

				ListUtils.sortList(lRankingLineVO);
				rknCurrentRankinVO.setRankingLines(lRankingLineVO);
				break;

			case KILLED:
				processesKiller(iplyPlayer, llvlLogLineVO);
				processesDeath(iplyPlayer, llvlLogLineVO);				
				break;

			case WORLD:
				processesDeath(iplyPlayer, llvlLogLineVO);
				break;
			}
		}
	}

	private RankingLineVO processessRankingLine(String sNickName, IPlayer iplyPlayer) throws Exception {
		
		iplyPlayer.processessStreak(false);
		iplyPlayer.processessAward();
		iplyPlayer.processessAward(DateUtil.getDateFromString(rknCurrentRankinVO.getEndedDate()));
		
		RankingLineVO rlvRankingLineVO = new RankingLineVO();

		rlvRankingLineVO.setPlayerNickName(sNickName);
		rlvRankingLineVO.setPlayerKillers(String.valueOf(iplyPlayer.getNumberOfKillers()));
		rlvRankingLineVO.setPlayerDeaths(String.valueOf(iplyPlayer.getNumberOfDeaths()));
		rlvRankingLineVO.setFavoriteWeapon(iplyPlayer.getFavoriteWeapon());
		rlvRankingLineVO.settreak(String.valueOf(iplyPlayer.getStreak()));
		rlvRankingLineVO.setAward(String.valueOf(iplyPlayer.getNumberOfAward()));

		return rlvRankingLineVO;
	}
	
	private void processesDeath (IPlayer iplyPlayer, LogLineVO llvlLogLineVO) throws Exception{
		iplyPlayer = getPlayerInstance(llvlLogLineVO.getVictmNickName());
		Death dthDeath = new Death(DateUtil.getDateFromString(llvlLogLineVO.getDateTime()));
		iplyPlayer.addDeath(dthDeath);
		iplyPlayer.processessStreak(false);
		iplyPlayer.processessAward(dthDeath.getDeathDateTime());
	}
	
	private void processesKiller (IPlayer iplyPlayer, LogLineVO llvlLogLineVO) throws Exception{
		iplyPlayer = getPlayerInstance(llvlLogLineVO.getKillerNickName());
		AWeapon wpnWeapon = new WeaponBO().getWeaponInstace(llvlLogLineVO.getWeapon());
		Killer mrdKiller = new Killer(DateUtil.getDateFromString(llvlLogLineVO.getDateTime()), wpnWeapon);
		iplyPlayer.addKiller(mrdKiller);
		iplyPlayer.processessStreak(true);
	}	
}
