<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	<head><title>글 수정</title></head>

	<!-- contents body -->
	<div class="grid-container fluid">
		<div class="grid-x">
			<div class="large-12 cell">
				<h2 style="text-align:center;">Free Board</h2>
			</div>
		</div>	
		
		<div class="grid-x">	
			<form:form name="writeFrm" modelAttribute="boardVO" action="/board/modify.do" method="POST" enctype="multipart/form-data" onsubmit="return validate(this);">
			<form:input type="hidden" path="seq" />
			<table class="bbswrite">
				<caption>글쓰기</caption>
				<colgroup><col style="width:15%;" /><col/></colgroup>
				<tbody>
					<tr><td>이름</td><td><form:input type="text" path="name" style="width:200px;" value="${boardVO.name }"/></td></tr>
					<tr><td>제목</td><td><form:input type="text" path="title" style="width:90%;" value="${boardVO.title }"/></td></tr>
					<tr><td>이메일</td><td><form:input type="text" path="email" style="width:90%;" value="${boardVO.email }"/></td></tr>
					<tr><td>홈페이지</td><td><form:input type="text" path="homepage" style="width:90%;" value="${boardVO.homepage }"/></td></tr>
					
					<c:choose>
					 <c:when test="${empty boardVO.filename }">
						<tr><td>첨부파일</td><td><input type="file" name="file" style="width:90%;" /></td></tr>
					 </c:when>
					 <c:otherwise>
					 	<tr>
					 		<td>첨부파일</td><td>${boardVO.filename } <button type="button" class="button small" onclick="javascript:modFile();">삭제</button>
					 		<input type="file" name="file"/></td>
					 	</tr>
					 	<%-- <form:input type="hidden" path="filename" />
					 	<form:input type="hidden" path="filesize" />
					 	<form:input type="hidden" path="type" /> --%>
					 </c:otherwise>
					</c:choose>
					
					<tr><td colspan="2"><form:textarea path="content" rows="8" cols="80" value="${boardVO.content }"></form:textarea></td></tr>
					<tr><td>비밀번호</td><td><form:input type="password" path="passwd" style="width:200px;" autocomplete="new-password" /></td></tr>
				</tbody>
			</table>
			
			<div class="button-group align-right">
				<button type="button" class="button secondary" onclick="javascript:location.href='/board/list.do'">목록</button><button class="button">등록</button>
			</div>
			</form:form>
		</div>
	</div>
	<!-- contents body end -->


<script>
	function validate(frm) {
		if(frm.name.value == "") {
			alert("이름을 입력하세요");
			frm.name.focus();
			return false;
		}
		if(frm.title.value == "") {
			alert("제목을 입력하세요");
			frm.title.focus();
			return false;
		}
		if(frm.email.value == "") {
			alert("이메일을 입력하세요");
			frm.email.focus();
			return false;
		}
		if(frm.content.value == "") {
			alert("내용을 입력하세요");
			frm.content.focus();
			return false;
		}
		if(frm.passwd.value == "") {
			alert("비밀번호를 입력하세요");
			frm.passwd.focus();
			return false;
		}
	}
	
	function modFile() {
		$('.bbswrite tr').eq(4).html('<td>첨부파일</td><td><input type="file" name="file" style="width:90%;" /></td>');
		$('input[name=filename]').remove();
		$('input[name=filesize]').remove();
		$('input[name=type]').remove();
	}
</script>

</body>
</html>