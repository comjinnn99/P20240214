package co.jhin.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.jhin.prj.notice.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	
	@RequestMapping(value = "/noticelist", method = RequestMethod.GET)
	public String noticeSelectList(Model model) {
		model.addAttribute("notices", ns.noticeSelectList());
		return "notice/noticelist";
	}
	
	@RequestMapping(value = "/noticewriteform", method = RequestMethod.GET)
	public String noticeWriteForm() {
		return "notice/noticewriteform";
	}
	
}
