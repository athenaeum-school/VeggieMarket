package jp.com.inotaku.controller;

import java.util.List;

import jp.com.inotaku.domain.Blog;
import jp.com.inotaku.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/json")
public class JsonController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public @ResponseBody List<Blog> blogList() throws Exception{
		return blogService.getAllBlog(); 
	}
	
	@RequestMapping(value = "/{blogId}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody Blog getBlog(@PathVariable long blogId){
		return blogService.findByIdgetBlog(blogId);
	}
	
	@RequestMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public @ResponseBody Blog addBlog(@RequestBody Blog blog){
		blogService.addBlog(blog);
		return blog;
	}
	
	@RequestMapping(value = "/{blogId}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
	public @ResponseBody Blog update(@PathVariable long blogId,@RequestBody Blog blog){
		blog.setBlogId(blogId);
		blogService.update(blog);
		return blog;
	}
	
	@RequestMapping(value ="/{blogId}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public @ResponseBody Blog delete(@PathVariable long blogId){
		Blog blog = blogService.findByIdgetBlog(blogId);
		blogService.deleteBlog(blogId);
		return blog;
	}
}
