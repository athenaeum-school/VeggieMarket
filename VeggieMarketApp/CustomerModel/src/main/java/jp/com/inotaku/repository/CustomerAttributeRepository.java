package jp.com.inotaku.repository;
import java.util.List;

import jp.com.inotaku.domain.CustomerAttribute;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = CustomerAttribute.class)
public interface CustomerAttributeRepository {
	
	@Query("select ca FROM CustomerAttribute ca join ca.customer c where name like %:name% and c.localeCode like %:localeCode%")
	List<CustomerAttribute> findByNameLikeAndLocaleCode(@Param("name")String name,@Param("localeCode")String localCode);
	
	@Query("select ca FROM CustomerAttribute ca left join ca.customer c where name like %:name%")
	List<CustomerAttribute> findByNameLikeAndLocaleCode(@Param("name")String name);
}
