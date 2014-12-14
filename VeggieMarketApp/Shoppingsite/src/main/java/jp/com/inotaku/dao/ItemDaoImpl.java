package jp.com.inotaku.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jp.com.inotaku.domain.Item;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItem() {
		return em.createQuery("from Item").getResultList();
	}

	@Override
	public Item findByItemId(long itemId) {
		return (Item)em.createQuery("from Item where itemId = :itemId")
				.setParameter("itemId", itemId).getSingleResult();
	}

	@Override
	public void addItem(Item item) {
		em.persist(item);
	}

	@Override
	public void updateItem(Item item) {
		em.merge(item);
	}

	@Override
	public void deleteItem(long itemId) {
		em.remove(findByItemId(itemId));
	}

}
