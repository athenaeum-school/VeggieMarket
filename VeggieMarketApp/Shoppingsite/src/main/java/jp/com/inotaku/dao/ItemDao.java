package jp.com.inotaku.dao;

import java.util.List;

import jp.com.inotaku.domain.Item;

public interface ItemDao {

	public abstract List<Item> getAllItem();

	public abstract Item findByItemId(long itemId);

	public abstract void addItem(Item item);

	public abstract void updateItem(Item item);

	public abstract void deleteItem(long itemId);

}