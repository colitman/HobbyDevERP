'use strict';

function UserInfoView(model) {
	this._model = model;
	
	this._fullName = $('.js-hd-model-user-fullname');
	this._username = $('.js-hd-model-user-username');
	this._lineManager = $('.js-hd-model-user-linemanager');
	this._subordinatesCount = $('.js-hd-model-user-subs-count');
	this._firstName = $('.js-hd-model-user-firstname');
	this._middleName = $('.js-hd-model-user-middlename');
	this._lastName = $('.js-hd-model-user-lastname');
	this._email = $('.js-hd-model-user-email');
	this._image = $('.js-hd-model-user-image');
	this._corporatePhoneNumber = $('.js-hd-model-user-corporate-number');
	this._startOfWork = $('.js-hd-model-user-start-of-work');
}

UserInfoView.prototype.update = function() {
	this.setFullName(this._model._firstName, this._model._lastName, this._model._middleName);
	this.setImage(this._model._imageUrl);
	this.setDate(this._startOfWork, this._model._startOfWork);
	this.setUserLink(this._lineManager, this._model._lineManager)
	this.setValue(this._subordinatesCount, this._model._subordinates.length);
	this.setValue(this._username, this._model._username);
	this.setValue(this._firstName, this._model._firstName);
	this.setValue(this._middleName, this._model._middleName);
	this.setValue(this._lastName, this._model._lastName);
	this.setValue(this._email, this._model._email);
	this.setValue(this._corporatePhoneNumber, this._model._corporatePhoneNumber);
}

UserInfoView.prototype.setUserLink = function(property, user) {
	if(!user) {
		return;
	}
	
	var a = $(document.createElement('a'));
	a.attr('href', APP_ROOT + '/users/' + user.username);
	a.text(user.username);
	
	property.each(function(index, item) {
		$(item).html(a);
	});
}

UserInfoView.prototype.setDate = function(property, value) {
	var dateString = value.toLocaleString('en-US', {
		month:'short',
		day: 'numeric',
		year: 'numeric'
	})
	
	property.each(function(index, item) {
		$(item).text(dateString);
	});
}

UserInfoView.prototype.setFullName = function(firstName, lastName, middleName){
	var fullName = '';
	fullName += firstName? firstName + ' ':'';
	fullName += middleName? middleName + ' ':'';
	fullName += lastName? lastName:'';
	
	this._fullName.each(function(index, item) {
		$(item).text(fullName);
	});
	
}

UserInfoView.prototype.setImage = function(url){
	this._image.each(function(index, item) {
		$(item).attr('src', APP_ROOT + url);
	});
	
}

UserInfoView.prototype.setValue = function(property, value){
	property.each(function(index, item) {
		$(item).text(value);
	});
	
}