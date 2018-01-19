<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec" %>	
	<!-- header start -->
	<div class="top-bar" id="responsive-menu">
		<div class="top-bar-left">
			<ul class="dropdown menu" data-dropdown-menu>
				<li class="menu-text">My Blog</li>
				<li class="has-submenu"><a href="/board/list.do">Board</a>
					<ul class="submenu menu vertical" data-submenu>
						<li><a href="/board/list.do">FreeBoard</a></li>
						<li><a href="#0">QnA</a></li>
					</ul>
				</li>
				<li class="has-submenu"><a href="/dict/javascript.do">소스모음</a>
					<ul class="submenu menu vertical" data-submenu>
						<li><a href="/dict/javascript.do">Javascript</a></li>
						<li><a href="/dict/java.do">JAVA</a></li>
						<li><a href="/dict/jsp.do">JSP</a></li>
					</ul>
				</li>
				<li><a href="#0">About</a></li>
			</ul>
		</div>
		
		<sec:authorize access="isAnonymous()">
			<div class="top-bar-right">
			<form name="loginFrm" action="/login.do" method="POST">
				<ul class="menu">
					<li><input name="id" type="text" placeholder="ID"></li>
					<li><input name="password" type="password" placeholder="Password"></li>
					<li><button class="button">Login</button></li>
				</ul>
			</form>
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<div class="top-bar-right">
				<ul class="menu">
					<li><sec:authentication property="principal.username"/></li>
					<li><a href="/logout.do" class="button">logout</a></li>
				</ul>
			</div>
		</sec:authorize>
		
	</div>
	<!-- header end-->