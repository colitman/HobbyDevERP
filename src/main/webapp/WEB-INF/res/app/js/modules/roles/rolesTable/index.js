'use strict';

$(document).ready(function() {
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_ROLES_PATH + 'rolesTable/model.js',
		loader.MODULE_ROLES_PATH + 'rolesTable/view.js',
		loader.MODULE_ROLES_PATH + 'rolesTable/controller.js'
	]);
	
	var rolesTableModel = new RolesTableModel();
	var rolesTableView = new RolesTableView(rolesTableModel);
	var rolesTableController = new RolesTableController(rolesTableModel, rolesTableView);
	
});
