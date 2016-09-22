'use strict'

function View(model) {
	this._model = model;
}

View.prototype.update = function() {
	var viewElements = Object.keys(this);
	
	//var viewElement;
	
	for(var i in viewElements) {
		var viewElement = viewElements[i];
		if(viewElement.indexOf('_') === 0) {
			continue;
		}
		this.setValue(this[viewElement], this._model[viewElement])
	}
}

View.prototype.setValue = function(property, value) {
	if(property.is('input')) {
		property.each(function(index, item) {
			if(property.attr('type') === 'date') {
				var dateValue = this.formatDateForInput(value);
				$(item).val(dateValue);
			} else {
				$(item).val(value);
			}
		});
	} else if (property.is('span')) {
		property.each(function(index, item) {
			if(value.isDate) {
				var dateValue = this.formatDateForSpan(value);
				$(item).text(dateValue);
			} else {
				$(item).text(value);
			}
		});
	} else if(property.is('img')) {
		property.each(function(index, item) {
			$(item).attr('src', value);
		});
	} else if(property.is('a')) {
		property.each(function(index, item) {
			$(item).attr('href', $(item).attr('href') + value);
			$(item).text(value);
		});
	} else if(property.is('select')) {
		property.each(function(index, item) {
			$(item).html('<option value="">Select</option>');
			for(var i = 0; i < value.length; i++) {
				var option = value[i];
				var optionElement = $(document.createElement('option'));
				optionElement.val(option.key);
				optionElement.text(option.name);
				optionElement.prop('selected', option.isSelected);
				$(item).append(optionElement);
			}
		});
	}
}

View.prototype.formatDateForSpan = function(date) {
	if(!date) {
		return '';
	}
	
	var dateString = date.toLocaleString('en-US', {
		month:'short',
		day: 'numeric',
		year: 'numeric'
	})
	
	return dateString;
}

View.prototype.formatDateForInput = function(date) {
	if(!date) {
		return '';
	}
	
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	
	if(month < 10) {
		month = '0' + month;
	}
	
	if(day < 10) {
		day = '0' + day;
	}
	
	var dateString = year + '-' + month + '-' + day;
	return dateString;
}