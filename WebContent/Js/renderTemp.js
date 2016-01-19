/**
 * 
 */

$('div#groupList a.list-group-item').click(function() {
	var page = $(this).attr('href');
	$('#content').load('templates/.jsp');
	return false;
});