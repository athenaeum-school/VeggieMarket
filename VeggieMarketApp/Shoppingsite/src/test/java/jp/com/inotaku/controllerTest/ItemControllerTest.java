package jp.com.inotaku.controllerTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;


import jp.com.inotaku.domain.Item;
import jp.com.inotaku.service.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.ModelResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/mvc*.xml","file:src/main/resources/spring/application-config.xml"})
public class ItemControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Autowired
	private ItemService itemService;
	
	private Item item1;
	private Item item2;

	@Before
	public void setup() {
		mockMvc = webAppContextSetup(wac).build();
		item1 = new Item("冷蔵庫", 10000, "４ドア冷蔵庫（３５５Ｌ・右開き）");
		item2 = new Item("洗濯機", 5000, "全自動洗濯機（5．5kg） ");
		itemService.addItem(item1);
		itemService.addItem(item2);
	}

	@Test
	public void testIndex() throws Exception {
	MvcResult mvcResult = mockMvc.perform(get("/item")).andDo(print()).andExpect(status().isOk())
		.andExpect(view().name("index")).andReturn();
	
	ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
	@SuppressWarnings("unchecked")
	List<Item> itemList = (List<Item>) modelMap.get("itemList");
	assertThat("冷蔵庫", is(itemList.get(0).getItemName()));
		
	}

	@Test
	public void testDetail() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/detail").param("itemId", "2")).andDo(print())
				.andExpect(status().isOk()).andExpect(view().name("detail")).andReturn();
		
		ModelMap modelMap = mvcResult.getModelAndView().getModelMap();
		Item item = (Item)modelMap.get("item");
		assertThat("洗濯機", is(item.getItemName()));
		
	}

}
