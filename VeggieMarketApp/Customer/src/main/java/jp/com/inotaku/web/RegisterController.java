package jp.com.inotaku.web;

import jp.com.inotaku.domain.Customer;
import jp.com.inotaku.service.CustomerService;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Setter
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegister(@ModelAttribute Customer customer, Model model) {
		customerService.saveUserCustomer(customer);
		return "redirect:/";
	}
}
