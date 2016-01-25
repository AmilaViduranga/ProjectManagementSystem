<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lecturer Sign Up</title>
	<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
	<jsp:include page="includes/headerNewUser.jsp"></jsp:include>
</head>
<body style="margin-top: 70px;">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<s:form cssClass="form-horizontal" action="authonticateLecturer" method="post">
				<i class="fa fa-4x fa-graduation-cap pull-left"></i>
				<h1>Lecturer Sign UP</h1>
				<div class="panel panel-default">
				  <div class="panel-heading clearfix">
				    <h3 class="panel-title pull-left">Lecture Login Authonticator</h3>
				      <button class="btn btn-primary pull-right" name="addUser">
                          <i class="fa fa-key"></i>
                          Login
                       </button>
				  </div>
				  <div class="panel-body" id="content">
				    <div class="form-group">
			        <label class="col-xs-3 control-label">Password</label>
			        <div class="col-xs-9">
			          <input type="password" class="form-control" placeholder="give Password to verify the lecturer"  name="userPassword">
			        </div>
			      </div>
				  </div>
				  <div class="panel-footer">
				  </div>
				</div>
			</s:form>
		</div>
		<div class="col-sm-1"></div>
	</div>
</body>
<s:if test="hasActionErrors()">
	<script type="text/javascript">
	alertify.error("Login Error, Check it");
	</script>
</s:if>
</html>