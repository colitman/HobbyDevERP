'use strict';

function ScriptLoader() {
	this.JS_ROOT = APP_ROOT + '/res/app/js/';
}

ScriptLoader.prototype.MODULE_MAIN_TOP_NAV_PATH = 'modules/mainTopNav/';
ScriptLoader.prototype.MODULE_USER_INFO_PATH = 'modules/userInfo/';
ScriptLoader.prototype.MODULE_USER_PERSONAL_INFO_PATH = 'modules/userPersonalInfo/';

ScriptLoader.prototype.PAGE_ROOT_PATH = 'pages/root/';

ScriptLoader.prototype.SERVICES_PATH = 'services/';

/**
 * Loads script files to page
 * @param scripts - array of script paths relative to <b>APP_ROOT/res/app/js/</b>
 */
ScriptLoader.prototype.load = function(paths) {
	for(var i = 0; i < paths.length; i++) {
		$('script:last-of-type').after('<script src="' + this.JS_ROOT + paths[i] + '"></script>');
	}
}