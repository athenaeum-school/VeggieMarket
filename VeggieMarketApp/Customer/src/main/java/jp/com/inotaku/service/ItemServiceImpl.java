package jp.com.inotaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.com.inotaku.domain.Item;
import jp.com.inotaku.repository.ItemRepository;

@Service("itemservice")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> findAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public void saveItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void deleteItem(long itemId) {
		itemRepository.delete(itemId);
	}

	@Override
	public Item getItemById(long itemId) {
		return itemRepository.findOne(itemId);
	}

	@Override
	public List<Item> getItemListByName(String itemName) {
		return itemRepository.findByItemNameLike("%" + itemName + "%");
	}

}
