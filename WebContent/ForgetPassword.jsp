<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<jsp:include page="includes/cssAndJsCalling.jsp" />
	<jsp:include page="includes/headerNewUser.jsp" />
</head>
<body style="margin-top:70px;">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<h1><i class="fa fa-key">Forget Password</i></h1>
			<s:form cssClass="form-horizontal" action="forgetPassword" method="post">
			<div class="panel panel-default">
			  <div class="panel-heading clearfix">
			    <h3 class="panel-title pull-left">Forget Password</h3>
			    <div class="btn-group pull-right">
				    <a class="btn btn-success" href="index.jsp">
				    	<i class="fa fa-chevron-circle-left"></i>
				    	Go Back
				    </a>
				    <button class="btn btn-primary">
						<i class="fa fa-envelope-o "></i>
						Mail Password
					</button>
				</div>
			  </div>
			  <div class="panel-body">
			    <p>We send password to your email, we suggest you to update your password also</p>
			    
					<div class="form-group">
						<div class="row">
							<div class="col-sm-12">
								<div class="col-sm-2">
									<label class="control-label pull-right">Your Id No</label>
								</div>
								<div class="col-sm-10">
									<input type="text" Class="form-control" name="login.userName" placeholder="your Id Number" id="userName" required>
								</div>
							</div>
						</div>
	  				</div>
  				
			  </div>
			</div>
			</s:form>
		</div>
		<div class="col-sm-1"></div>
	</div>
</body>
<s:if test="hasActionMessages()">
   <script type="text/javascript">
   	alertify.success("successfully sent mail, check your mail");
   </script>
</s:if>
<s:if test="hasActionErrors()">
	<script type="text/javascript">
		alertify.error("Server Error, please wait");
	</script>
</s:if>
</html>