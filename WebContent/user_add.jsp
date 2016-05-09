<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<jsp:include page="includes/cssAndJsCalling.jsp" />
<jsp:include page="includes/headerNewUser.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body style="margin-top: 80px; background-color:"#dee0e0"">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<button onclick="myFunction()">Click me</button>
			<s:form name="myform" cssClass="form-horizontal" action="add"
				method="post" enctype="multipart/form-data"
				onsubmit="return Validate(this);">
				<div class="col-sm-8">
					<div class="panel panel-default">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">
								<i class="fa fa-user"></i> Student Register
							</h3>
							<div class="btn-group pull-right">
								<a class="btn btn-success" href="index.jsp"> <i
									class="fa fa-chevron-circle-left"></i> Go Back
								</a>

								<button class="btn btn-primary">
									<i class="fa fa-plus"></i> Register
								</button>

							</div>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-xs-3 control-label">IT NUMBER</label>
								<div class="col-xs-9">
									<input maxlength="10" type="text" class="form-control"
										id="userName" name="user.userIdNo" placeholder="your IT No"
										pattern="^[A-Za-z]{2}[0-9]{8}$" title="example : IT13144968"
										required />
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Name</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="name"
										title=" please insert Name Correctly" name="user.userName"
										placeholder="your Name"
										pattern="^ *[A-Za-z0-9\-]+[A-Za-z0-9.\- ]*$" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">CGPA</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="cgpa"
										title=" CGPA should be between 0 to 4" name="user.userCGPA"
										placeholder="your CGPA"
										pattern="^[0]|[0-3]\.(\d?\d?)|[4].[0]$" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Contact No</label>
								<div class="col-xs-9">
									<input class="form-control" type="tel" id="contactNo"
										pattern="^\d{10}$"
										title=" Insert Correct Phone no without spaces Ex : 0915715704"
										name="user.userContactNo" placeholder="your Contact No"
										required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">E-mail</label>
								<div class="col-xs-9">
									<input type="email" class="form-control" id="empNic"
										name="user.userEmail" placeholder="your Email"
										pattern="^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$"
										title="Example :test@gmail.com" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Password</label>
								<div class="col-xs-9">
									<input type="password" class="form-control" id="password"
										name="user.userPassword" placeholder="your Password"
										pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
										title="password should contain Minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character:"
										required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label"> Confirm Password</label>
								<div class="col-xs-9">
									<input type="password" class="form-control"
										id="confirmPassword" name="user.confirmPassword"
										placeholder="confirm password" required>
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
						<img id="image" width="150" height="150" />

						<div class="panel-footer">
							<s:file id="files" class="form-control btn-" name="user.photo">
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
		alertify.error("User Already Registered : Pleace Check Your ID No");
	</script>
</s:if>
<s:if test="hasActionMessages()">
	<script type="text/javascript">
		alertify.error("Email is already Inserted : Pleace Check Your Email");
	</script>
</s:if>
<s:else>
	<script type="text/javascript">
		alertify.success('Welcome to SLIIT PMS Registration');
	</script>
</s:else>

<script type="text/javascript">
	function Validate() {
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("confirmPassword").value;
		var userName = document.getElementById("userName").value;
		var arrInputs = document.getElementById("files").value;
		var exp = /^.*\.(jpg|jpeg|gif|JPG|png|PNG)$/;

		var res = exp.test(arrInputs);
		if (res == false) {
			alertify.error("Please Enter Photo File to upload");
			return false;

		}

		if (password != confirmPassword) {
			alertify.error("Password And Confirm Password Not Matching");
			return false;
		}

		return true;

	}
</script>

<script type="text/javascript">
	functionphotoValidate()
	{

		alertify.error('photo selected');

		return true;

	}
</script>

<script type="text/javascript">
	document.getElementById("files").onchange = function() {
		var reader = new FileReader();

		reader.onload = function(e) {
			// get loaded data and render thumbnail.
			document.getElementById("image").src = e.target.result;
		};

		// read the image file as a data URL.
		reader.readAsDataURL(this.files[0]);
	};
</script>

<script type="text/javascript">
	function myFunction() {
		document.getElementById("userName").value = "IT1458637";
		document.getElementById("name").value = "Sahan Ekanayake";
		document.getElementById("cgpa").value = "3.5";
		document.getElementById("contactNo").value = "0710852365";
		document.getElementById("empNic").value = "topasindul@gmail.com";
		document.getElementById("password").value = "rabbit@1234";
		document.getElementById("confirmPassword").value = "rabbit@1234";

	}
</script>





</html>