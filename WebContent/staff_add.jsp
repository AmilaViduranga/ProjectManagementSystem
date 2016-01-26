<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<jsp:include page="includes/cssAndJsCalling.jsp" />
<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body style="margin-top: 80px;">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<s:form name="myform" cssClass="form-horizontal" action="addStaff"
				method="post" enctype="multipart/form-data"
				onsubmit="return Validate(this);">
				<div class="col-sm-8">
					<div class="panel panel-default">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">
								<i class="fa fa-user"></i> Staff Register
							</h3>
							<div class="btn-group pull-right">
								<button class="btn btn-primary">
									<i class="fa fa-plus"></i> Register
								</button>
							</div>
						</div>
						<div class="modal-body">

							<div class="form-group">
								<label class="col-xs-3 control-label">Name</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="name"
										name="user.userName" placeholder="your Name" required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-xs-3 control-label">Contact No</label>
								<div class="col-xs-9">
									<input type="number" class="form-control" id="name"
										name="user.userContactNo" placeholder="your Contact No"
										required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">E-mail</label>
								<div class="col-xs-9">
									<input type="email" class="form-control" id="empNic"
										name="user.userEmail" placeholder="your Email" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">User Name</label>
								<div class="col-xs-9">
									<input maxlength="10" type="text" class="form-control"
										id="userName" name="user.userIdNo" placeholder="your User Name For Login"
										required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Subject</label>
								<div class="col-xs-9">
									<label class="col-xs-3 control-label">SEP</label> <input
										type="checkbox" class="form-control" id="userSubject1"
										name="user.isSep" value="SEP" required> <label
										class="col-xs-3 control-label">ITP</label> <input
										type="checkbox" class="form-control" id="userSubject2"
										name="user.isITP" value="ITP" required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-xs-3 control-label">Password</label>
								<div class="col-xs-9">
									<input type="password" class="form-control" id="password"
										name="user.userPassword" placeholder="your Password" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label"> Confirm Password</label>
								<div class="col-xs-9">
									<input type="password" class="form-control"
										id="confirmPassword" name="user.confirmPassword"
										placeholder="confirm password"required">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="panel panel-default bootcards-media">
						<div class="panel-heading">
							<h3 class="panel-title">
								<i class="fa fa-image"></i> Add Image
							</h3>
						</div>
						<div class="panel-body">Set your profile Picture</div>
						<img src="uploads/<s:property value="user.photoFileName"/>" />

						<div class="panel-footer">
							<s:file class="form-control btn-" name="user.photo">
							</s:file>
						</div>

					</div>
				</div>
			</s:form>



		</div>
		<div class="col-sm-1"></div>
	</div>
</body>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#upImage').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$("#imgInp").change(function() {
		readURL(this);
	});
</script>
<s:if test="hasActionErrors()">
	<script type="text/javascript">
		alertify.error("Please Check values");
	</script>
</s:if>

<script type="text/javascript">
	function Validate() {
		var password = document.getElementById("password").value;
		alert(password);
		var confirmPassword = document.getElementById("confirmPassword").value;
		var userName = document.getElementById("userName").value;
		if (password != confirmPassword) {
			alertify.error("Password And Confirm Password Not Matching");
			alert(confirmPassword);

			return false;
		}
		return true;
	}
</script>










</html>