'use strict';

function RoleController(model, view) {
	this._model = model;
	this._view = view;
	
	var _this = this;
	
	var roleService = $root_scope.services.roleService;
	if(roleService) {
		var targetRole = $('body').data('target');
		if(targetRole) {
			roleService.getRoleData(targetRole)
				.done(function(data, textStatus, jqXHR) {
					_this._model.parse(data);
					_this._view.update();
				})
				.fail(function(jqXHR, textStatus, errorThrown) {
					alert(errorThrown);
				})
		}
	}
	
	var addNewRoleButton = this._view._addNewButton;
	if(addNewRoleButton) {
		addNewRoleButton.click(function(event) {
			_this._view._newRoleModal.modal('show');
		});
	}
	
	var saveNewRoleButton = this._view._saveNewButton;
	if(saveNewRoleButton) {
		saveNewRoleButton.click(function(event) {
			_this.saveNewRole();
		});
	}
}

RoleController.prototype.saveNewRole = function() {
	var form = this._view._newRoleForm;
	
	var roleInfo = {
		name:$('#name', form).val(),
		description:$('#description', form).val()
	}
	
	var roleService = $root_scope.services.roleService;
	
	if(roleService) {
		roleService.saveNewRole(roleInfo)
			.done(function(data, textStatus, jqXHR) {
				window.location.replace(window.location.protocol + '//' + window.location.host + APP_ROOT + '/admin/roles');
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				alert(errorThrown);
			})
	}
}