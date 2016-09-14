'use strict';

function UserPersonalInfoEditView(model) {
	this._model = model;
	
	this._birthday = $('.js-hd-model-user-birthday');
	this._personalPhoneNumber = $('.js-hd-model-user-personal-phone');
	this._skype = $('.js-hd-model-user-skype');
}

UserPersonalInfoEditView.prototype.update = function() {
	this.setDate(this._birthday, this._model._birthday);
	this.setValue(this._personalPhoneNumber, this._model._personalPhoneNumber);
	this.setValue(this._skype, this._model._skype);
}

UserPersonalInfoEditView.prototype.setDate = function(property, value) {
	if(!value) {
		return;
	}
	
	/*var dateString = value.toLocaleString('en-US', {
		year: 'numeric',
		month:'2-digit',
		day: 'numeric'
	})*/
	
	var year = value.getFullYear();
	var month = value.getMonth() + 1;
	var day = value.getDate();
	
	if(month < 10) {
		month = '0' + month;
	}
	
	if(day < 10) {
		day = '0' + day;
	}
	
	var dateString = year + '-' + month + '-' + day;
	
	property.each(function(index, item) {
		$(item).val(dateString);
	});
}

UserPersonalInfoEditView.prototype.setValue = function(property, value){
	property.each(function(index, item) {
		$(item).val(value);
	});
}