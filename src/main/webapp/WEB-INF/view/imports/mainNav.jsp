<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${app}/">ERP</a>
			<sec:authorize access="isAuthenticated()">
				<button type="button"
						class="navbar-toggle collapsed"
						data-toggle="collapse"
						data-target="#hd-main-nav">
				
					<i class="fa fa-bars"></i>
				</button>
			</sec:authorize>
		</div>

		<sec:authorize access="isAuthenticated()">
			<div class="collapse navbar-collapse" id="hd-main-nav">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<span class="js-hd-model-current-username"></span>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li class="dropdown-header"><i class="fa fa-user"></i> <span class="js-hd-model-current-fullname"></span></li>
							<form id="hd-signout-form" action="${app}/signout" method="post"></form>
							<li><a href="#" id="hd-signout-link"><i class="fa fa-sign-out"></i> Sign Out</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</sec:authorize>
	</div>
</nav>

<section class="hd-alerts"></section>