<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:set var="app" value="${pageContext.servletContext.contextPath}" />

<aside class="modal fade" id="hd-modal-user-image-change">
	<div class="modal-dialog">
		<div class="modal-content">
			<header class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title">Change Profile Image</h4>
			</header>
			<div class="modal-body">
				<form id="hd-user-image-change-form">
					<div class="radio">
						<label>
							<input type="radio" name="image-option" id="url-option" checked="checked">
							URL
						</label>
					</div>
					<input type="url" name="url" id="url" class="form-control js-hd-model-user-image">
					<div class="radio">
						<label>
							<input type="radio" name="image-option" id="file-option">
							Upload file
						</label>
					</div>
					<input type="file" name="file" id="file">
				</form>
			</div>
			<footer class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="hd-save-user-image-button">Save</button>
			</footer>
		</div>
	</div>
</aside>