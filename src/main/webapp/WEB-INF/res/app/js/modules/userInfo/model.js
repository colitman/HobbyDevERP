'use strict';

function UserInfoModel() {
	this._username = "";
	this._lineManager = {};
	this._subordinates = [];
	this._firstName = "";
	this._middleName = "";
	this._lastName = "";
	this._email = "";
	this._imageUrl = "";
	this._corporatePhoneNumber = "";
	this._startOfWork = "";
	
	this._lineManagers = [];
}

UserInfoModel.prototype.parse = function(data) {
	this._username = data.username;
	this._lineManager = data.lineManager;
	this._subordinates = data.subordinates;
		
	this._firstName = data.userInfo.firstName;
	this._middleName = data.userInfo.middleName;
	this._lastName = data.userInfo.lastName;
	this._email = data.userInfo.email;
	
	if(data.userInfo.imageUrl.indexOf('http') === 0) {
		this._imageUrl = data.userInfo.imageUrl;
	} else {
		this._imageUrl = APP_ROOT + data.userInfo.imageUrl;
	}
	
	this._corporatePhoneNumber = data.userInfo.corporatePhoneNumber;
	this._startOfWork = new Date(data.userInfo.startOfWork);
}