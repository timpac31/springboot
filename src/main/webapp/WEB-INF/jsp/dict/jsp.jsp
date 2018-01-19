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
    <h1>JSP</h1>
    <ul>
      <li><a href="#1">메타태그</a></li>
      <li><a href="#2">import file등</a></li>
	  <li><a href="#3">배경이미지 대체텍스트</a></li>
    </ul>
  </aside>
  <section>
    <article id="1">
      <h1>메타태그</h1>
	  <pre>
최신렌더링: &lt;meta http-equiv="X-UA-Compatible" content="IE=edge"&gt;
디바이스 스케일: &lt;meta name="viewport" content="width=device-width, initial-scale=1.0"&gt;
리로드(30초): &lt;meta http-equiv="refresh" content="30"&gt;

	</pre>
    </article>
    <article id="2">
      <h1>import file등</h1>
	  <pre>
클래스,라이브러리: &lt;%@page import="java.text.SimpleDateFormat"%&gt;
JSTL: &lt;%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %"&gt;
    : &lt;%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %"&gt;
    : &lt;%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %"&gt;
CSS: &ltlink rel="stylesheet" type="text/css" href="theme.css"&gt;
JSP: &lt;%@ include file="" %&gt;
   : &lt;jsp:include page=""/&gt;
	</pre>
    </article>
	<article id="3">
      <h1>배경이미지 대체텍스트넣기(웹접근성)</h1>
	  <pre>
&lt;p style="height:1px;overflow:hidden;"&gt;이미지 설명글&lt;/p&gt;
	  </pre>
    </article>
    
  </section>
  <!-- end of content-wrap   -->  
  </div>
 

 </body>
</html>



