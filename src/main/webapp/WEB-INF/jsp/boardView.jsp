<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<head><title>상세보기</title></head>
	
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
	</div>
	<!-- contents body end -->