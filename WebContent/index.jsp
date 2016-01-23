<%@page import="com.pms.model.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="includes/cssAndJsCalling.jsp" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body style="margin-top: 120px;">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<img alt="logo" src="image/sliiit_logo.jpg">
				<s:form cssClass="form-horizontal" action="login" method="post">
					<div class="panel panel-default">
  						<div class="panel-heading clearfix">
    						<h3 class="panel-title pull-left">Login To Module</h3>
    						<div class="btn-group pull-right">
      							<button class="btn btn-primary" name="addUser">
	                                <i class="fa fa-key"></i>
	                                Login
                                </button>
    						</div>
  						</div>
	  					<div class="modal-body">
	    					<div class="form-group">
	        					<label class="col-xs-3 control-label">User Name</label>
	        					<div class="col-xs-9">
	          						<input type="text" Class="form-control" name="login.userName" placeholder="your Name" required>
	        					</div>
	      					</div>
	      					<div class="form-group">
	        					<label class="col-xs-3 control-label">Password</label>
	        					<div class="col-xs-9">
	          						<input type="password" Class="form-control" name="login.userPassword" placeholder="your Password" required>
	        					</div>
	      					</div>
	  					</div>
	  					<a href="user_add.jsp"><small class="btn btn-link pull-right">Sign up</small></a>
	  					<a href="contactUs_add.jsp"><small class="btn btn-link pull-right">Contact Us</small></a>
  					</div>
				</s:form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</body>
	<s:if test="hasActionErrors()">
	<script type="text/javascript">
	alertify.error("Not inserted data properly, check it now");
	</script>
	</s:if>
</html>