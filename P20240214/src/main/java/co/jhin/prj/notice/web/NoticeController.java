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

	@RequestMapping(value = "/noticelist", method = {RequestMethod.GET, RequestMethod.POST})
	public String noticeSelectList(Model model, PageVO vo) {
		model.addAttribute("notices", ns.noticeSelectList());
		
		int currentPageNo = vo.getCurrentPageNo(); // 페이지 초기화
		if (currentPageNo != 0) {
			currentPageNo = currentPageNo - 1;
		} else {
			currentPageNo = 0;
		}
		System.out.println(currentPageNo);
		int recordCountPerPage = vo.getRecordCountPerPage(); // 한 페이지당 보여줄 게시글 개수
		int pageSize = vo.getPageSize(); // [pre] 1 2 3 [next]
		vo = ns.selectCount(); // 전체 게시글 건수를 sql에서 가져옴
		int totalRecordCount = vo.getTotalRecordCount(); // 전체 게시물 건수
		int totalPageCount = ((totalRecordCount - 1) / recordCountPerPage) + 1; // 총 페이지 수
		int firstPage = ((currentPageNo) / pageSize) * pageSize + 1; // 페이지 리스트 시작 페이지
		int lastPage = firstPage + pageSize - 1; // 페이지 리스트 마지막 페이지 번호

		if (lastPage > totalPageCount) {
			lastPage = totalPageCount;
		}

		vo.setFirstPageNoOnPageList(firstPage);
		vo.setLastPageNoOnPageList(lastPage);

		model.addAttribute("p", vo);
		model.addAttribute("notices", ns.noticeSelectList(currentPageNo * recordCountPerPage));
		
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
