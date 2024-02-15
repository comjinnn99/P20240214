package co.jhin.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.jhin.prj.common.PageVO;
import co.jhin.prj.notice.map.NoticeMapper;
import co.jhin.prj.notice.service.NoticeService;
import co.jhin.prj.notice.service.NoticeVO;

@Service
@Primary
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper map;
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		return map.noticeSelectList();
	}
	
	@Override
	public List<NoticeVO> noticeSelectList(int offset) {
		return map.noticeSelectList(offset);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeHitUpdate(NoticeVO vo) {
		return map.noticeHitUpdate(vo);
	}

	@Override
	public PageVO selectCount() {
		return map.selectCount();
	}

}
