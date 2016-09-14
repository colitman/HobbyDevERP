'use strict';

$(document).ready(function() {
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_USER_INFO_PATH + 'model.js',
		loader.MODULE_USER_INFO_PATH + 'view_edit.js',
		loader.MODULE_USER_INFO_PATH + 'controller.js'
	]);
	
	var userInfoModel = new UserInfoModel();
	var userInfoView = new UserInfoEditView(userInfoModel);
	var userInfoController = new UserInfoController(userInfoModel, userInfoView);
	
	userInfoController.getLineManagers();
});
