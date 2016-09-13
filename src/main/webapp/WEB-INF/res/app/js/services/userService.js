'use strict';

function UserService() {
	
}

/**
 * Gets information on currently logged in user
 * @returns a promise
 */
UserService.prototype.getCurrentUserData = function() {
	return $.ajax({
		url: APP_ROOT + '/api/users/' + Cookies.get('user'),
		method: 'get',
		data: {
			user: Cookies.get('user'),
			token: Cookies.get('token')
		},
		dataType: 'json'
	});
}
