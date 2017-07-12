package com.example;

import com.example.web.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*在JUnit中有很多个Runner，他们负责调用你的测试代码，每一个Runner都有各自的特殊功能
 *你要根据需要选择不同的Runner来运行你的测试代码*/
@RunWith(SpringJUnit4ClassRunner.class)//// 引入Spring-Test框架支持
/*大坑，之前的@SpringApplicationConfiguration已经不存在了，@SpringBootTest是Spring Boot版本1.4才出现的
 *具有Spring Boot支持的引导程序（例如，加载应用程序、属性，为我们提供Spring Boot的所有精华部分）关键是自动导入测试需要的类*/
@SpringBootTest
public class MockServletTest {

	private MockMvc mvc;

	/*创建的HelloController在@Before函数中创建并传递到MockMvcBuilders.standaloneSetup（）函数中*/
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}

}
