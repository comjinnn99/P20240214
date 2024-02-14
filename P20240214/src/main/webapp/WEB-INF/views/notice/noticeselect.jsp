<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Page Header-->
<header class="masthead" style="background-image: url('resources/assets/img/home-bg.jpg')">
  <div class="container position-relative px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <div class="page-heading">
          <h1>Notice</h1>
          <span class="subheading">Notice Select</span>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- Main Content -->
<div class="container px-4 px-lg-5">
  <div class="row gx-4 gx-lg-5 justify-content-center text-center">
    <table class="table table-bordered mb-3">
      <tr>
        <th>순번</th>
        <td>${notice.noticeId}</td>
        <th>작성자</th>
        <td>${notice.noticeWriter}</td>
        <th>작성일자</th>
        <td>${notice.noticeDate}</td>
      </tr>
      <tr>
        <th>제목</th>
        <td colspan="3">${notice.noticeTitle}</td>
        <th>조회수</th>
        <td>${notice.noticeHit}</td>
      </tr>
      <tr>
        <th>내용</th>
        <td colspan="5">
          <textarea class="form-control" rows="10">${ notice.noticeSubject }</textarea>
        </td>
      </tr>
    </table>
    <div class="mb-5">
      <a href="noticelist" class="btn btn-success" role="button">목록으로</a>
      <button type="button" class="btn btn-secondary" onclick="noticeUpdate(${notice.noticeId})">수정</button>
      <button type="button" class="btn btn-secondary" onclick="noticeDelete(${notice.noticeId})">삭제</button>
    </div>
  </div>
</div>
<div>
  <form id="updateFrm" action="noticeupdateform" method="post">
    <input type="hidden" id="noticeId" name="noticeId" value="${notice.noticeId}" />
  </form>
</div>
<div>
  <form id="deleteFrm" action="noticedelete" method="post">
    <input type="hidden" id="noticeId" name="noticeId" value="${notice.noticeId}" />
  </form>
</div>


<script type="text/javascript">
  function noticeUpdate(id) {
    updateFrm.submit();
  }
  
  function noticeDelete(id) {
    deleteFrm.submit();
  }
</script>