package com.camon.home.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.camon.home.model.Article;
import com.camon.home.service.HomeService;

public class HomeControllerTest {
	// 테스트대상 클래스의 의존객체에 Mock Object 주입
	@Mock
	private HomeService homeService;

	// 테스트대상 클래스에 Mock Object 주입
	@InjectMocks
	private HomeController homeController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		// Process mock annotations
		MockitoAnnotations.initMocks(this);

		// Setup Spring test in standalone mode
		this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}

	/**
	 * 단순 get 호출 -> view 호출
	 * @throws Exception
	 */
	@Test
	public void testMoveIndexPage() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

	/**
	 * ResponseBody 테스트
	 * @throws Exception
	 */
	@Test
	public void testSearchAllArticles() throws Exception {
		List<Article> articleList = new ArrayList<Article>();
		Article article = new Article();
		article.setTitle("제목");
		article.setStatus('D');
		articleList.add(article);
		
		when(homeService.searchAllArticles()).thenReturn(articleList);
		mockMvc.perform(get("/search/allArticles/")).andExpect(status().isOk())
				.andExpect(content().string("{\"articleList\":[{\"seq\":0,\"title\":\"제목\",\"readCount\":0,\"status\":\"D\"}]}"));
		
		verify(homeService, times(1)).searchAllArticles(); // 한번만 호출되었는지 확인
	}

	/**
	 * redirect 테스트
	 * @throws Exception
	 */
	@Test
	public void testWriteArticle() throws Exception {
		mockMvc.perform(post("/write").param("title", "제목").param("content", "내용")
				.param("writerId", "camon"))
				.andExpect(status().isMovedTemporarily())
				.andExpect(view().name("redirect:/list"));
	}
	
	
	/**
	 * PathVariable 테스트
	 * @throws Exception
	 */
	@Test
	public void testMoveModifyFormPage() throws Exception {
		mockMvc.perform(get("/modifyForm/{seq}", 1))
				.andExpect(status().isOk())
				.andExpect(view().name("writeForm"));
	}

}
