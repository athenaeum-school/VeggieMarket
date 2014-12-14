package jp.com.inotaku.service;

import java.util.List;

import jp.com.inotaku.domain.Blog;

public interface BlogService {

	List<Blog> getAllBlog() throws Exception;
	
	Blog findByIdgetBlog(long blogId);
	
	void update(Blog blog);
	
	void addBlog(Blog blog);
	
	void deleteBlog(Long blogId);
		
	
}
