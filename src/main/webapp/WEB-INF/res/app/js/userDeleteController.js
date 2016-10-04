'use strict';

var SUBJECT = '';
var FORM = $('#hd-delete-form');

$('.js-hd-delete-user-btn').each(function(index, item) {
	$(item).click(function(event) {
		event.preventDefault();
		
		var deleteKey = $(item).data('key');
		SUBJECT = '<b>' + $(item).data('name') + '</b> user';
		
		$('#hd-delete-subject').html(SUBJECT);
		
		FORM.attr('action', APP_ROOT + '/admin/users/' + deleteKey);
		FORM.append('<input type="hidden" name="isDeleted" value="true">');
		
	});
});