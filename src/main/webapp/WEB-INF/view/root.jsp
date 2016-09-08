<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<c:import url="/imports/head?pageTitle=Home"></c:import>
	</head>
	
	<body data-page="root">
		<div class="container">
			<c:import url="/imports/mainNav?root=true"></c:import>
			
			<main>
				root
			</main>
			
			<c:import url="/imports/mainFooter"></c:import>
		</div>

		<div class="hd-modals"></div>

		<c:import url="/imports/scripts"></c:import>

	</body>
</html>