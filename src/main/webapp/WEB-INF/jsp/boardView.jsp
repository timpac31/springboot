<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>등록폼</title>
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/foundation.min.css">
</head>
<body>
	
	<!-- top menu bar -->
	<div class="top-bar" id="responsive-menu">
		<div class="top-bar-left">
			<ul class="dropdown menu" data-dropdown-menu>
				<li class="menu-text">My Blog</li>
				<li class="has-submenu"><a href="/board/list.do">Board</a>
					<ul class="submenu menu vertical" data-submenu>
						<li><a href="/board/list.do">FreeBoard</a></li>
						<li><a href="#0">QnA</a></li>
					</ul></li>
				<li><a href="#0">menu1</a></li>
				<li><a href="#0">About</a></li>
			</ul>
		</div>
		<div class="top-bar-right">
			<ul class="menu">
				<li><input type="text" placeholder="ID"></li>
				<li><input type="text" placeholder="Password"></li>
				<li><button class="button">Login</button></li>
			</ul>
		</div>
	</div>
	<!-- top menu bar end-->	


	<!-- contents body -->
	<div class="grid-container fluid">
		<div class="grid-x">
			<div class="large-12 cell">
				<h2 style="text-align:center;">Free Board</h2>
			</div>
		</div>	
		
		<div class="grid-x">	
			<form:form name="writeFrm" action="/board/modifyForm.do" method="post">
			<input type="hidden" name="seq" value="${boardVO.seq }"/>
			<table class="bbsview">
				<caption>상세보기</caption>
				<colgroup><col style="width:15%;" /><col/></colgroup>
				<tbody>
					<tr><td>이름</td><td>${boardVO.name }</td></tr>
					<tr><td>제목</td><td>${boardVO.title }</td></tr>
					<tr><td>이메일</td><td>${boardVO.email }</td></tr>
					<tr><td>홈페이지</td><td>${boardVO.homepage }</td></tr>
					<tr><td>첨부파일</td><td><a href="/board/download.do?filename=${boardVO.filename }">${boardVO.filename }</a> (${boardVO.filesize })</td></tr>
					<tr><td>내용</td><td>${boardVO.contentHtml }</td></tr>
					<tr><td>등록일</td><td>${boardVO.nowdate }</td></tr>
				</tbody>
			</table>
			
			<div class="button-group align-right">
				<button type="button" class="button secondary" onclick="javascript:location.href='/board/list.do'">목록</button><button class="button">수정</button>
			</div>
			</form:form>	
		</div>
	</div><!-- contents body end -->
	
	
	<!-- footer -->
	<div class="grid-x grid-padding-x align-center" id="footer">
		all right reserved ydcho@futechsoft.com
	</div><!-- footer end -->
	
	
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/foundation.min.js"></script>	
<script src="/js/app.js"></script>	

</body>
</html>