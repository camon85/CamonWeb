package com.camon.home.dao;

import java.util.List;

import com.camon.home.model.Article;

public interface HomeDAO {
	List<Article> searchAllArticles();
	Article searchArticle(int seq);
	int addReadCount(int seq);
	int createArticle(Article article);
	int modifyArticle(Article article);
	int removeArticle(int seq);
}
