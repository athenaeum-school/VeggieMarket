package jp.com.inotaku.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jp.com.inotaku.domain.Blog;

@Component
public class BlogDaoImpl implements BlogDao {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Blog> findAll() {
		return em.createQuery("from Blog").getResultList();
	}

	public Blog findByBlogId(long blogId) {
		return (Blog)em.createQuery("from Blog where blogId = :blogId")
				.setParameter("blogId", blogId).getSingleResult();
	}
	
	public void creat(Blog blog) {
		em.persist(blog);
	}

	public void update(Blog blog) {
		em.merge(blog);
	}

	public void delete(long blogId) {
		em.remove(findByBlogId(blogId));
	}

	
}
