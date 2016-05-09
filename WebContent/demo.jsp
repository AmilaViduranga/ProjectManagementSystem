<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
	</head>
	<body style="margin-top: 80px">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="panel panel-default">
				  <div class="panel-heading clearfix">
				    <h3 class="panel-title pull-left">Form Submit</h3>
				    <div class="btn-group pull-right">
					      <button class="btn btn-default">
					        <i class="fa fa-times"></i>
					        Cancel
					      </button>
					      <button class="btn btn-primary">
					        <i class="fa fa-check"></i>
					        Submit
					      </button>
				    </div>
				  </div>
				  <div class="modal-body">
				    <form class="form-horizontal">
				      <div class="form-group">
				        <label class="col-xs-3 control-label">Name</label>
				        <div class="col-xs-9">
				          <input type="text" class="form-control">
				        </div>
				      </div>
				      <div class="form-group">
				        <label class="col-xs-3 control-label">Address</label>
				        <div class="col-xs-9">
				          <textarea class="form-control" rows="6"></textarea>
				        </div>
      				  </div>
      				  <div class="form-group">
				        <label class="col-xs-3 control-label">E-Mail</label>
				        <div class="col-xs-9">
				          <input type="text" class="form-control">
				        </div>
				      </div>
				      <div class="form-group">
				        <label class="col-xs-3 control-label">Level</label>
				        <div class="col-xs-9">
				          <select class="form-control">
				            <option>Beginer</option>
				            <option selected>Middle Developer</option>
				            <option>Senior Developer</option>
				          </select>
				        </div>
				      </div>
				      <div class="form-group">
				      	<label class="col-xs-3 control-label">Gender</label>
				      	<div class="col-sm-9">
				      		<div class="col-sm-6">Male</div><br>
				      		<div class="col-sm-6">FeMale</div>
				      	</div>
				      </div>
				      <div class="form-group">
				      	<label class="col-xs-3 control-label">Skills</label>
				      	<div class="col-sm-9">
				      		<div class="col-sm-6">Java</div><br>
				      		<div class="col-sm-6">PHP</div><br>
				      		<div class="col-sm-6">C#</div><br>
				      		<div class="col-sm-6">C++</div>
				      	</div>
				      </div>
    			</form>
  			</div>

			</div>
		</div>
			<div class="col-sm-1"></div>
		</div>
	</body>
</html>