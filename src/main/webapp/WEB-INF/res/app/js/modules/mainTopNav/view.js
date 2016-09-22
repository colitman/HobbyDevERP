'use strict';

function MainTopNavView(model) {
	this._model = model;
	
	this.username = $('.js-hd-model-current-username');
	this.fullName = $('.js-hd-model-current-fullname');
	
	this._signoutLink = $('#hd-signout-link');
	this._signoutForm = $('#hd-signout-form');
}

MainTopNavView.prototype = Object.create(View.prototype);