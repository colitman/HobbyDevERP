'use strict';

var $root_scope = {};
var $page_scope = {
	controllers:[]
};

$(document).ready(function() {
	
});

function updateAllModels() {
	var ctrls = $page_scope.controllers;
	for(var i = 0; i < ctrls.length; i++) {
		ctrls[i]._model.update();
	}
}