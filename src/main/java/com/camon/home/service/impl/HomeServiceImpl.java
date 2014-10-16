package com.camon.home.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camon.home.dao.HomeDAO;
import com.camon.home.model.Article;
import com.camon.home.service.HomeService;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
	private static Log log = LogFactory.getLog(HomeServiceImpl.class);
	
	@Autowired
	private HomeDAO homeDAO;
	
	@Override
	public List<Article> searchAllArticles() {
		return homeDAO.searchAllArticles();
	}
	
	@Override
	public Article searchArticle(int seq) {
		return homeDAO.searchArticle(seq);
	}

	@Override
	public int createArticle(Article article) {
		return homeDAO.createArticle(article);
	}

	@Override
	public int modifyArticle(Article article) {
		return homeDAO.modifyArticle(article);
	}

	@Override
	public int removeArticle(int seq) {
		return homeDAO.removeArticle(seq);
	}

	@Override
	public Article readArtice(int seq) {
		int result = homeDAO.addReadCount(seq);
		log.debug("### addReadCount -> result :" + result);
		Article article = null;
		
		if (result > 0) {
			article = homeDAO.searchArticle(seq);
		} else {
			throw new IllegalArgumentException("존재 하지 않는 글");
		}
		
		return article;
	}

}
