'use strict';

function MainTopNavModel() {
	this._currentUsername = $('.js-model-current-username');
	
	this._signoutForm = $('#hd-signout-form');
	this._signoutLink = $('#js-hd-logout-link');
}

MainTopNavModel.prototype.update = function() {
	this.setCurrentUsername($root_scope.currentUser.username)
}

MainTopNavModel.prototype.setCurrentUsername = function(username) {
	this._currentUsername.each(function(index, item) {
		$(item).text(username);
	});
}