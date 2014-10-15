package com.camon.home.controller;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.camon.home.model.Article;
import com.camon.home.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static Log log = LogFactory.getLog(HomeController.class);

	@Autowired
	private HomeService homeService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.debug("### url -> /");

		return "index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String moveListPage(Locale locale, Model model) {
		log.debug("### url -> /list");
		Article article = homeService.findArticle(1);
		model.addAttribute("article", article);

		return "list";
	}

	/**
	 * 글 작성 form으로 이동
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) {
		log.debug("### url -> /writeForm");

		return "writeForm";
	}

	/**
	 * 글 insert. 완료 후 글 목록 페이지로 이동
	 * 
	 * @param request
	 * @param response
	 * @param title
	 * @param writer
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeArticle(Model model, @RequestParam String title,
			@RequestParam String content, @RequestParam String writerId) {
		log.debug("### url -> /writeForm");
		
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setWriterId(writerId);
		
		homeService.addArticle(article);

		return "redirect:/list";
	}

}
