'use strict';

function RolesTableModel() {
	this._roles = [];
}

RolesTableModel.prototype.parse = function(data) {
	this._roles = data;
}