package com.camon.home.controller;

import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camon.home.model.Article;
import com.camon.home.service.HomeService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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
	public String moveIndexPage(Locale locale, Model model) {
		log.debug("### url -> /");

		return "index";
	}

	/**
	 * 전체 게시글 조회
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws BizException
	 */
	@RequestMapping(value = "/search/allArticles/", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String search(Model model) {
		List<Article> articleList = homeService.searchAllArticles();
		
		JsonElement element = new Gson().toJsonTree(articleList, new TypeToken<List<Article>>() {}.getType());
		JsonObject jObj = new JsonObject();
		jObj.add("articleList", element);
		
		return jObj.toString();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String moveListPage(Locale locale, Model model) {
		log.debug("### url -> /list");
		Article article = homeService.searchArticle(1);
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
	public String moveWriteFormPage(Model model) {
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

		homeService.createArticle(article);

		return "redirect:/list";
	}

	/**
	 * 게시글 읽기
	 * 
	 * @param request
	 * @param response
	 * @param seq
	 * @return
	 * @throws BizException
	 */
	@RequestMapping(value = "/article/{seq}", method = RequestMethod.GET)
	public String read(Model model, @PathVariable int seq) {
		// 숫자가 아닌 값 입력 시 exception 처리
		// if (!NumberUtil.isNumber(seq)) {
		// throw new BizException(ExceptionEnum.WRONG_ARTICLE_NO);
		// }

		// // 글이 존재하지 않을때
		// if (article == null || result < 1) {
		// throw new BizException(ExceptionEnum.NOT_EXIST_ARTICLE);
		// }

		// article.setCnt(article.getCnt() + 1);

		Article article = homeService.readArtice(seq);
		model.addAttribute("article", article);

		return "read";
	}

	/**
	 * 글 수정 form으로 이동
	 * 
	 * @param request
	 * @param response
	 * @param seq
	 * @return
	 * @throws BizException
	 */
	@RequestMapping(value = "/modifyForm/{seq}", method = RequestMethod.GET)
	public String moveModifyFormPage(Model model, @PathVariable int seq) {
		// 숫자가 아닌 값 입력 시 exception 처리
		// if (!NumberUtil.isNumber(seq)) {
		// throw new BizException(ExceptionEnum.WRONG_ARTICLE_NO);
		// }

		Article article = homeService.searchArticle(seq);

		// 수정하려는 글이 존재하지 않을 경우
		// if (article == null) {
		// throw new BizException(ExceptionEnum.NOT_EXIST_ARTICLE);
		// }

		model.addAttribute("article", article);

		return "writeForm";
	}

	/**
	 * 글 수정. 완료 후 글 목록 페이지로 이동
	 * 
	 * @param request
	 * @param response
	 * @param seq
	 * @param title
	 * @param content
	 * @return
	 * @throws BizException
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyArticle(Model model, @RequestParam int seq,
			@RequestParam String title, @RequestParam String content) {
		// 숫자가 아닌 값 입력 시 exception 처리
		// if (!NumberUtil.isNumber(seq)) {
		// throw new BizException(ExceptionEnum.WRONG_ARTICLE_NO);
		// }

		Article article = new Article();
		article.setSeq(seq);
		article.setTitle(title);
		article.setContent(content);

		// 입력폼 유효성 검사
		// if (!ArticleValidator.isValideModifyForm(article)) {
		// throw new BizException(ExceptionEnum.EMPTY_FORM);
		// }

		int result = homeService.modifyArticle(article);

		// 글 수정 결과가 0개인 경우
		// if (result < 1) {
		// throw new BizException(ExceptionEnum.RESULT_ZERO);
		// }

		return "redirect:/list";
	}

	/**
	 * 글 삭제. 완료 후 글 목록 페이지로 이동
	 * 
	 * @param request
	 * @param response
	 * @param seq
	 * @return
	 * @throws BizException
	 */
	@RequestMapping(value = "/removeArticle/{seq}", method = RequestMethod.GET)
	public String removeArticle(Model model, @PathVariable int seq) {
		// 숫자가 아닌 값 입력 시 exception 처리
		// if (!NumberUtil.isNumber(seq)) {
		// throw new BizException(ExceptionEnum.WRONG_ARTICLE_NO);
		// }

		int result = homeService.removeArticle(seq);

		// 글 삭제 결과가 0개인 경우
		// if (result < 1) {
		// throw new BizException(ExceptionEnum.RESULT_ZERO);
		// }

		return "redirect:/list";
	}

}
