<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="panel panel-default">
	<div class="panel-heading clearfix">
		<h3 class="panel-title pull-left">Add member One</h3>
	</div>
	<div class="modal-body">
		<div class="form-group">
			<label class="col-xs-3 control-label">Name</label>
			<div class="col-xs-9">
				<input type="text" class="form-control"
					placeholder="member name">
			</div>
			<label class="col-xs-3 control-label">CGPA</label>
			<div class="col-xs-9">
				<input type="text" class="form-control"
					placeholder="member cgpa">
			</div>
			<label class="col-xs-3 control-label">ID number</label>
			<div class="col-xs-9">
				<input type="text" class="form-control" placeholder="member ID">
			</div>
			<label class="col-xs-3 control-label">Email</label>
			<div class="col-xs-9">
				<input type="text" class="form-control" placeholder="member Email">
			</div>
			<label class="col-xs-3 control-label">Contact Number</label>
			<div class="col-xs-9">
				<input type="text" class="form-control"
					placeholder="member Contact number">
			</div>
			<label class="col-xs-3 control-label">Type</label>
			<div class="col-xs-9">
				<select class="form-control" name="user.userType" required>
					<option selected value="Leader">Leader</option>
					<option value="member">Member</option>
				</select>
			</div>
			<label class="col-xs-3 control-label">CV</label>
			<div class="col-xs-9">
				<input type="file" class="form-control btn-" id="imgInp"
					name="user.userImage">
			</div>
		</div>
	</div>
</div>