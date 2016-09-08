'use strict';

/**
 * Loads script files to page
 * @param scripts - array of script paths relative to <b>APP_ROOT/res/app/js/</b>
 */
function loadScripts(scripts) {
	for(var i = 0; i < scripts.length; i++) {
		$('script:last-of-type').after('<script src="' + APP_ROOT + '/res/app/js/' + scripts[i] + '"></script>');
	}
}