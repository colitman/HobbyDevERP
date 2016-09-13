'use strict';

function UserPersonalInfoModel() {
	this._birthday = '';
	this._personalPhoneNumber = '';
	this._skype = '';
}

UserPersonalInfoModel.prototype.parse = function(data) {
	this._birthday = new Date(data.personalInfo.birthday);
	this._personalPhoneNumber = data.personalInfo.phoneNumber;
	this._skype = data.personalInfo.skypeName;
}