'use strict';

function RolesTableController(model, view) {
	this._model = model;
	this._view = view;
	
	var _this = this;
	
	var roleService = $root_scope.services.roleService;
	if(roleService) {
		roleService.getAllRoles()
			.done(function(data, textStatus, jqXHR) {
				_this._model.parse(data);
				_this._view.update();
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown);
			})
	}
}

