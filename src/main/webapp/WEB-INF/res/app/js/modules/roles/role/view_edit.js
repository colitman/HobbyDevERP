'use strict';

function RoleEditView(model) {
	this._model = model;
	
	this._name = $('.js-hd-model-role-name');
	this._description = $('.js-hd-model-role-description');
}

RoleEditView.prototype.update = function() {
	this.setValue(this._name, this._model._name);
	this.setValue(this._description, this._model._description);
}

RoleEditView.prototype.setValue = function(property, value){
	
	property.each(function(index, item) {
		$(item).text(value);
	});
}