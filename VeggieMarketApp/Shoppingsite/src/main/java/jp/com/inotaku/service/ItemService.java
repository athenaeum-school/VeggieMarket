package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Item;

public interface ItemService {

	public abstract List<Item> getItemList();

	public abstract Item getItemByItemId(long itemId);

	public abstract void addItem(Item item);

	public abstract void updateItem(Item item);

	public abstract void deleteItem(long itemId);

}