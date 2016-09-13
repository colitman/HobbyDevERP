'use strict';

function MainTopNavModel() {
	this._currentUsername = "";
	this._currentFirstName = "";
	this._currentMiddleName = "";
	this._currentLastName = "";
}

MainTopNavModel.prototype.parse = function(data) {
	this._currentUsername = data.username;
	this._currentFirstName = data.userInfo.firstName;
	this._currentMiddleName = data.userInfo.middleName;
	this._currentLastName = data.userInfo.lastName;
}