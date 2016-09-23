'use strict';

function UserInfoModel() {
	this.username = '';
	this.lineManager = {};
	this.lineManagers = [];
	this.subordinates = 0;
	this.firstName = '';
	this.middleName = '';
	this.lastName = '';
	this.fullName = '';
	this.email = '';
	this.image = '';
	this.corporatePhoneNumber = '';
	this.personalPhoneNumber = '';
	this.skype = '';
	this.startOfWork = {isDate:true};
	this.birthday = null;
}

UserInfoModel.prototype.parse = function(data) {
	this.username = data.username;
	
	this.lineManager = data.lineManager;
	if(this.lineManager) {
		this.lineManager.content = data.lineManager.userInfo.firstName + ' ' + data.lineManager.userInfo.lastName;
		this.lineManager.ref = data.lineManager.username;
	}
	
	this.subordinates = data.subordinates.length;
		
	this.firstName = data.userInfo.firstName;
	this.middleName = data.userInfo.middleName;
	this.lastName = data.userInfo.lastName;
	
	var _fullName = '';
	_fullName += data.userInfo.firstName? data.userInfo.firstName + ' ':'';
	_fullName += data.userInfo.middleName? data.userInfo.middleName + ' ':'';
	_fullName += data.userInfo.lastName? data.userInfo.lastName:'';
	
	this.fullName = _fullName;
	
	this.email = data.userInfo.email;
	this.image = data.userInfo.imageUrl;
	this.corporatePhoneNumber = data.userInfo.corporatePhoneNumber;
	this.personalPhoneNumber = data.personalInfo.phoneNumber;
	this.skype = data.personalInfo.skypeName;
	
	if(data.userInfo.startOfWork) {
		this.startOfWork.content = new Date(data.userInfo.startOfWork);
	}
	
	if(data.personalInfo.birthday) {
		this.birthday = {
			content:new Date(data.personalInfo.birthday),
			isDate:true
		}
	}
}