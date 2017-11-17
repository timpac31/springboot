<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>등록폼</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<div class="contents" style="width:645px;">

		<form:form name="writeFrm" action="/board/write.do" commandName="boardVO" method="post" enctype="multipart/form-data" onsubmit="return validate(this);">
		<table class="bbswrite">
			<caption>글쓰기</caption>
			<colgroup><col style="width:15%;" /><col/></colgroup>
			<tbody>
				<tr><td>이름</td><td><form:input type="text" path="name" style="width:200px;" value="${sessionName }"/></td></tr>
				<tr><td>제목</td><td><form:input type="text" path="title" style="width:90%;" /></td></tr>
				<tr><td>이메일</td><td><form:input type="text" path="email" style="width:90%;" /></td></tr>
				<tr><td>홈페이지</td><td><form:input type="text" path="homepage" style="width:90%;" /></td></tr>
				<tr>
					<td>첨부파일</td>
					<td>
						<input type="file" name="file" style="width:90%;" />
					</td>
				</tr>
				<tr><td colspan="2"><form:textarea path="content" rows="8" cols="80"></form:textarea></td></tr>
				<tr><td>비밀번호</td><td><form:input type="password" path="passwd" style="width:200px;" autocomplete="new-password" /></td></tr>
			</tbody>
		</table>
		
		<div class="buttonWrapper">
			<button type="button" onclick="javascript:location.href='/board/list.do'">목록</button><button>등록</button>
		</div>
		</form:form>
		
	</div>
	

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
</script>

</body>
</html>