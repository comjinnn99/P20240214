package co.jhin.prj.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "blog/about";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post() {
		return "blog/post";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "blog/contact";
	}
	
}
