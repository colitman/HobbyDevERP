'use strict';

$(document).ready(function() {
	
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_MAIN_TOP_NAV_PATH + 'index.js',
		loader.MODULE_ROLES_PATH + 'rolesTable/index.js',
		loader.SERVICES_PATH + 'userService.js',
		loader.SERVICES_PATH + 'roleService.js'
	]);
	
	$root_scope.services.userService = new UserService();
	$root_scope.services.roleService = new RoleService();
});
