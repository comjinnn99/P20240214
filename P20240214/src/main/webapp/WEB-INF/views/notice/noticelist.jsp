<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Page Header-->
<header class="masthead" style="background-image: url('resources/assets/img/home-bg.jpg')">
  <div class="container position-relative px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <div class="page-heading">
          <h1>Notice</h1>
          <span class="subheading">Notice List</span>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- Post Content-->
<article class="mb-4">
  <div class="container px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div>
        <a href="noticewriteform" class="btn btn-success mb-5 btn-md" role="button">공지 작성하기</a>
      </div>
      <c:if test="${ not empty notices }">
        <table class="table table-hover">
          <thead>
            <tr>
              <th>순 번</th>
              <th>제 목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>조회수</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${ notices }" var="n">
              <tr onclick="noticeSelect(${n.noticeId})">
                <td>${n.noticeId}</td>
                <td>${n.noticeTitle}</td>
                <td>${n.noticeWriter}</td>
                <td>${n.noticeDate}</td>
                <td>${n.noticeHit}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:if>
      <c:if test="${ empty notices }">
        <p>등록된 공지사항이 없습니다</p>
      </c:if>
    </div>
  </div>
</article>
<ul class="pagination justify-content-center mb-5">
  <li class="page-item">
    <a class="page-link" href="javascript:void(0);">Previous</a>
  </li>
  <c:forEach var="index" begin="${ p.firstPageNoOnPageList }" end="${ p.lastPageNoOnPageList }" step="1">
    <li class="page-item">
      <a class="page-link" href="javascript:void(0);" onclick="callFunction(${index});">${ index }</a>
    </li>
  </c:forEach>
  <li class="page-item">
    <a class="page-link" href="javascript:void(0);">Next</a>
  </li>
</ul>


<div>
  <form id="frm" action="noticeselect" method="post">
    <input type="hidden" id="noticeId" name="noticeId" />
  </form>
  <form id="pageFrm" action="noticelist" method="post">
    <input type="hidden" id="currentPageNo" name="currentPageNo" />
  </form>
</div>


<script type="text/javascript">
	function noticeSelect(id) {
		document.getElementById("noticeId").value = id;
		frm.submit();
	}
	
	function callFunction(page){
		document.getElementById("currentPageNo").value = page;
		pageFrm.submit();
	}
</script>
