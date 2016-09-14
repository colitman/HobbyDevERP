'use strict';

function UserInfoController(model, view) {
	this._model = model;
	this._view = view;
	
	var _this = this;
	
	var userService = $root_scope.services.userService;
	if(userService) {
		userService.getUserData($('body').data('target'))
			.done(function(data, textStatus, jqXHR) {
				_this._model.parse(data);
				_this._view.update();
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown);
			})
	}
	
	var saveUserInfoButton = this._view._saveUserInfoButton;
	if(saveUserInfoButton) {
		saveUserInfoButton.click(function(event) {
			event.preventDefault();
			_this.updateUserInfo();
		});
	}
}

UserInfoController.prototype.updateUserInfo = function() {
	var form = this._view._userEditForm;
	var userInfo = new UserInfo(form);
	var userService = $root_scope.services.userService;
	if(userService) {
		userService.updateUser(userInfo)
			.done(function(data, textStatus, jqXHR) {
				window.location.replace(window.location.protocol + '//' + window.location.host + APP_ROOT + '/users/' + userInfo.username);
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown);
			})
	}
}

UserInfoController.prototype.getLineManagers = function() {
	var _this = this;
	var userService = $root_scope.services.userService;
	if(userService) {
		userService.getAllUsers()
			.done(function(data, textStatus, jqXHR) {
				_this._model._lineManagers = data;
				_this._view.update();
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown);
			})
	}
}