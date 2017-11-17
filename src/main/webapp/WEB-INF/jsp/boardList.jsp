<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/js/jquery-1.11.1.min.js"></script>
</head>
<body>
	
	<div class="contents">
		<div class="contents-wrapper">
		
			<form:form name="searchFrm" commandName="pageVO" action="/board/list.do" method="post" onsubmit="return validate(this);">
				<form:input type="hidden" path="pageNo" value="1"/>
				<div class="search">
					<form:select path="searchType" title="검색조건">
						<option value="">검색조건</option>
						<option value="name">이름</option>
						<option value="title">제목</option>
					</form:select>
					<form:input type="text" path="keyword" value="${page.keyword }" title="검색" />
					<button>검색</button>
				</div>
			</form:form>
			
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

			<div class="buttonWrapper">
				<a href="/board/writeForm.do" class="writeBtn" id="writeBtn">글쓰기</a>
			</div>
			
			<div class="paging">
				<c:forEach var="i" begin="${page.startNo }" end="${page.endNo }">
					<c:choose>
		               <c:when test="${i eq page.pageNo}"><a href="javascript:goPage(${i})" class="active">${i}</a></c:when>
		               <c:otherwise><a href="javascript:goPage(${i})">${i}</a></c:otherwise>
		           	</c:choose>
				</c:forEach>
			</div>
			
		</div><!-- content-wrapper end-->
	</div><!-- content end -->
	
	
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