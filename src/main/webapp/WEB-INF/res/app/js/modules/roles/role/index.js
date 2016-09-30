'use strict';

$(document).ready(function() {
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_ROLES_PATH + 'role/model.js',
		loader.MODULE_ROLES_PATH + 'role/view.js',
		loader.MODULE_ROLES_PATH + 'role/controller.js'
	]);
	
	var roleModel = new RoleModel();
	var roleView = new RoleView(roleModel);
	var roleController = new RoleController(roleModel, roleView);
	
});