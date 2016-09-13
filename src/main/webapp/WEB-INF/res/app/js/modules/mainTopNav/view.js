'use strict';

function MainTopNavView(model) {
	this._model = model;
	
	this._currentUsername = $('.js-model-current-username');
	this._signoutLink = $('#hd-signout-link');
	this._signoutForm = $('#hd-signout-form');
}

MainTopNavView.prototype.update = function() {
	this.setCurrentUsername(this._model._currentUsername);
}

MainTopNavView.prototype.setCurrentUsername = function(username){
	this._currentUsername.each(function(index, item) {
		$(item).text(username);
	})
}