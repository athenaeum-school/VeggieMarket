package jp.com.inotaku.web;

import jp.com.inotaku.domain.Cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cart")
public class CartController {

	@RequestMapping(method = RequestMethod.GET)
	public String cart(Model model) {
		model.addAttribute(new Cart());
		return "cart";
	}
}
