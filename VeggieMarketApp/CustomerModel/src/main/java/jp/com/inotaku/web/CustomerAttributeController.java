package jp.com.inotaku.web;
import jp.com.inotaku.domain.CustomerAttribute;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customerattributes")
@Controller
@RooWebScaffold(path = "customerattributes", formBackingObject = CustomerAttribute.class)
public class CustomerAttributeController {
}
