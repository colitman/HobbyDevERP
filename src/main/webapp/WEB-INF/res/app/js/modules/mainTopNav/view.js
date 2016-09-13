'use strict';

function MainTopNavView(model) {
	this._model = model;
	
	this._currentUsername = $('.js-hd-model-current-username');
	this._currentFullName = $('.js-hd-model-current-fullname');
	
	this._signoutLink = $('#hd-signout-link');
	this._signoutForm = $('#hd-signout-form');
}

MainTopNavView.prototype.update = function() {
	this.setCurrentUsername(this._model._currentUsername);
	this.setCurrentFullName(this._model._currentFirstName, this._model._currentLastName, this._model._currentMiddleName);
}

MainTopNavView.prototype.setCurrentUsername = function(username){
	this._currentUsername.each(function(index, item) {
		$(item).text(username);
	});
}

MainTopNavView.prototype.setCurrentFullName = function(firstName, lastName, middleName){
	var fullName = '';
	fullName += firstName? firstName + ' ':'';
	fullName += middleName? middleName + ' ':'';
	fullName += lastName? lastName:'';
	
	this._currentFullName.each(function(index, item) {
		$(item).text(fullName);
	});
		
}