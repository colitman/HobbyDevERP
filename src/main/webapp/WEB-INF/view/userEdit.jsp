<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<c:import url="/imports/head?pageTitle=${username} :: Edit User"></c:import>
	</head>
	
	<body data-page="user-edit" data-target="${username}">
		<div class="container">
			<c:import url="/imports/mainNav?root=false"></c:import>
			<header class="hd-main-header">
				<div class="row">
					<div class="col-sm-6">
						<h3><span class="js-hd-model-user-fullname"></span></h3>
					</div>
					<div class="col-sm-6">
						<h3>
							<div class="btn-group pull-right">
								<a class="btn btn-success" id="hd-save-user-info-button" href="#">Save</a>
								<a class="btn btn-default" href="${app}/users/${username}">Cancel</a>
							</div>
						</h3>
					</div>
				</div>
			</header>
			<main>
				<div class="row">
					<section class="col-xs-6 col-sm-4">
						<img class="js-hd-model-user-image hd-user-image-large" src="" />
					</section>
					
					<div class="clearfix visible-xs-block"></div>
					
					<section class="col-sm-4">
						<header><h4>Information</h4></header>
						
					</section>
					
					<section class="col-sm-4">
						<header><h4>Personal Information</h4></header>
						
					</section>
				</div>
			</main>
			
			<c:import url="/imports/mainFooter"></c:import>
		</div>

		<div class="hd-modals"></div>

		<c:import url="/imports/scripts"></c:import>
		<script src="${app}/res/app/js/pages/userEdit/index.js"></script>
	</body>
</html>