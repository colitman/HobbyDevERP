'use strict';

$('#js-hd-logout-link').click(function(event) {
	event.preventDefault();
	$('#hd-signout-form').submit();
});