package jp.com.inotaku.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="blog_id")
	private long blogId;

	@Column(name="title")
	private String title;
	
	@Column(name="message")
	private String message;
	
	public long getBlogId() {
		return blogId;
	}
	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", message="
				+ message + "]";
	}
	
	
}
