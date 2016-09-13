'use strict';

$(document).ready(function() {
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_USER_PERSONAL_INFO_PATH + 'controller.js',
		loader.MODULE_USER_PERSONAL_INFO_PATH + 'model.js'
	]);
	
	var userPersonalInfoModel = new UserPersonalInfoModel();
	var userPersonalInfoController = new UserPersonalInfoController(userPersonalInfoModel);
	$page_scope.controllers.push(userPersonalInfoController);
});
