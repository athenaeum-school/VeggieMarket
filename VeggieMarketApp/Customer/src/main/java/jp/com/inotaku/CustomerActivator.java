package jp.com.inotaku;

import jp.com.inotaku.domain.Blog;

public class CustomerActivator {

	public Blog customerEnricher(Blog blog){
		blog.setCustomer("カスタマーサービス");
		System.out.println("customerActivator: " + blog);
		return blog;
	}
}
