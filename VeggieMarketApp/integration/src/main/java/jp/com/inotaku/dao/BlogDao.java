package jp.com.inotaku.dao;

import java.util.List;

import jp.com.inotaku.domain.Blog;

public interface BlogDao {

	List<Blog> findAll();
	
	Blog findByBlogId(long blogId);
	
	void creat(Blog blog);
	
	void update(Blog blog);
	
	void delete(long blogId);
	
	

}