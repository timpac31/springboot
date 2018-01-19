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
    <h1>JAVA</h1>
    <ul>
      <li><a href="#1">날짜체크</a></li>
      <li><a href="#2"></a></li>
      <li><a href="#3"></a></li>
      <li><a href="#4"></a></li>
    </ul>
  </aside>
  <section>
    <article id="1">
      <h1>날짜체크</h1>
	  <pre>
	/**
	 * 현재시간이 startTime - endTime 사이에있는지 확인
	 * @param String (yyyyMMddHHmmss)
	 * @return boolean
	 */
	boolean validateTime(String startTime, String endTime) {
		Calendar cal = Calendar.getInstance();
		java.util.Date currentTime = cal.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		boolean result = false;
		try {
			java.util.Date startDate = format.parse(startTime);
			java.util.Date endDate = format.parse(endTime);
			if(currentTime.compareTo(startDate) > 0 && currentTime.compareTo(endDate) < 0){
				result = true;
			}
		}catch(Exception e) {
			System.out.println("validateTime parse error");
		}
		
		return result; 
	}

	public static void main(String[] args) {
		if(validateTime("201708090900", "20170809094100")){
			System.out.println("유효한 시간입니다.");
		}else{
			System.out.println("유효한 시간이 아닙니다.");
		}	
	}
	</pre>
    </article>
    
  </section>
  <!-- end of content-wrap   -->  
  </div>
 

 </body>
</html>



