<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<jsp:include page="includes/cssAndJsCalling.jsp" />
	<jsp:include page="includes/header.jsp" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projects</title>
</head>
<body style="margin-top: 100px;">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<s:form name="projectForm" cssClass="form-horizontal" action="addProject" method="post" onsubmit="return validatePhone(this);">
				<div class="col-sm-8">
					<div class="panel panel-default">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">
								<i class="fa fa-user"></i>Add Projects
							</h3>
							<div class="btn-group pull-right">
								<button class="btn btn-primary">
									<i class="fa fa-plus"></i> Add
								</button>
							</div>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-xs-3 control-label">Project Name</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="project_Name"
										name="project.projectName" placeholder="your Project Name" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Description</label>
								<div class="col-xs-9">
									<textarea rows="9" cols="10"  Class="form-control" name="project.projectDescription" placeholder="your Project's Description" required ></textarea>
               					</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Client Name</label>
								<div class="col-xs-9">
									<input type="text" class="form-control"
										name="project.clientName" placeholder="your Client's Name" required>
								</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Client Contact No</label>
								<div class="col-xs-9">
									<input type="text" class="form-control"
										name="project.clientContactNo" placeholder="your Client's Contact No (+XX-XXX-XXX-XXX or +XX XXX XXX XXX)" id = "client_contact_no"  required >
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">Client Email</label>
								<div class="col-xs-9">
									<input type="email" class="form-control"
										name="project.clientEmail" placeholder="your Client's Email" id="client_email" required>
								</div>
							</div>
						</div>
					</div>
				
			</s:form>
			

			<s:if test="hasActionErrors()">
				<script type="text/javascript">
					alertify.error("Not inserted data properly, check it now");
				</script>
			</s:if>
			
			<script type="text/javascript">
			
			function validatePhone() 	{  
  
				var phoneNo = document.projectForm.client_contact_no.value;
  				var validatedPhoneNo = /^\+?([0-9]{2})\)?[- ]?([0-9]{3})[- ]?([0-9]{3})[- ]?([0-9]{3})$/;  
  				
  				if(!phoneNo.match(validatedPhoneNo))  
  					alertify.error("Phone Number is not in valid format. It must be in +XX-XXX-XXX-XXX or +XX XXX XXX XXX format");
			}  
			
			</script>
			
			
    		
    		</div>
		<div class="col-sm-1"></div>
	</div>
</body>
</html>