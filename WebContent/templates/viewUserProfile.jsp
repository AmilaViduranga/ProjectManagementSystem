<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <div class="panel panel-default">
	  <div class="panel-heading clearfix">
	  		<i class="fa fa-user pull-left"></i>
	    	<h3 class="panel-title pull-left">View Profile</h3>
	      	<a class="btn btn-primary pull-right" href="#" id="userEdit">
		        <i class="fa fa-pencil"></i>
		        Edit
	      	</a>
	  </div>
	  <div class="list-group" id="profileContent">
	      <div class="list-group-item">
	        	<p class="list-group-item-text">User Name(ID Number)</p>
	        	<h4 class="list-group-item-heading">..value..</h4>
	      </div>
	      <div class="list-group-item">
	        	<p class="list-group-item-text">User email</p>
	        	<h4 class="list-group-item-heading">..value..</h4>
	      </div>
	      <div class="panel panel-default bootcards-media">
		  	<img src="http://www.teamstudio.com/Portals/218295/images/istock_000001242290small.jpg" class="img-responsive" style="height:350px; width:350px;"/>
		  </div>
	</div>
</div>
 
 <script type="text/javascript">
	$('a#userEdit').click(function() {
		var page = $(this).attr('href');
		$('#userProfile').load('templates/editUserProfile.jsp');
		return false;
	});
</script>