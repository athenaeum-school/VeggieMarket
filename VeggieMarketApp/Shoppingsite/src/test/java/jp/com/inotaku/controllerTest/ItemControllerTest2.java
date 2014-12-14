package jp.com.inotaku.controllerTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import jp.com.inotaku.controller.ItemController;
import jp.com.inotaku.domain.Item;
import jp.com.inotaku.service.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.context.MessageSource;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

public class ItemControllerTest2 extends AbstractControllerTest {
	
	private List<Item> items = new ArrayList<Item>();
	
	private ItemService itemService;
	
	private MessageSource messageSource;
	
	@Before
	public void initItems(){
		Item item = new Item(1, "冷蔵庫", 10000, "両開き冷蔵庫");
		items.add(item);
		
	}
	@Test
	public void indexTest(){
	
		itemService = mock(ItemService.class);
		when(itemService.getItemList()).thenReturn(items);
		
		ItemController itemController = new ItemController();
		
		ReflectionTestUtils.setField(itemController, "itemService", itemService);
		
		ExtendedModelMap uiModel = new ExtendedModelMap();
		
		String result = itemController.index(uiModel);
		
		assertNotNull(result);
		assertThat("index", is(result));
		
		@SuppressWarnings("unchecked")
		List<Item> modelItems = (List<Item>)uiModel.get("itemList");
		assertThat("冷蔵庫", is(modelItems.get(0).getItemName()));
		assertEquals(1, modelItems.size());
	}
	
	
}
