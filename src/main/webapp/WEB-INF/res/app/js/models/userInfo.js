'use strict';

function UserInfo(form) {
	var info = {
		username:"",
		firstName:"",
		middleName:"",
		lastName:"",
		email:"",
		corporatePhoneNumber:"",
		lineManager:-1,
		birthday:0,
		phoneNumber:"",
		skypeName:""
	};
	
	Object.seal(info);
	
	info.username = $('#username', form).val();
	info.firstName = $('#firstName', form).val();
	info.middleName = $('#middleName', form).val();
	info.lastName = $('#lastName', form).val();
	info.email = $('#email', form).val();
	info.corporatePhoneNumber = $('#corporate-phone', form).val();
	info.lineManager = $('#linemanager', form).val();
	info.birthday = new Date($('#birthday', form).val()).getTime();
	info.phoneNumber = $('#personal-phone', form).val();
	info.skypeName = $('#skype', form).val();
	
	return info;
}