<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="en">
	<head>
		<c:import url="/imports/head?pageTitle=${role.name}"></c:import>
	</head>
	
	<body data-page="role" data-target="${role.key}">
		<div class="container">
			<c:import url="/imports/mainNav?root=false"></c:import>
			<header class="hd-main-header">
				<div class="row">
					<div class="col-sm-6">
						<h3>${role.name}</h3>
						${role.description}
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
						<h2>
							Authorities
							<div class="btn-group pull-right">
								<a class="btn btn-success js-hd-save-role-authorities-button"
										href="#"
										data-target="#hd-role-authorities">Save</a>
							</div>
						</h2>
						
						<div class="row" id="hd-role-authorities">
							<c:forEach items="${authorityMatrix}" var="authority">
								<div class="col-xs-12 col-sm-4 col-md-3">
									<c:set value="${fn:contains(role.authorities, authority) }" var="checked"></c:set>
									<div class="checkbox">
										<label>
											<input type="checkbox" name="authority" id="authority" value="${authority}" ${checked? "checked":""}>
											${authority}
										</label>
									</div>
								</div>
							</c:forEach>
						</div>
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
		<script>
			$('.js-hd-save-role-authorities-button').click(function(event) {
				event.preventDefault();
				var target = $(this).data('target');
				var authoritiesString = '';
				$('input[name="authority"]', target).each(function(index, item){
					var isSelected = $(this).prop('checked');
					if(isSelected) {
						authoritiesString += $(this).val();
						authoritiesString += ',';
					}
				});
				alert(authoritiesString);
				
				$.ajax({
					url:APP_ROOT + '/admin/roles/' + $('body').data('target'),
					type:'put',
					data:'authorities=' + authoritiesString
				}).done(function(data){
					console.log('Success!');
				}).fail(function(){
					console.log('Fail!');
				});
			});
		</script>
	</body>
</html>