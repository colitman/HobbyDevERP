<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<c:import url="/imports/head?pageTitle=Role"></c:import>
	</head>
	
	<body data-page="role-edit" data-target="${roleKey}">
		<div class="container">
			<c:import url="/imports/mainNav?root=false"></c:import>
			<header class="hd-main-header">
				<div class="row">
					<div class="col-sm-6">
						<h3><span class="js-hd-model-role-name"></span></h3>
						<span class="js-hd-model-role-description"></span>
					</div>
					<div class="col-sm-6">
						<h3>
							<div class="btn-group pull-right">
								<a class="btn btn-success js-hd-save-role-info-button" href="#">Save</a>
							</div>
						</h3>
					</div>
				</div>
			</header>
			<main>
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#authorities" role="tab" data-toggle="tab">Authorities</a></li>
					<li><a href="#users" role="tab" data-toggle="tab">Users</a></li>
				</ul>
				
				<div class="tab-content">
					<div class="active tab-pane fade in" id="authorities">
						<h2>Authorities</h2>
					</div>
					
					<div class="tab-pane fade" id="users">
						<h2>Users</h2>
						<p>Lorem ipsum.</p>
					</div>
				</div>
			
			</main>
			
			<c:import url="/imports/mainFooter"></c:import>
		</div>

		<div class="hd-modals">
		</div>

		<c:import url="/imports/scripts"></c:import>
		<script src="${app}/res/app/js/pages/admin/roles/index_edit.js"></script>
	</body>
</html>