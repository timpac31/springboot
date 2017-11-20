<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>목록</title>
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
	</div><!-- top menu bar end-->	


	<!-- contents body -->
	<div class="grid-container fluid">
		<div class="grid-x">
			<div class="large-12 cell">
				<h2 style="text-align:center;">Free Board</h2>
			</div>
		</div>	
	
		<form:form name="searchFrm" commandName="pageVO" action="/board/list.do" method="post" onsubmit="return validate(this);">
		<form:input type="hidden" path="pageNo" value="1"/>
			<div class="grid-x align-right">
				<div class="medium-6 cell">
					<div class="input-group">
						<form:select class="input-group-field" path="searchType" title="검색조건">
							<option value="">검색조건</option>
							<option value="name">이름</option>
							<option value="title">제목</option>
						</form:select>
						<form:input type="text" class="input-group-field" path="keyword" value="${page.keyword }" title="검색" />
						<div class="input-group-button"><button class="button">검색</button></div>
					</div>
				</div>
			</div>
		</form:form>	
		
		<div class="grid-x">
			<table class="table-default">
				<colgroup>				
					<col style="width:10%;" />
					<col style="width:10%;" />
					<col style="width:50%;" />
					<col style="width:20%;" />
					<col style="width:10%;" />
				</colgroup>
				<thead>
					<tr><th>번호</th><th>이름</th><th>제목</th><th>홈페이지</th><th>날짜</th></tr>
				</thead>
				<tbody>
				<c:forEach var="boardVO" items="${list }">
					<tr>
						<td>${boardVO.seq }</td>
						<td>${boardVO.name }</td>
						<td><a href="/board/view.do?seq=${boardVO.seq}">${boardVO.title }</a></td>
						<td>${boardVO.homepage }</td>
						<td>${boardVO.nowdate }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="grid-x align-center">		
			<ul class="pagination text-center" role="navigation" aria-label="Pagination">
				<c:if test="${page.startNo != 1}"><li class="pagination-previous"><a href="javascript:goPage(${page.startNo-1})">Previous</a></li></c:if>
				<c:forEach var="i" begin="${page.startNo }" end="${page.endNo }">
					<c:choose>
		               <c:when test="${i eq page.pageNo}"><li class="current"><a href="javascript:goPage(${i})">${i}</a></li></c:when>
		               <c:otherwise><li><a href="javascript:goPage(${i})">${i}</a></li></c:otherwise>
		           	</c:choose>
				</c:forEach>
				<c:if test="${page.hasNextPage}"><li class="pagination-next"><a href="javascript:goPage(${page.startNo+10})">Next</a></li></c:if>
			</ul>
		</div>
		<div class="grid-x align-right">
			<div class="buttonWrapper">
				<a href="/board/writeForm.do" class="button" id="writeBtn">글쓰기</a>
			</div>
		</div>

	</div><!-- contents body end -->
	
	<!-- footer -->
	<div class="grid-x grid-padding-x align-center" id="footer">
		<em>all right reserved ydcho@futechsoft.com</em>
	</div><!-- footer end -->
	
	
	
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/what-input.js"></script>
<script src="/js/foundation.min.js"></script>
<script src="/js/app.js"></script>	
<script>
	$(function(){
		$('select[name=searchType]').val('${page.searchType}');
	});
	
	function goPage(no) {
		document.searchFrm.pageNo.value = no;
		document.searchFrm.submit();
	}
	
	function validate(frm){
		if(frm.searchType.value == "") {
			alert("검색조건을 선택하세요");
			return false;
		}
		if(frm.keyword.value == "") {
			alert("검색어를 입력하세요");
			return false;
		}
	}
</script>
	
</body>
</html>