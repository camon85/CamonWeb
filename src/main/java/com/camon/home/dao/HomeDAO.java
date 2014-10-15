package com.camon.home.dao;

import com.camon.home.model.Article;

public interface HomeDAO {
	Article findArticle(int seq);

	int addArticle(Article article);
}
