package jp.com.inotaku.serviceTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import jp.com.inotaku.domain.Item;
import jp.com.inotaku.service.ItemService;
import jp.com.inotaku.test.annotation.DataSets;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImplTest extends AbstractServiceImplTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private ItemService itemService;

	@DataSets(setUpDataSet = "/jp/com/inotaku/serviceTest/ItemServiceImplTest.xls")
	@Test
	public void getItemListTest() {
		List<Item> result = itemService.getItemList();

		assertNotNull(result);
		assertEquals(2, result.size());
		assertThat("冷蔵庫", is(result.get(0).getItemName()));

	}

	@DataSets(setUpDataSet = "/jp/com/inotaku/serviceTest/ItemServiceImplTest.xls")
	@Test
	public void getItemByItemIdTest() {
		Item result = itemService.getItemByItemId(2);
		assertThat("洗濯機", is(result.getItemName()));
		thrown.expect(NoResultException.class);
		Item result2 = itemService.getItemByItemId(10);
		System.out.println(result2);
	}

	@Test
	public void addItemTest() {
		deleteFromTables("ITEM");
		Item item = new Item("掃除機", 10000, "ワイヤレス掃除機");
		itemService.addItem(item);

		List<Item> itemList = (List<Item>) itemService.getItemList();
		assertThat("掃除機", is(itemList.get(0).getItemName()));
	}

	@Test
	public void errorTest()  {
		deleteFromTables("ITEM");
		/*thrown.expect(PersistenceException.class);*/
		Item item = new Item();
		itemService.addItem(item);

		List<Item> itemList = (List<Item>) itemService.getItemList();
		System.out.println(itemList);
		/*assertEquals(0, itemList.size());*/
	}
}
