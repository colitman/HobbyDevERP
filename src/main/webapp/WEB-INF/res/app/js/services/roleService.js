'use strict';

function RoleService() {
	
}

RoleService.prototype.getAllRoles = function(){
	return $.ajax({
		url: APP_ROOT + '/api/roles',
		method: 'get',
		data: {
			user: Cookies.get('user'),
			token: Cookies.get('token')
		},
		dataType: 'json'
	})
}

RoleService.prototype.saveNewRole = function(roleInfo) {
	return $.ajax({
		url: APP_ROOT + '/api/roles',
		method: 'post',
		data: {
			name:roleInfo.name,
			description:roleInfo.description,
			user:Cookies.get('user'),
			token:Cookies.get('token')
		},
		//data: JSON.stringify(roleInfo),
		//contentType: "application/json"
	});
}