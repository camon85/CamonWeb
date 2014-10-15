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
	
	@Override
	public Article findArticle(int seq) {
		return sqlSession.selectOne(NAME_SPACE + "selectArticle", seq);
	}

	@Override
	public int addArticle(Article article) {
		return sqlSession.insert(NAME_SPACE + "insertArticle", article);
	}
}
