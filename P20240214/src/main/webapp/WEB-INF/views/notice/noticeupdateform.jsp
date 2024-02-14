<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Page Header-->
<header class="masthead" style="background-image: url('resources/assets/img/home-bg.jpg')">
  <div class="container position-relative px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <div class="page-heading">
          <h1>Notice</h1>
          <span class="subheading">Notice Update Form</span>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- Main Content -->
<div class="container px-4 px-lg-5">
  <div class="row gx-4 gx-lg-5 justify-content-center">
    <form action="noticeupdate" method="post">
      <div>
        <input type="hidden" id="noticeId" name="noticeId" value="${ notice.noticeId }" />
      </div>
      <div class="mb-3">
        <label for="noticeTitle">제목:</label>
        <input type="text" class="form-control" id="noticeTitle" name="noticeTitle" value="${ notice.noticeTitle }" placeholder="제목 입력"
          required="required">
      </div>
      <div class="mb-3">
        <label for="noticeWriter">작성자:</label>
        <input type="text" class="form-control" id="noticeWriter" name="noticeWriter" value="${ notice.noticeWriter }" placeholder="이름 입력"
          required="required">
      </div>
      <div class="mb-3">
        <label for="noticeSubject">내용:</label>
        <textarea class="form-control" id="noticeSubject" name="noticeSubject" rows="10">${ notice.noticeSubject }</textarea>
      </div>
      <div class="mb-5">
        <button type="submit" class="btn btn-primary">등록</button>
        <button type="reset" class="btn btn-secondary">취소</button>
      </div>
    </form>
  </div>
</div>