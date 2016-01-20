<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<div class="panel panel-default">
	  <div class="panel-heading clearfix">
	    <h3 class="panel-title pull-left">Group Name</h3>
	      <a class="btn btn-primary pull-right" href="#" id="groupEdit">
	        <i class="fa fa-pencil"></i>
	        Edit
	      </a>
	    </div>
	    <div class="list-group">
	      <div class="list-group-item">
	        <p class="list-group-item-text">Group NO</p>
	        <h4 class="list-group-item-heading">number</h4>
	      </div>
	      <div class="list-group-item">
	        <p class="list-group-item-text">Leader</p>
	        <h4 class="list-group-item-heading">leader Name</h4>
	      </div>
	      <div class="list-group-item">
	        <p class="list-group-item-text">Registered Date</p>
	        <h4 class="list-group-item-heading">leader Name</h4>
	      </div>
	      <div class="bootcards-list">
			  <div class="panel panel-default">
			  		<div class="panel-heading clearfix">
					    <h3 class="panel-title pull-left">Members</h3>
				    </div>
				    <div class="list-group">
					      <a class="list-group-item" href="#">
					      		<div class="col-sm-2">
					      			<img src="image/amila.jpg" class="img-rounded pull-left" style="width:50px; height:50px;"/>
					      		</div>
						        <h4 class="list-group-item-heading">Name</h4>
						        <p class="list-group-item-text">IT number</p>
					      </a>
					      <a class="list-group-item" href="#">
					      		<div class="col-sm-2">
					      			<img src="image/amila.jpg" class="img-rounded pull-left" style="width:50px; height:50px;"/>
					      		</div>
						        <h4 class="list-group-item-heading">Name</h4>
						        <p class="list-group-item-text">IT Number</p>
					      </a>
					      <a class="list-group-item" href="#">
						        <div class="col-sm-2">
					      			<img src="image/amila.jpg" class="img-rounded pull-left" style="width:50px; height:50px;"/>
					      		</div>
						        <h4 class="list-group-item-heading">Name</h4>
						        <p class="list-group-item-text">IT number</p>
					      </a>
					      <a class="list-group-item" href="#">
						        <div class="col-sm-2">
					      			<img src="image/amila.jpg" class="img-rounded pull-left" style="width:50px; height:50px;"/>
					      		</div>
						        <h4 class="list-group-item-heading">Name</h4>
						        <p class="list-group-item-text">IT number</p>
					      </a>
					      <a class="list-group-item" href="#">
						        <div class="col-sm-2">
					      			<img src="image/amila.jpg" class="img-rounded pull-left" style="width:50px; height:50px;"/>
					      		</div>
						        <h4 class="list-group-item-heading">Name</h4>
						        <p class="list-group-item-text">IT number</p>
					      </a>
				    </div>
			  </div>
		</div>
	    </div>
	</div>
	
	<script>
	$('#groupEdit').click(function() {
		var page = $(this).attr('href');
		$('#content').load('templates/groupEditing.jsp');
		return false;
	});
	</script>