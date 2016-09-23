'use strict';

function UserInfoView(model) {
	this._model = model;
	
	this.fullName = $('.js-hd-model-user-fullname');
	this.username = $('.js-hd-model-user-username');
	this.lineManager = $('.js-hd-model-user-linemanager');
	this.lineManagers = $('.js-hd-model-user-linemanagers');
	this.subordinates = $('.js-hd-model-user-subs-count');
	this.firstName = $('.js-hd-model-user-firstname');
	this.middleName = $('.js-hd-model-user-middlename');
	this.lastName = $('.js-hd-model-user-lastname');
	this.email = $('.js-hd-model-user-email');
	this.image = $('.js-hd-model-user-image');
	this.corporatePhoneNumber = $('.js-hd-model-user-corporate-number');
	this.startOfWork = $('.js-hd-model-user-start-of-work');
	
	this.personalPhoneNumber = $('.js-hd-model-user-personal-phone');
	this.skype = $('.js-hd-model-user-skype');
	this.birthday = $('.js-hd-model-user-birthday');
	
	//~========= Forms, modals, etc.
	this.$userEditForm = $('#hd-user-edit-form');
	this.$changeImageModal = $('#hd-modal-user-image-change');
	
	//~========= Controls
	this.$changeImageButton = $('#hd-change-user-image-button');
	this.$saveImageButton = $('#hd-save-user-image-button');
	this.$saveUserInfoButton = $('.js-hd-save-user-info-button');
}

UserInfoView.prototype = Object.create(View.prototype);