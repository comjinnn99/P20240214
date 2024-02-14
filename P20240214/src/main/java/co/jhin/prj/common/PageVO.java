package co.jhin.prj.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageVO {
	private int currentPageNo; // 현재 페이지 번호
	private int recordCountPerPage; // 한 페이지에 보여줄 게시글 개수
	private int pageSize; // 페이지 리스트에 게시되는 페이지 건수 [이전] 1 2 3 [다음]
	private int totalRecordCount; // 전체 게시물 건수 sql에서 가져옴
	private int totalPageCount; // 총 페이지 수 (totalRecordCount-1)/recordCountPerPage+1
	private int firstPageNoOnPageList; // 페이지 리스트 시작 페이지 
	// (((currentPageNo-1)/pageSize)*pageSize+1)
	private int lastPageNoOnPageList; // 페이지 리스트 마지막 페이지 번호
	// lastPageNoOnPageList = firstPageNoOnPageList+pageSize-1
	// if lastPageNoOnPageList > totalRecordCount {lastPageNoOnPageList = totalPageCount} 
}