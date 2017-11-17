<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Spring Security Login </title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>
    <body>
    	<div class="security-login">
    		<h2>LOGIN PAGE</h2>
	        <c:if test="${not empty error }">
	            <div>${error }</div>
	        </c:if>
	        <c:if test="${not empty logout }">
	            <div>${logout }</div>
	        </c:if>
	        <form th:action="/login.do" name="loginFrm" method="post">
	            <div><label> ID : <input type="text" name="id"/> </label></div>
	            <div><label> Password: <input type="password" name="password" autocomplete="new-password" /> </label></div>
	            <div><input type="submit" value="로그인"/> <a href="<c:url value="/logout.do" />">logout</a></div>
	        </form>
        </div>
    </body>
</html>