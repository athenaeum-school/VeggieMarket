package jp.com.inotaku.controller;

import jp.com.inotaku.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/item",method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("itemList",itemService.getItemList());
		return "index";
	}
	
	@RequestMapping(value = "/detail",method = RequestMethod.GET)
	public String detail(long itemId, Model model){
		model.addAttribute("item",itemService.getItemByItemId(itemId));
		return "detail";
	}
}
