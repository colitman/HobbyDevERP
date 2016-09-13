'use strict';

$(document).ready(function() {
	
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_MAIN_TOP_NAV_PATH + 'index.js',
		loader.MODULE_USER_INFO_PATH + 'index.js',
		loader.MODULE_USER_PERSONAL_INFO_PATH + 'index.js',
		loader.SERVICES_PATH + 'userService.js'
	]);
	
	var userService = new UserService();
	userService.getCurrentUserData()
		.done(function(data, textStatus, jqXHR) {
			$root_scope.currentUser = data;
			updateAllModels();
		})
		.fail(function(jqXHR, textStatus, errorThrown) {
			alert(errorThrown);
		})
	
});
