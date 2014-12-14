package jp.com.inotaku.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jp.com.inotaku.dao.BlogDao;
import jp.com.inotaku.domain.Blog;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public BlogServiceImpl(){}
	
	public BlogServiceImpl(BlogDao blogDao){
		this.blogDao = blogDao;
	}
	
	//NullPointerExceptionでもなんでもいいので、適当な例外を投げましょう
	public List<Blog> getAllBlog() throws Exception {
		if(blogDao != null){
			return blogDao.findAll();
		} else {
			throw new Exception();
		}
	}

	public Blog findByIdgetBlog(long blogId) {
		return blogDao.findByBlogId(blogId);
	}

	public void update(Blog blog) {
		blogDao.update(blog);
	}

	public void addBlog(Blog blog) {
		blogDao.creat(blog);
	}

	public void deleteBlog(Long blogId) {
		blogDao.delete(blogId);
	}

}
