package jp.com.inotaku.daoTest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;


import jp.com.inotaku.dao.ItemDao;
import jp.com.inotaku.domain.Item;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/*.xml"})
public class ItemDaoTest {
	
	@Autowired
	private ItemDao itemDao;
	
	private Item item1;
	private Item item2;
	
	@Before
	public void setup() {
		item1 = new Item("冷蔵庫", 10000, "４ドア冷蔵庫（３５５Ｌ・右開き）");
		item2 = new Item("洗濯機", 5000, "全自動洗濯機（5．5kg） ");
		itemDao.addItem(item1);
		itemDao.addItem(item2);
	}
	

	@Test
	public void testGetAllItem() {
		
		List<Item> itemlist = itemDao.getAllItem();
		System.out.println(itemlist);
		assertThat("冷蔵庫",is(itemlist.get(2).getItemName()));
		int itemId = (int)itemlist.get(1).getItemId();
		assertThat(2, (equalTo(itemId)));
	}

	@Test
	public void testFindByItemId() {

		Item newItem = itemDao.findByItemId(2);
		System.out.println(newItem);
		assertThat("洗濯機", is(newItem.getItemName()));
		
	}


	@Test
	public void testUpdateItem() {
	
		Item item3 = new Item(1, "掃除機", 2000, "コードレスクリーナー");
		itemDao.updateItem(item3);
		Item newItem = itemDao.findByItemId(1);
		System.out.println(newItem);
		assertThat("掃除機", is(newItem.getItemName()));
	}

	@Test
	public void testDeleteItem() {
		itemDao.deleteItem(1);
		try {
			itemDao.findByItemId(1);
		} catch (Exception e) {
		}
		
	}

}
