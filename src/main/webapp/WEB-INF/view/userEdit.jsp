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
								<a class="btn btn-success js-hd-save-user-info-button" href="#">Save</a>
								<a class="btn btn-default" href="${app}/users/${username}">Cancel</a>
							</div>
						</h3>
					</div>
				</div>
			</header>
			<main>
				<div class="row">
					<section class="col-xs-6 col-sm-4">
						<div class="hd-ovelayed-img-container">
							<img class="js-hd-model-user-image hd-user-image-large" src="" />
							<aside class="hd-img-overlay" id="hd-change-user-image-button">
								Change Image
							</aside>
						</div>
					</section>
				</div>
				<div class="row">
					<form id="hd-user-edit-form">
						<input type="hidden" id="username" name="username" class="js-hd-model-user-username">
						<section class="col-sm-6">
							<header><h4>Information</h4></header>
							<div class="form-group">
								<label for="firstName">First Name</label>
								<input type="text" name="firstName" id="firstName" class="form-control js-hd-model-user-firstname" />
							</div>
							<div class="form-group">
								<label for="middleName">Middle Name</label>
								<input type="text" name="middleName" id="middleName" class="form-control js-hd-model-user-middlename" />
							</div>
							<div class="form-group">
								<label for="lastName">Last Name</label>
								<input type="text" name="lastName" id="lastName" class="form-control js-hd-model-user-lastname" />
							</div>
							<div class="form-group">
								<label for="email">E-mail</label>
								<input type="email" name="email" id="email" class="form-control js-hd-model-user-email" />
							</div>
							<div class="form-group">
								<label for="corporate-phone">Corporate Phone</label>
								<input type="text" name="corporate-phone" id="corporate-phone" class="form-control js-hd-model-user-corporate-number" />
							</div>
							<div class="form-group">
								<label for="linemanager">Line Manager</label>
								<select class="form-control js-hd-model-user-linemanagers" name="linemanager" id="linemanager">
									
								</select>
							</div>
						</section>
						
						<section class="col-sm-6">
							<header><h4>Personal Information</h4></header>
							<div class="form-group">
								<label for="birthday">Birthday</label>
								<input type="date" name="birthday" id="birthday" class="form-control js-hd-model-user-birthday">
							</div>
							<div class="form-group">
								<label for="personal-phone">Personal Phone</label>
								<input type="text" name="personal-phone" id="personal-phone" class="form-control js-hd-model-user-personal-phone" />
							</div>
							<div class="form-group">
								<label for="skype">Skype</label>
								<input type="text" name="skype" id="skype" class="form-control js-hd-model-user-skype" />
							</div>
						</section>
					</form>
				</div>
				<div class="btn-group pull-right">
					<a class="btn btn-success js-hd-save-user-info-button" href="#">Save</a>
					<a class="btn btn-default" href="${app}/users/${username}">Cancel</a>
				</div>
			</main>
			
			<c:import url="/imports/mainFooter"></c:import>
		</div>

		<div class="hd-modals">
			<c:import url="/imports/modals/userImageChangeModal"></c:import>
		</div>

		<c:import url="/imports/scripts"></c:import>
		<script src="${app}/res/app/js/pages/user/index.js"></script>
	</body>
</html>