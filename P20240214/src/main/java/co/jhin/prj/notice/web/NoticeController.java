package co.jhin.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.jhin.prj.common.PageVO;
import co.jhin.prj.notice.service.NoticeService;
import co.jhin.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;

	@RequestMapping(value = "/noticelist", method = RequestMethod.GET)
	public String noticeSelectList(Model model, PageVO vo) {
		model.addAttribute("notices", ns.noticeSelectList());
		return "notice/noticelist";
	}

	@RequestMapping(value = "/noticewriteform", method = RequestMethod.GET)
	public String noticeWriteForm() {
		return "notice/noticewriteform";
	}

	@RequestMapping(value = "/noticewrite", method = RequestMethod.POST)
	public String noticeWrite(Model model, NoticeVO vo) {
		int result = ns.noticeInsert(vo);
		String viewPage = null;

		if (result > 0) {
			model.addAttribute("message", "정상적으로 처리되었습니다.");
			viewPage = "home/message";
		} else {
			model.addAttribute("message", "처리에 실패했습니다.");
			viewPage = "home/message";
		}

		return viewPage;
	}
	
	@RequestMapping(value = "/noticeselect", method = RequestMethod.POST)
	public String noticeSelect(Model model, NoticeVO vo) {
		ns.noticeHitUpdate(vo);
		model.addAttribute("notice", ns.noticeSelect(vo));
		return "notice/noticeselect";
	}

	@RequestMapping(value = "/noticeupdateform", method = RequestMethod.POST)
	public String noticeUpdateForm(Model model, NoticeVO vo) {
		model.addAttribute("notice", ns.noticeSelect(vo));
		return "notice/noticeupdateform";
	}
	
	@RequestMapping(value = "/noticeupdate", method = RequestMethod.POST)
	public String noticeUpdate(Model model, NoticeVO vo) {
		int result = ns.noticeUpdate(vo);
		String viewPage = null;
		
		if (result > 0) {
			model.addAttribute("message", "정상적으로 처리되었습니다.");
			viewPage = "home/message";
		} else {
			model.addAttribute("message", "처리에 실패했습니다.");
			viewPage = "home/message";
		}
		
		return viewPage;
	}
	
	@RequestMapping(value = "/noticedelete", method = RequestMethod.POST)
	public String noticeDelete(Model model, NoticeVO vo) {
		int result = ns.noticeDelete(vo);
		String viewPage = null;

		if (result > 0) {
			model.addAttribute("message", "정상적으로 처리되었습니다.");
			viewPage = "home/message";
		} else {
			model.addAttribute("message", "처리에 실패했습니다.");
			viewPage = "home/message";
		}

		return viewPage;
	}
}
