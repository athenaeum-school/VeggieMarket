package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.dao.ItemDao;
import jp.com.inotaku.domain.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<Item> getItemList(){
		return itemDao.getAllItem();
	}
	
	@Override
	public Item getItemByItemId(long itemId){
		return itemDao.findByItemId(itemId);
	}
	
	@Override
	public void addItem(Item item){
		itemDao.addItem(item);
	}
	
	@Override
	public void updateItem(Item item){
		itemDao.updateItem(item);
	}
	
	@Override
	public void deleteItem(long itemId){
		itemDao.deleteItem(itemId);
	}
	
}
