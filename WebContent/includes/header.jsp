<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
	<div class="col-md-1" style="color: #ffffff; margin-left: -5px">
		<i class="fa fa-4x">PMS</i>
	</div>
	<div class="col-md-8">
		<ul class="nav navbar-nav navbar-inverse pull-left">
			<s:if test="#session.userType == 'student'">
				<li><a href="groupPage.action">
						<h5>
							<i class="fa fa-users" style="margin-left: 10px;"></i> Student
							Groups
						</h5>
				</a></li>
				<li><a href="cv.jsp">
						<h5>
							<i class="fa fa-file-text" style="margin-left: 10px;"></i>
							Upload CV
						</h5>
				</a></li>
				<li><a href="getAllAcceptedProjects.action">
						<h5>
							<i class="fa fa-book" style="margin-left: 10px;"></i> Projects
						</h5>
				</a></li>
			</s:if>
			<s:if test="#session.userType == 'lectureIncharge'">
				<li><a href="getAllGroups.action">
						<h5>
							<i class="fa fa-users" style="margin-left: 10px;"></i> Group
							Managing
						</h5>
				</a></li>
				<li><a href="loadAllProjectToLI.action">
						<h5>
							<i class="fa fa-book" style="margin-left: 10px;"></i> Projects
						</h5>
				</a></li>
				<li><a href="viewCvAction.action">
						<h5>
							<i class="fa fa-info-circle" style="margin-left: 10px;"></i> View
							CV
						</h5>
				</a></li>
				
			</s:if>
			<s:if test="#session.userType == 'lecturer'">
				<li><a href="loadProjectMenu.action">
						<h5>
							<i class="fa fa-book" style="margin-left: 10px;"></i> Projects
						</h5>
				</a></li>
			</s:if>
			<s:if test="#session.userType == 'hod'">
				<li><a href="login.action">
						<h5>
							<i class="fa fa-graduation-cap" style="margin-left: 10px;"></i>
							Lecturer
						</h5>
				</a></li>
			</s:if>
			<s:if test ="#session.userType == 'admin'">
				<li>
					<a href="adminUserPanelLoadUsers.action">
						<h5>
							<i class="fa fa-user" style="margin-left: 10px;"></i>
							User Pannel
						</h5>
					</a>
				</li>
				<li>
					<a href="loadAllProjectToLI.action">
						<h5>
							<i class="fa fa-book" style="margin-left: 10px;"></i>
							Project pannel
						</h5>
					</a>
				</li>
				<li>
					<a href="loadEnrolmentKeys.action">
						<h5>
							<i class="fa fa-key" style="margin-left: 10px;"></i>
							Enrolment Pannel
						</h5>
					</a>
				</li>
			</s:if>
			
		</ul>
	</div>
	<div class="col-md-3">
		<ul class="nav navbar-nav navbar-inverse ">
			<li><a href="userProfile.jsp"> <s:if
						test="#session.userPhoto.photoFileName != null">
						<img
							src="uploads/<s:property value="#session.userPhoto.photoFileName"/>"
							class="img-responsive" style="height: 35px; width: 35px;" />
					</s:if> <s:if test="#session.userPhoto.photoFileName == null">
						<i class="fa fa-user"></i>
					</s:if> <s:property value="#session.userPhoto.userName" /> Profile
			</a></li>
			<li><a href="#" class="pull-right" id="loginOut"> <i
					class="fa fa-sign-out"></i> Log Out
			</a></li>
		</ul>
	</div>
</nav>

<script type="text/javascript">
	$('#loginOut').click(function() {
		swal({ title : "Are you sure?",
			   type : "You will going to logout from PMS",
			   type : "warning",
			   showCancelButton : true,
			   confirmButtonColor : "#DD6B55",
			   confirmButtonText : "Yes, Logout!",
			   cancelButtonText : "cancel",
			   closeOnConfirm : false,
			   closeOnCancel : false
			   }, function(isConfirm) {
				   if (isConfirm) {
					   window.location = "${pageContext.request.contextPath}/logOut.action";
				   } else {
					   swal("Cancelled", "You are not logout", "error");
				   }
			   })
	})
						

	
</script>