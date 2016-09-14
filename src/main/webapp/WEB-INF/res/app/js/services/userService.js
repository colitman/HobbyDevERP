'use strict';

function UserService() {
	
}

/**
 * Gets information on currently logged in user
 * @returns a promise
 */
UserService.prototype.getCurrentUserData = function() {
	return this.getUserData(Cookies.get('user'));
}

/**
 * Gets information on user with provided username
 * @returns a promise
 */
UserService.prototype.getUserData = function(username) {
	return $.ajax({
		url: APP_ROOT + '/api/users/' + username,
		method: 'get',
		data: {
			user: Cookies.get('user'),
			token: Cookies.get('token')
		},
		dataType: 'json'
	});
}

/**
 * Gets a collection of all users common information
 * @returns a promise
 */
UserService.prototype.getAllUsers = function() {
	return $.ajax({
		url: APP_ROOT + '/api/users',
		method: 'get',
		data: {
			user: Cookies.get('user'),
			token: Cookies.get('token')
		},
		dataType: 'json'
	});
}

/**
 * Updates a user
 * @param userInfo
 */
UserService.prototype.updateUser = function(userInfo) {
	return $.ajax({
		url: APP_ROOT + '/api/users/' + userInfo.username + '?user=' + Cookies.get('user') + '&token=' + Cookies.get('token'),
		method: 'put',
		data: JSON.stringify(userInfo),
		contentType: "application/json"
	});
}