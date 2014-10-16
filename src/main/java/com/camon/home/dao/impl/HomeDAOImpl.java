package com.camon.home.dao.impl;

import java.util.List;

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
	public List<Article> searchAllArticles() {
		return sqlSession.selectList(NAME_SPACE + "selectAllArticles");
	}
	
	@Override
	public Article searchArticle(int seq) {
		return sqlSession.selectOne(NAME_SPACE + "selectArticle", seq);
	}

	@Override
	public int createArticle(Article article) {
		return sqlSession.insert(NAME_SPACE + "insertArticle", article);
	}

	@Override
	public int modifyArticle(Article article) {
		return sqlSession.update(NAME_SPACE + "updateArticle", article);
	}

	@Override
	public int removeArticle(int seq) {
		return sqlSession.delete(NAME_SPACE + "deleteArticle", seq);
	}

	@Override
	public int addReadCount(int seq) {
		return sqlSession.update(NAME_SPACE + "updateReadCount", seq);
	}
}
