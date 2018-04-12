<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<head><title>목록</title></head>

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
						<td><a href="/board/view.do?seq=${boardVO.seq}" data-seq="${boardVO.seq}">${boardVO.title }</a></td>
						<td>${boardVO.homepage }</td>
						<td>${boardVO.nowdate }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="grid-x align-center">		
			<ul class="pagination text-center" role="navigation" aria-label="Pagination">
				<c:if test="${page.startNo != 1 }"><li class="pagination-previous"><a href="javascript:goPage(${page.startNo-1})">Previous</a></li></c:if>
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
		
		<div id="detailDialog" class="detailDialog"></div>

	</div>
	<!-- contents body end -->
		
<script>
	$(function(){
		$('select[name=searchType]').val('${page.searchType}');	
		
		
		//제목에 마우스 1초이상 오버 했을 때 상세내용 창으로 보여주기 
		var timeoutId; 
		var x, y;
		$('.table-default a').hover(function() {
			x = event.pageX + 20; 
			y = event.pageY;
			var seq = this.getAttribute('data-seq');
			
		    if (!timeoutId) {
		        timeoutId = window.setTimeout(function() {
		            timeoutId = null;
		            showDetail(seq);
		       }, 1000);
		    }
		},
		function () {
		    if (timeoutId) {
		        window.clearTimeout(timeoutId);
		        timeoutId = null;
		    }
		    else {
		    	$('#detailDialog').hide();
		    }
		});
		
		function showDetail(seq) {
			$.ajax({
				url: '/board/viewAjax1.do',
				type: 'post',
				data: {'seq' : seq},				
			}).done(function(data){
				$('#detailDialog').html(data.contentHtml).css({'left':x, 'top':y}).show();
			}).fail(function(error){
				console.log("ajax view error : ", error);
			});
		}

		
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
