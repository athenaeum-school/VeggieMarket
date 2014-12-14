package jp.com.inotaku.serviceTest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;


import jp.com.inotaku.dao.ItemDao;
import jp.com.inotaku.domain.Item;



import jp.com.inotaku.service.ItemService;
import jp.com.inotaku.service.ItemServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
	
	@Mock
	private ItemDao itemDao;
	
	@InjectMocks
	private ItemService itemService = new ItemServiceImpl();

	private Item item1;
	private Item item2;
	private List<Item> itemList;
	
	@Before
	public void setUp() throws Exception {
		item1 = new Item(1,"冷蔵庫", 10000, "４ドア冷蔵庫（３５５Ｌ・右開き）");
		item2 = new Item(2,"洗濯機", 5000, "全自動洗濯機（5．5kg） ");
		itemList = new ArrayList<Item>();
		itemList.add(item1);
		itemList.add(item2);
		
	}

	@Test
	public void testGetAllItem() {
		doReturn(itemList).when(itemDao).getAllItem();
		List<Item> items = itemService.getItemList();
		assertThat("冷蔵庫",is(items.get(0).getItemName()));
		assertThat("洗濯機", is(items.get(1).getItemName()));
		
		verify(itemDao).getAllItem();
		verify(itemDao,never()).addItem(item1);
	}

	@Test
	public void testFindByItemId() {
		doReturn(item1).when(itemDao).findByItemId(1);
		doReturn(item2).when(itemDao).findByItemId(2);
		Item newItem1 = itemService.getItemByItemId(1);
		assertThat(10000, is(newItem1.getPrice()));
		
		Item newItem2 = itemService.getItemByItemId(2);
		assertThat(5000, is(newItem2.getPrice()));
		
		doThrow(Exception.class).when(itemDao).findByItemId(3);
		Item newItem3 = null;
		try {
			 newItem3 = itemService.getItemByItemId(3);
		} catch (Exception e) {
			assertThat(e, is(Exception.class));
		}
		
		
		assertNull(newItem3);
		verify(itemDao,never()).getAllItem();
		
		
	}

	@Test
	public void testAddItem() {
		
	}

	@Test
	public void testUpdateItem() {
	}

	@Test
	public void testDeleteItem() {
	}

}
