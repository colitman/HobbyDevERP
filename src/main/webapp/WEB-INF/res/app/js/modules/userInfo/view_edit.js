'use strict';

function UserInfoEditView(model) {
	this._model = model;
	
	this._saveUserInfoButton = $('.js-hd-save-user-info-button');
	this._userEditForm = $('#hd-user-edit-form');
	
	this._username = $('.js-hd-model-user-username');
	this._fullName = $('.js-hd-model-user-fullname');
	this._firstName = $('.js-hd-model-user-firstname');
	this._middleName = $('.js-hd-model-user-middlename');
	this._lastName = $('.js-hd-model-user-lastname');
	this._email = $('.js-hd-model-user-email');
	this._corporatePhoneNumber = $('.js-hd-model-user-corporate-number');
	this._lineManager = $('.js-hd-model-user-linemanager');
	this._image = $('.js-hd-model-user-image');
}

UserInfoEditView.prototype.update = function() {
	this.setFullName(this._model._firstName, this._model._lastName, this._model._middleName);
	this.setImage(this._model._imageUrl);
	this.setManagersList(this._model._lineManagers);
	this.setSelectedManager(this._model._lineManager);
	
	this.setValue(this._username, this._model._username);
	this.setValue(this._firstName, this._model._firstName);
	this.setValue(this._middleName, this._model._middleName);
	this.setValue(this._lastName, this._model._lastName);
	this.setValue(this._email, this._model._email);
	this.setValue(this._corporatePhoneNumber, this._model._corporatePhoneNumber);
}

UserInfoEditView.prototype.setSelectedManager = function(manager) {
	if(!manager) {
		return;
	}
	$('option[value="' + manager.key + '"]', this._lineManager).prop('selected', true);
}

UserInfoEditView.prototype.setManagersList = function(managers) {
	this._lineManager.each(function(index, item) {
		$(item).html('<option value="">No manager</option>');
		console.log(index + ' run of manager options');
		for(var i = 0; i < managers.length; i++) {
			var manager = managers[i];
			var option = $(document.createElement('option'));
			option.val(manager.key);
			option.text(manager.firstName + ' ' + manager.lastName);
			$(item).append(option);
		}
	});
}

UserInfoEditView.prototype.setFullName = function(firstName, lastName, middleName){
	var fullName = '';
	fullName += firstName? firstName + ' ':'';
	fullName += middleName? middleName + ' ':'';
	fullName += lastName? lastName:'';
	
	this._fullName.each(function(index, item) {
		$(item).text(fullName);
	});
}

UserInfoEditView.prototype.setImage = function(url){
	this._image.each(function(index, item) {
		$(item).attr('src', url);
	});
}

UserInfoEditView.prototype.setValue = function(property, value){
	property.each(function(index, item) {
		$(item).val(value);
	});
}