'use strict'

function View(model) {
	this._model = model;
}

View.prototype.update = function() {
	var viewElements = Object.keys(this);
	
	for(var i in viewElements) {
		var viewElement = viewElements[i];
		if(viewElement.indexOf('_') === 0 || viewElement.indexOf('$') === 0) {
			continue;
		}
		this.setValue(this[viewElement], this._model[viewElement])
	}
}

View.prototype.setValue = function(property, value) {
	
	var _this = this;
	
	if(!value) {
		return;
	}
	
	if(!property) {
		return;
	}
	
	property.each(function(index, item) {
		if($(item).is('input')) {
			if($(item).attr('type') === 'date') {
				var dateValue = _this.formatDateForInput(value.content);
				$(item).val(dateValue);
			} else {
				$(item).val(value);
			}
		} else if ($(item).is('span')) {
			if(value.isDate) {
				var dateValue = _this.formatDateForSpan(value.content);
				$(item).text(dateValue);
			} else {
				$(item).text(value);
			}
		} else if($(item).is('img')) {
			if(value.indexOf('http') === 0) {
				$(item).attr('src', value);
			} else {
				$(item).attr('src', APP_ROOT + value);
			}
		} else if($(item).is('a')) {
			$(item).attr('href', $(item).attr('href') + value.ref);
			$(item).text(value.content);
		} else if($(item).is('select')) {
			$(item).html('<option value="">Select</option>');
			for(var i = 0; i < value.length; i++) {
				var option = value[i];
				var optionElement = $(document.createElement('option'));
				optionElement.val(option.key);
				optionElement.text(option.content);
				optionElement.prop('selected', option.isSelected);
				$(item).append(optionElement);
			}
		}
	});
}

View.prototype.formatDateForSpan = function(date) {
	if(!date) {
		return 'as';
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