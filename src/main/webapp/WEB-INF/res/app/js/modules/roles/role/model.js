'use strict';

function RoleModel() {
	this._key = "";
	this._name = "";
	this._description = "";
	this._users = [];
	this._authorities = [];
}

RoleModel.prototype.parse = function(data) {
	this._key = data.key;
	this._name = data.name;
	this._description = data.description;
	this._users = data.users;
	this._authorities = data.authorities;
}