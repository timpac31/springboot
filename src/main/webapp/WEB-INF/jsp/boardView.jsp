<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세화면</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script>
function downfile(filename) {
	
}
</script>
</head>
<body>


	<div class="contents" style="width:645px;">
	
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
		
		<div class="buttonWrapper">
			<button type="button" onclick="javascript:location.href='/board/list.do'">목록</button> <button>수정</button>
		</div>
		</form:form>
	
	</div>

</body>
</html>