<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head><title>Spring Security Login </title></head>
    
    <body>
    	<div class="grid-x"><div class="large-12 cell"><h2 style="text-align:center;">LOGIN</h2></div></div>
    	<form th:action="/login.do" name="loginFrm" method="post">
    	<div class="grid-x grid-padding-x align-center">
			<div class="security-login">
		        <c:if test="${not empty error }">
		            <div>${error }</div>
		        </c:if>
		        <c:if test="${not empty logout }">
		            <div>${logout }</div>
		        </c:if>
		        
	            <label for="id">ID</label> <input type="text" name="id"/>
	        	<label for="password">Password</label> <input type="password" name="password" autocomplete="new-password" />
		        <input type="submit" class="button" value="로그인"/> <a href="<c:url value="/logout.do" />" class="button">logout</a>
		        <a href="<c:url value="/googleLogin.do" />" class="success button">google로 로그인</a>
		    </div>
        </div>

		
        </form>
    </body>
    
</html>