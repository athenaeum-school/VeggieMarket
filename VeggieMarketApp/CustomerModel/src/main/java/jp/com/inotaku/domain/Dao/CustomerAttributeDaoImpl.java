package jp.com.inotaku.domain.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import jp.com.inotaku.domain.CustomerAttribute;

@Repository
public class CustomerAttributeDaoImpl implements CustomerAttributeDao {

	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public List<CustomerAttribute> findByNameLikeAndLocaleCode(String name,String localeCode) {
		return em.createQuery("FROM CustomerAttribute where name like :name")
		/*	.setParameter("localeCode", "%" + localeCode + "%")*/
			.setParameter("name", "%" + name + "%")
			.getResultList();
	}

}
