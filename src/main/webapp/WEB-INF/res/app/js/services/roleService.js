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