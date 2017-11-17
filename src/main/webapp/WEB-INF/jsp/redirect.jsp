<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script> 
	var msg = '${msg}';
	var url = '${url}';
	if(msg != null && msg != undefined && msg != "") {
		alert(msg);
	}
	document.location.href = url;
</script>
</head>
<body>

</body>
</html>
