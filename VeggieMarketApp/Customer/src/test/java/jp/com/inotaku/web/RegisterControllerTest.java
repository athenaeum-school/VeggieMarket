package jp.com.inotaku.web;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;
import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.service.CustomerService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/resources/spring/application-config.xml",
		"file:src/main/webapp/WEB-INF/mvc-config.xml" })
@WebAppConfiguration
@ActiveProfiles("dev")
public class RegisterControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@InjectMocks
	private RegisterController registerController;

	@Mock
	private CustomerService customerServiceMock;

	@Before
	public void setUp() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");
		MockitoAnnotations.initMocks(this);
		/* mockMvc = webAppContextSetup(wac).build(); */
		mockMvc = standaloneSetup(registerController).setViewResolvers(
				viewResolver).build();
	}

	@Test
	public void testRegisterGet() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/register"))
				.andExpect(status().isOk()).andExpect(view().name("register"))
				.andReturn();

		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Object object = modelMap.get("customer");
		assertThat(object, is(instanceOf(Customer.class)));
	}

	@Test
	public void testRegisterPost() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(post("/register").param("customerName", "user"))
				.andExpect(status().isFound()).andExpect(redirectedUrl("/"))
				.andExpect(model().attributeExists("customer")).andReturn();
		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Customer customer = (Customer) modelMap.get("customer");
		assertThat(customer.getCustomerName(), is("user"));

		verify(customerServiceMock).saveUserCustomer((Customer) anyObject());
	}

}
