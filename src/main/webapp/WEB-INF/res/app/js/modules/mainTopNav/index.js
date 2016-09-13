'use strict';

$(document).ready(function() {
	
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_MAIN_TOP_NAV_PATH + 'controller.js',
		loader.MODULE_MAIN_TOP_NAV_PATH + 'model.js'
	]);
	
	var mainTopNavModel = new MainTopNavModel();
	var mainTopNavController = new MainTopNavController(mainTopNavModel);
	$page_scope.controllers.push(mainTopNavController);
});
