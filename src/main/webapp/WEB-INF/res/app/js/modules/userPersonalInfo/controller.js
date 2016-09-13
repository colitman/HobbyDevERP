'use strict';

function UserPersonalInfoController(model, view) {
	this._model = model;
	this._view = view;
	
	var _this = this;
	
	var userService = $root_scope.services.userService;
	if(userService) {
		userService.getCurrentUserData()
			.done(function(data, textStatus, jqXHR) {
				_this._model.parse(data);
				_this._view.update();
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown);
			})
	}
}