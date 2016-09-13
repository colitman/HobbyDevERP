'use strict';

$(document).ready(function() {
	
	var loader = new ScriptLoader();
	
	loader.load([
		loader.MODULE_MAIN_TOP_NAV_PATH + 'model.js',
		loader.MODULE_MAIN_TOP_NAV_PATH + 'view.js',
		loader.MODULE_MAIN_TOP_NAV_PATH + 'controller.js'
	]);
	
	
	var mainTopNavModel = new MainTopNavModel();
	var mainTopNavView = new MainTopNavView(mainTopNavModel);
	var mainTopNavController = new MainTopNavController(mainTopNavModel, mainTopNavView);
});
