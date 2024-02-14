<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Page Header-->
<header class="masthead" style="background-image: url('resources/assets/img/home-bg.jpg')">
  <div class="container position-relative px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <div class="page-heading">
          <h1>Notice</h1>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- Post Content-->
<article class="mb-4">
  <div class="container px-4 px-lg-5">
    <a href="noticewriteform" class="btn btn-success" role="button">공지 작성하기</a>
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <c:if test="${ not empty notices }">
          <c:forEach items="${ notices }" var="n">
            <p>${ n.noticeId }</p>
          </c:forEach>
        </c:if>
        <c:if test="${ empty notices }">
          <p>등록된 공지사항이 없습니다</p>
        </c:if>
      </div>
    </div>
  </div>
</article>


<script>
	
</script>
