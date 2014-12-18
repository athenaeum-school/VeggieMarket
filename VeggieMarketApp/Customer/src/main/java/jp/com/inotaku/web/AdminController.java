package jp.com.inotaku.web;

import java.util.List;

import jp.com.inotaku.domain.Item;
import jp.com.inotaku.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		List<Item> itemList = itemService.findAllItems();
		model.addAttribute("itemList", itemList);
		return "admin/index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute(new Item());
		return "admin/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String register(@ModelAttribute Item item, Model model) {
		itemService.saveItem(item);
		return "redirect:index";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String edit(Long itemId, Model model) {
		if (itemId == null) {
			return "redirect:index";
		}
		Item item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "admin/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Item item, Model model) {
		itemService.saveItem(item);
		return "redirect:index";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String confirm(Long itemId, Model model) {
		if (itemId == null) {
			return "redirect:index";
		}
		Item item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		return "admin/delete";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(Long itemId, Model model) {
		itemService.deleteItem(itemId);
		return "redirect:index";
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(String itemName, Model model) {
		List<Item> itemList = itemService.getItemListByName(itemName);
		model.addAttribute("itemList", itemList);
		return "admin/index";
	}
}
