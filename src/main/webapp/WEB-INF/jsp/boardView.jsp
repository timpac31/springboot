<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.demo.util.StringUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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
			<input type="hidden" name="reply_seq" value="${boardVO.seq }"/>
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
			
			<ul class="reply-group">
				<li class="reply-head">답변</li>
				<c:forEach var="replyList" items="${replyList }">
				<li>
					<h5>${replyList.name }<span>${replyList.regDate }</span></h5>
					<div>${replyList.contentHtml }</div>					
				</li>
				</c:forEach>
			</ul>
		
			<sec:authorize access="isAuthenticated()">	
				<input name="name" type="hidden" value="<sec:authentication property="principal.username"/>" />
				<ul class="reply-group">
					<li>
						<p style="color:blue; margin-bottom:0;"> <sec:authentication property="principal.username"/></p>
						<!-- <p>principal.password : <sec:authentication property="principal.password"/></p>
						<p>principal.enabled : <sec:authentication property="principal.enabled"/></p> -->
					</li>
					<li>
						<div class="grid-x">
							<div class="large-11 cell"><textarea name="content" rows="3" cols="20"></textarea></div>
							<div class="large-1 cell"><button class="button" id="btn_reWrite" style="height:90px; width:100%;">등록</button></div>
						</div>
					</li>
				</ul>		
			</sec:authorize>
			
			
			<div class="button-group align-right">
				<button type="button" class="button secondary" onclick="javascript:location.href='/board/list.do'">목록</button>
				<button class="button">수정</button>
			</div>
			</form:form>	
		</div>
	</div>
	<!-- contents body end -->
	
<script>
	$(function(){
		$('#btn_reWrite').on('click', function(){
			var frm = document.writeFrm;
			if(frm.content.value == "") {
				alert("내용을 입력해 주세요");
				return false;
			}
			
			//frm.name.setAttribute("name", "reply_seq");
			frm.action = "/board/writeReply.do";
			frm.submit();
		});
	});
</script>
