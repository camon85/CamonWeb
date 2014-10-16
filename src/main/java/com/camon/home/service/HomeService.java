package com.camon.home.service;

import java.util.List;

import com.camon.home.model.Article;

public interface HomeService {
	List<Article> searchAllArticles();
	Article searchArticle(int seq);
	int createArticle(Article article);
	int modifyArticle(Article article);
	int removeArticle(int seq);
	Article readArtice(int seq);
}
