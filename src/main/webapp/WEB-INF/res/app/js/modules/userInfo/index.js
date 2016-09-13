'use strict';

$(document).ready(function() {
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_USER_INFO_PATH + 'controller.js',
		loader.MODULE_USER_INFO_PATH + 'model.js'
	]);
	
	var userInfoModel = new UserInfoModel();
	var userInfoController = new UserInfoController(userInfoModel);
	$page_scope.controllers.push(userInfoController);
});
