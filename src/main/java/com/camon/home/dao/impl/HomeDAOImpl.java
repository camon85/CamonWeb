package com.camon.home.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camon.home.dao.HomeDAO;
import com.camon.home.model.Article;

@Repository
public class HomeDAOImpl implements HomeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAME_SPACE = "board."; 
	
	public Article findArticle(int seq) {
		Article article = sqlSession.selectOne(NAME_SPACE + "selectArticle");
		
		return article;
	}
}
