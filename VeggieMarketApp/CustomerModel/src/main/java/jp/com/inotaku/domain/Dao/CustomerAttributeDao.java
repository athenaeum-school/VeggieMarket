package jp.com.inotaku.domain.Dao;

import java.util.List;

import jp.com.inotaku.domain.CustomerAttribute;

public interface CustomerAttributeDao {

	public List<CustomerAttribute> findByNameLikeAndLocaleCode(String name,String localeCode); 
}
