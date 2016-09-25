package br.com.cubotecnologia.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.cubotecnologia.bo.ranking.IRankingBO;
import br.com.cubotecnologia.bo.ranking.impl.RankingBO;
import br.com.cubotecnologia.vo.RankingVO;
import br.com.cubotecnologia.web.command.RankingCommand;
import br.com.cubotecnologia.web.utils.FileServerUtils;

/**
 * @author william.s.soares
 * @edited
 */
@Controller
public class RankingController {

	private static final Logger lgLOGGER = LoggerFactory.getLogger(RankingController.class);

	public IRankingBO irkbRankingBO;

	/**
	 * @param Set
	 *            business object
	 */
	public void setBO(IRankingBO irkbRankingBO) {
		this.irkbRankingBO = irkbRankingBO;
	}

	/**
	 * Returns an instance of the object RankingCommand in the form
	 * 
	 * @return
	 */
	@ModelAttribute(value = "rankingCommand")
	public RankingCommand getRankingCommandObject() {
		return new RankingCommand();
	}

	/**
	 * Render the initial view of DojoApp
	 * 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "view")
	public ModelAndView initialForm() {
		return new ModelAndView("view");
	}

	/**
	 * This method will render the dashboard view of Ranking
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = "processessLog", method = RequestMethod.POST)
	public ModelAndView render(@RequestParam("file") MultipartFile mfFile) {

		ModelAndView modelAndView = new ModelAndView("dojoDashBoard");

		Map<String, RankingVO> mapRankingVO = null;

		File serverFile = FileServerUtils.uploadFileOnServer(mfFile);

		setBO(new RankingBO());

		try {
			mapRankingVO = irkbRankingBO.processesRanking(serverFile);

			List<Map.Entry<String, RankingVO>> lMapRankings = new LinkedList<Map.Entry<String, RankingVO>>(
					mapRankingVO.entrySet());
			
			List<RankingVO> lRankings = new ArrayList<RankingVO>();
			
			
			for (Map.Entry<String, RankingVO> entry : lMapRankings) {				
				lRankings.add(entry.getValue());				
			}

			modelAndView.addObject("lRankings", lRankings);

		} catch (Exception e) {
			modelAndView.setViewName("view");
			modelAndView.addObject("errorMessage", "Failed to processess log => " + e);
			lgLOGGER.error("Failed to processess log => {}", e);
		}

		return modelAndView;
	}
	
	/**
	 * Render the initial view of DojoApp
	 * 
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "return")
	public ModelAndView returnPage(HttpSession session) {
		session.removeAttribute("lRankings");
		return new ModelAndView("view");
		
	}
	
}