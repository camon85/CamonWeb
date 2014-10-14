package com.camon.home.service.impl;

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
	public Article findArticle(int seq) {
		log.debug("seq:"+seq);
		Article article = homeDAO.findArticle(seq);
		
		return article;
	}

}
