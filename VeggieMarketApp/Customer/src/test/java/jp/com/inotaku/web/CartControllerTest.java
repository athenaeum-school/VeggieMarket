package jp.com.inotaku.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;
import jp.com.inotaku.domain.Cart;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/application-config.xml",
		"file:src/main/webapp/WEB-INF/mvc-config.xml" })
@WebAppConfiguration
@ActiveProfiles("dev")
public class CartControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private CartController cartController;;

	@Before
	public void setUp() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(cartController)
				.setViewResolvers(viewResolver).build();
	}

	@Test
	public void testRegisterGet() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/cart"))
				.andExpect(status().isOk()).andExpect(view().name("cart"))
				.andReturn();
		
		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Cart cart = (Cart)modelMap.get("cart");
		assertThat(cart, notNullValue(Cart.class));
	}
}
