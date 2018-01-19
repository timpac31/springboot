<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>자주쓰는 소스</title>
  <link rel="stylesheet" type="text/css" href="/css/dictionary.css">
  <script>
  window.onload = function(){
	var elems = document.querySelectorAll('aside li a');
	for(var i=0; i<elems.length; i++){
		elems[i].addEventListener('click', function(){
			removeAllActiveClass();
			this.className = "active";
		});
	}

	function removeAllActiveClass(){
		for(var i=0; i<elems.length; i++){
			elems[i].className = "";
		}
	}
  }
  </script>
 </head>
 <body>


  <div id="content-wrap">
  <aside>
    <h1>JAVASCRIPT</h1>
    <ul>
      <li><a href="#1">IE버전체크</a></li>
      <li><a href="#2">IE 확인</a></li>
      <li><a href="#3">파라미터 받기</a></li>
      <li><a href="#4">AJAX error메세지</a></li>
	  <li><a href="#5">날짜포맷</a></li>
	  <li><a href="#6">a 태그 이벤트 중복 막기</a></li>
	  <li><a href="#7">자주쓰는 정규식</a></li>
	  <li><a href="#8">개발자도구 막기</a></li>
    </ul>
  </aside>
  <section>
    <article id="1">
      <h1>IE버전체크</h1>
	  <pre>
function getInternetExplorerVersion() {
  var rv = -1; // Return value assumes failure.
  if (navigator.appName == 'Microsoft Internet Explorer') {
    var ua = navigator.userAgent;
    var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");        
  if (re.exec(ua) != null)     
    rv = parseFloat(RegExp.$1); 
  }
  return rv; 
} 
	</pre>
    </article>
    <article id="2">
      <h1>IE 확인</h1>
	  <pre>
var agent = navigator.userAgent.toLowerCase();
 if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
 alert("인터넷 익스플로러 브라우저 입니다.");
}
else {
 alert("인터넷 익스플로러 브라우저가 아닙니다.");
}
	</pre>
    </article>
    <article id="3">
      <h1>파라미터 받기</h1>
	  <pre>
var getParameter = function (param) {
	var returnValue;
	var url = location.href;
	var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');
	for (var i = 0; i < parameters.length; i++) {
		var varName = parameters[i].split('=')[0];
		if (varName.toUpperCase() == param.toUpperCase()) {
			returnValue = parameters[i].split('=')[1];
			return decodeURIComponent(returnValue);
		}
	}
};
	</pre>
    </article>
    <article id="4">
      <h1>AJAX error메세지</h1>
		<pre>
error:function(request,status,error){
  console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
}
		</pre>
    </article>
	<article id="5">
      <h1>날짜포맷 return yyyymmdd</h1>
		<pre>
Date.prototype.format = function() {
  var mm = this.getMonth() + 1;
  var dd = this.getDate();
  return [this.getFullYear(), (mm>9 ? '' : '0') + mm, (dd>9 ? '' : '0') + dd].join('');
};
var d = new Date();
console.log(d.format());
		</pre>
    </article>

	<article id="6">
      <h1>이벤트 중복 막기</h1>
		<pre>
event.preventDefault();		// a href 이동 막기 
event.stopPropagation();	// 이벤트 버블링 막기
		</pre>
    </article>

	<article id="7">
      <h1>자주쓰는 정규식</h1>
		<pre>
이메일   /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; 
휴대폰   /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
전화번호(-없이)   /^\d{9,11}$/;
		</pre>
    </article>

	<article id="8">
      <h1>개발자도구 막기</h1>
		<pre>
$(document).keydown(function(event){
	if(event.keyCode==123){
		return false;	//block F12
	} 
	else if(event.ctrlKey && event.shiftKey && event.keyCode==73){
		return false;  //block from ctrl+shift+i
	}
});
		</pre>
    </article>

  </section>
  <!-- end of content-wrap   -->  
  </div>

 </body>
</html>



