<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
	<s:form class="form-horizontal" action="updateProfile.action"
		method="post" onsubmit="return Validate(this);"  enctype="multipart/form-data">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<i class="fa fa-user pull-left"></i>
				<h3 class="panel-title pull-left">Edit Profile</h3>
				<div class="btn-group pull-right" id="btnPanel">
					<a class="btn btn-primary  pull-right" href="userProfile.jsp">
						<i class="fa fa-pencil"></i> Back
					</a>
					<button class="btn btn-success">
						<i class="fa fa-check"></i> Update
					</button>
				</div>
			</div>

			<div class="modal-body">
				<div class="form-group">
					<label class="col-xs-3 control-label">user Name</label>
					<div class="col-xs-9">

						<input type="text" class="form-control" id="empid"
							name="user.userIdNo" placeholder="ID"
							value="<s:property value="#session.userPhoto.userIdNo"/>">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">E - mail</label>
					<div class="col-xs-9">

						<input type="email" class="form-control" id="empNic"
							name="user.userEmail" placeholder="Your New Email"
							value="<s:property value="#session.userPhoto.userEmail"/>"
							pattern="^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$"
							title="Example :test@gmail.com">


					</div>
				</div>

				<div class="form-group">
					<label class="col-xs-3 control-label" id="lblPassword">Password</label>
					<div class="col-xs-9">
						<input type="password" class="form-control" id="password"
							name="profilePassword" placeholder="your Password"
							pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
							title="password should contain Minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character:"
							required> <a class="btn btn-warning" id="showHide"
							style="margin-top: 4px;"> <i class="fa fa-key"></i> Change
							Password
						</a>
					</div>
				</div>


				<div id="divHideID" style="display: none;">
					<div class="form-group">
						<label class="col-xs-3 control-label">New Password</label>
						<div class="col-xs-9">
							<input type="password" class="form-control" id="newPassword"
								name="userNewPssword" placeholder="your new password"
								title="password should contain Minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character:">


						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label">Confirm new Password</label>
						<div class="col-xs-9">
							<input type="Password" class="form-control"
								placeholder="confirm new Password" id="txtConfirmPassword"
								name="userConfirmNewPassword">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">Image</label>
					<div class="col-xs-9">
						<div class="panel panel-default bootcards-media">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-image"></i> Add Image
								</h3>
							</div>
							<div class="panel-body">
								<p>Set your profile Picture</p>
								<img id="image" width="150" height="150"
								src="uploads/<s:property value="#session.userPhoto.photoFileName"/>" />
								<input type="file" id="files" class="form-control btn-" name="user.photo"  style="margin-top: 7px;"/>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</s:form>
</body>

<script type="text/javascript">
	$("#showHide").click(function() {
		$("#divHideID").slideToggle("slow");
		return true;
	})
</script>

<script type="text/javascript">
	function Validate() {
		var password = document.getElementById("newPassword").value;
		var confirmPassword = document.getElementById("txtConfirmPassword").value;
		if (password != confirmPassword) {
			alertify.error("Password And Confirm Password Not Matching");
			return false;
		}

		return true;
	}
</script>



<script type="text/javascript">
	$('button#backView').click(function() {
		$('#userProfile').load('templates/viewUserProfile.jsp');
		return false;
	});
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
	$(window).load(function() {
		$("#password").text("");
	});
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

</html>