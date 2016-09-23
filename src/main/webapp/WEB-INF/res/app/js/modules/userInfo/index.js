'use strict';

$(document).ready(function() {
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODELS_PATH + 'userInfo.js',
		loader.MODULE_USER_INFO_PATH + 'model.js',
		loader.MODULE_USER_INFO_PATH + 'view.js',
		loader.MODULE_USER_INFO_PATH + 'controller.js'
	]);
	
	var userInfoModel = new UserInfoModel();
	var userInfoView = new UserInfoView(userInfoModel);
	var userInfoController = new UserInfoController(userInfoModel, userInfoView);
	
});
