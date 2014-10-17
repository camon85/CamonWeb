package com.camon.home.controller;

import java.util.List;
//import static com.glider.framework.test.ReflectionInjectorUtils.injector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.camon.home.model.Article;
import com.camon.home.service.HomeService;

public class HomeControllerTest {
	// 테스트대상 클래스의 의존객체에 Mock Object 주입
	@Mock
	private HomeService homeService;

	// 테스트대상 클래스에 Mock Object 주입
	@InjectMocks
	private HomeController homeController;

	@Before
	public void setUp() {
		// 테스트대상 Mock 클래스에 의존 Mock객체를 쉽게 주입할 수 있음.
		// http://wiki.kwonnam.pe.kr/java/unittest/reflectioninjector 참고.
//		injector(homeController).set(homeService);
//		model = new ModelAndView();
	}

	@Test
	public void test() {
		List<Article> articleList = homeService.searchAllArticles();
	}

}
