package co.jhin.prj.notice.service;

import java.util.List;

import co.jhin.prj.common.PageVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	
	List<NoticeVO> noticeSelectList(int offset);

	NoticeVO noticeSelect(NoticeVO vo);

	int noticeInsert(NoticeVO vo);

	int noticeUpdate(NoticeVO vo);

	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(NoticeVO vo);
	
	PageVO selectCount();
}
