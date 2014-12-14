package jp.com.inotaku.controller;

import jp.com.inotaku.domain.Item;
import jp.com.inotaku.domain.User;
import jp.com.inotaku.service.ItemService;
import jp.com.inotaku.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InitController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/init",method = RequestMethod.GET)
	public String create(){
		Item item1 = new Item("冷蔵庫", 10000, "４ドア冷蔵庫（３５５Ｌ・右開き）");
		Item item2 = new Item("洗濯機", 5000, "全自動洗濯機（5．5kg） ");
		itemService.addItem(item1);
		itemService.addItem(item2);
		
		User user1 = new User("ユーザー", "pass");
		userService.addUser(user1);
		return "redirect:/item";
	}
}
