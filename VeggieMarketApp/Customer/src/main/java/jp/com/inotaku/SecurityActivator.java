package jp.com.inotaku;

import java.io.UnsupportedEncodingException;

import jp.com.inotaku.domain.Blog;

public class SecurityActivator {

	public Blog outPrint(Blog blog) throws UnsupportedEncodingException{
		System.out.println("securityActivator: " + blog);
		return blog;
	}
}
