'use strict';

function UserPersonalInfoView(model) {
	this._model = model;
	
	this._birthday = $('.js-hd-model-user-birthday');
	this._personalPhoneNumber = $('.js-hd-model-user-personal-phone');
	this._skype = $('.js-hd-model-user-skype');
}

UserPersonalInfoView.prototype.update = function() {
	this.setDate(this._birthday, this._model._birthday);
	this.setValue(this._personalPhoneNumber, this._model._personalPhoneNumber);
	this.setValue(this._skype, this._model._skype);
}

UserPersonalInfoView.prototype.setDate = function(property, value) {
	if(!value) {
		return;
	}
	
	var dateString = value.toLocaleString('en-US', {
		month:'short',
		day: 'numeric',
		year: 'numeric'
	})
	
	property.each(function(index, item) {
		$(item).text(dateString);
	});
}

UserPersonalInfoView.prototype.setValue = function(property, value){
	property.each(function(index, item) {
		$(item).text(value);
	});
	
}