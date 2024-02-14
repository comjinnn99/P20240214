package co.jhin.prj.notice.service;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int noticeId;
	private String noticeWriter;
	private LocalDate noticeDate;
	private String noticeTitle;
	private String noticeSubject;
	private int noticeHit;
}
