<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<form Class="form-horizontal" onSubmit="return validateValues()" action="saveGroup">
	<div class="panel panel-default">
		<div class="panel-heading clearfix">
			<i class="fa fa-users pull-left"></i>
			<h3 class="panel-title pull-left">Add Group</h3>
			<div class="btn-group pull-right">
				<button class="btn btn-primary">
					<i class="fa fa-plus"></i> Add
				</button>
			</div>
		</div>
		<div class="modal-body">
			<s:if test="%{isLectureIncharge == 'true'}">
			
			</s:if>
			<s:else>
				<div class="form-group">
					<label class="col-xs-3 control-label">Token Number</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" placeholder="Your group Token">
					</div>
				</div>
			</s:else>
			<div class="panel panel-default">
  				<div class="panel-heading clearfix">
   		 			<h3 class="panel-title pull-left">Members</h3>
   		 		</div>
   		 		<div class="panel-body">
   		 			<s:if test="%{isLectureIncharge == 'true'}">
   		 				<div class="form-group">
					        <label class="col-xs-3 control-label">Leader</label>
					        <div class="col-xs-9">
						          <s:select cssClass="form-control" list="userIds" name="memberLeader"></s:select>
					        </div>
				    	</div>
   		 			</s:if>
					<div class="form-group">
				        <label class="col-xs-3 control-label">Member One</label>
				        <div class="col-xs-9">
					          <s:select cssClass="form-control" list="userIds" name="memberOne"></s:select>
				        </div>
				    </div>
				    <div class="form-group">
				        <label class="col-xs-3 control-label">Member Two</label>
				        <div class="col-xs-9">
					         <s:select cssClass="form-control" list="userIds" name="memberTwo"></s:select>
				        </div>
				    </div>
				    <div class="form-group">
				        <label class="col-xs-3 control-label">Member Three</label>
				        <div class="col-xs-9">
					          <s:select cssClass="form-control" list="userIds" name="memberThree"></s:select>
				        </div>
				    </div>
				</div>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	function validateValues() {
		var memberOne = document.getElementById("memberOne").value;
		var memberTwo = document.getElementById("memberTwo").value;
		var memberThree = document.getElementById("memberThree").value;
		if (memberOne == memberTwo || memberTwo == memberThree || memberOne == memberThree) {
			alertify.error("Duplicate Member Id's entered");
			return false;
		}
		return true;
	}
		
</script>
