package com.camon.home.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camon.home.model.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class HomeServiceTest {
	@Autowired
	HomeService homeService;

	@Before
	public void setUp() {
		
	}

	@Test
	public void searchAllArticlesTest() {
		List<Article> articleList = homeService.searchAllArticles();
		for (Article article : articleList) {
			System.out.println(article.getTitle());
		}
	}

}