'use strict';

$(document).ready(function() {
	
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_MAIN_TOP_NAV_PATH + 'index.js',
		loader.SERVICES_PATH + 'userService.js'
	]);
	
	$root_scope.services.userService = new UserService();
});
