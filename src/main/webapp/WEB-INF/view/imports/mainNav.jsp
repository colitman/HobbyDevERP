<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />
<c:set var="isAnon" value="${empty currentUser}" />

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${app}/">[[app_name]]</a>
			<button type="button"
					class="navbar-toggle collapsed"
					data-toggle="collapse"
					data-target="#hd-main-nav">
			
				<i class="fa fa-bars"></i>
			</button>
		</div>
		
		<div class="collapse navbar-collapse" id="hd-main-nav">
			
		</div>
	</div>
</nav>

<section class="hd-alerts"></section>