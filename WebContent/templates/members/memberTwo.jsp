<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="panel panel-default">
	<div class="panel-heading clearfix">
		<h3 class="panel-title pull-left">Add member Two</h3>
	</div>
	<div class="modal-body">
		<div class="form-group">
			<label class="col-xs-3 control-label">Name</label>
			<div class="col-xs-9">
				<s:textfield cssClass="form-control" name="userName" placeholder="member name"></s:textfield>
			</div>
			<label class="col-xs-3 control-label">CGPA</label>
			<div class="col-xs-9">
				<s:textfield cssClass="form-control" name="userCGPA" placeholder="member CGPA"></s:textfield>
			</div>
			<label class="col-xs-3 control-label">ID number</label>
			<div class="col-xs-9">
				<s:textfield cssClass="form-control" name="userID" placeholder="member ID"></s:textfield>
			</div>
			<label class="col-xs-3 control-label">Email</label>
			<div class="col-xs-9">
				<s:textfield cssClass="form-control" name="userEmail" placeholder="member Email"></s:textfield>
			</div>
			<label class="col-xs-3 control-label">Contact Number</label>
			<div class="col-xs-9">
				<s:textfield cssClass="form-control" name="userContact" placeholder="member Contact number"></s:textfield>
			</div>
			<label class="col-xs-3 control-label">Type</label>
			<div class="col-xs-9">
				<select class="form-control" name="user.userType" disabled>
					<option  value="Leader">Leader</option>
					<option selected value="member">Member</option>
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