<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<c:import url="/imports/head?pageTitle=Roles"></c:import>
	</head>
	
	<body data-page="roles-admin">
		<div class="container">
			<c:import url="/imports/mainNav?root=false"></c:import>
			<header class="hd-main-header">
				<div class="row">
					<div class="col-sm-6">
						<h3>Roles</h3>
					</div>
				</div>
			</header>
			<main>
				<button type="button" id="hd-add-new-role-button" class="btn btn-success pull-right">Add role</button>
				<table id="js-hd-model-roles-table" class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Users Count</th>
							<th>Authorities Count</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</main>
			
			<c:import url="/imports/mainFooter"></c:import>
		</div>

		<div class="hd-modals">
			<c:import url="/imports/modals/newRoleModal"></c:import>
		</div>

		<c:import url="/imports/scripts"></c:import>
		<script src="${app}/res/app/js/pages/admin/roles/index.js"></script>
	</body>
</html>