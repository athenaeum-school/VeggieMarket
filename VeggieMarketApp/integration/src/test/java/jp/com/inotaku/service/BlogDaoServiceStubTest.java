package jp.com.inotaku.service;

import static org.junit.Assert.*;

import java.util.List;

import jp.com.inotaku.dao.BlogDao;
import jp.com.inotaku.domain.Blog;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlogDaoServiceStubTest {

	public static final long BLOG_ID = 214141241L;
    private BlogDaoStub blogDaoStub;
    private BlogService blogService;
    private Blog blog;

    private class BlogDaoStub implements BlogDao {

    	private Long blogId = 0l;
    	private String title = "title";
    	
		public List<Blog> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		public Blog findByBlogId(long blogId) {
			// TODO Auto-generated method stub
			return null;
		}
		public void creat(Blog blog) {
			// TODO Auto-generated method stub
			
		}
		public void update(Blog blog) {
			this.blogId = blog.getBlogId();
			this.title = blog.getTitle();
			
		}
		public void delete(long blogId) {
			// TODO Auto-generated method stub
			
		}
    }

    @Before
    public void init() {
    	blog = new Blog();
        blogDaoStub = new BlogDaoStub();
        blogDaoStub.blogId = BLOG_ID;
        blogDaoStub.title = "My title";
        blogService = new BlogServiceImpl(blogDaoStub);
    }

    @Test
    public void update() {

    }

}
