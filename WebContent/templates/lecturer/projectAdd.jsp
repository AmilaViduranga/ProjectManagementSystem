<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<s:form cssClass="form-horizontal"
			action="addProject" method="POST"
			onsubmit="return validatePhone(this);">
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
									name="project.projectName" placeholder="your Project Name"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-3 control-label">Description</label>
							<div class="col-xs-9">
								<textarea rows="9" cols="10" Class="form-control"
									name="project.projectDescription"
									placeholder="your Project's Description" required></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-3 control-label">Client Name</label>
							<div class="col-xs-9">
								<input type="text" class="form-control"
									name="project.clientName" placeholder="your Client's Name"
									required>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label">Client Contact No</label>
						<div class="col-xs-9">
							<input type="text" class="form-control"
								name="project.clientContactNo"
								placeholder="your Client's Contact No (+XX-XXX-XXX-XXX or +XX XXX XXX XXX)"
								id="client_contact_no" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-3 control-label">Client Email</label>
						<div class="col-xs-9">
							<input type="email" class="form-control"
								name="project.clientEmail" placeholder="your Client's Email"
								id="client_email" required>
						</div>
					</div>
				</div>
				</s:form>