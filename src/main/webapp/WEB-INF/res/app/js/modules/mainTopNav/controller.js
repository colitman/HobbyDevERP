'use strict';

function MainTopNavController(model) {
	this._model = model;
	
	var _this = this;
	
	this._model._signoutLink.click(function(event) {
		event.preventDefault();
		_this._model._signoutForm.submit();
	});
}