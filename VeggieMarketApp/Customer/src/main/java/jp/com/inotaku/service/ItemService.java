package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Item;

public interface ItemService {

	List<Item> findAllItems();

	void saveItem(Item item);

	void deleteItem(long itemId);

	Item getItemById(long itemId);

	List<Item> getItemListByName(String itemName);
}
