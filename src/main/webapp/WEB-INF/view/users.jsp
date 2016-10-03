<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<c:import url="/imports/head?pageTitle=Users"></c:import>
	</head>
	
	<body data-page="users">
		<div class="container">
			<c:import url="/imports/mainNav?root=false"></c:import>
			<header class="hd-main-header">
				<div class="row">
					<div class="col-sm-6">
						<h3>Users</h3>
					</div>
				</div>
			</header>
			<main>
				<div class="row">
					<button type="button" id="hd-add-new-role-button" data-toggle="modal" data-target="#hd-modal-new-role" class="btn btn-success pull-right">Add User</button>
				</div>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="user" >
								<tr>
									<td>
										${user.key}
									</td>
									<td>
										<a href="${app}/users/${user.username}">${user.userInfo.firstName += " " += user.userInfo.lastName}</a>
									</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</main>
			
			<c:import url="/imports/mainFooter"></c:import>
		</div>

		<div class="hd-modals">
		</div>

		<c:import url="/imports/scripts"></c:import>
	</body>
</html>