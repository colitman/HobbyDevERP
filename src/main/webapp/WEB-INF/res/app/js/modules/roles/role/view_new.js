'use strict';

function RoleNewView(model) {
	this._model = model;
	
	this._addNewButton = $('#hd-add-new-role-button');
	this._newRoleModal = $('#hd-modal-new-role');
	
	this._newRoleForm = $('#hd-new-role-form');
	
	this._saveNewButton = $('#hd-save-new-role-button');
}

RoleNewView.prototype.update = function() {
}