'use strict';

function MainTopNavModel() {
	this.username = '';
	this.fullName = '';
}

MainTopNavModel.prototype.parse = function(data) {
	this.username = data.username;
	
	var _fullName = '';
	_fullName += data.userInfo.firstName? data.userInfo.firstName + ' ':'';
	_fullName += data.userInfo.middleName? data.userInfo.middleName + ' ':'';
	_fullName += data.userInfo.lastName? data.userInfo.lastName:'';
	
	this.fullName = _fullName;
}