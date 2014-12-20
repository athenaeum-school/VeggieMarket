package jp.com.inotaku;

import jp.com.inotaku.domain.Blog;

public class ShippingActivator {

	public void outPrint(Blog blog){
		blog.setShipping("配送サービス");
		System.out.println("ShippingActivator: " + blog);
	}
}
