<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<form class="form-horizontal" action="saveLecturerInCharge.action" method="post">
	this is sep lec incharge
	<div class="panel panel-default">
		<div class="panel-heading clearfix">
			<i class="fa fa-users pull-left"></i>
			<h3 class="panel-title pull-left">Select Lecturer In Charge</h3>
			<div class="btn-group pull-right">
				<!--  a class="btn btn-primary pull-right" href="saveLecturerInCharge.action" id="lecInChargeSave">
					<i class="fa fa-pencil"></i> Save
				</a-->
				<button class="btn btn-primary">
        			<i class="fa fa-times"></i>
        			Save
      			</button>
			</div>
		</div>
		<div class="bootcards-list">
			<div class="panel panel-default">
				<div class="form-group">
					<div class="col-xs-9">
						<div class="col-sm-3">
							<label class="col-xs-3 control-label">Select Name</label>
						</div>
						<div class="col-sm-9" style="margine-top:10px">
							<s:select value="llname" cssClass="form-control" headerKey="-1"
							headerValue="Select" list="lecturesNames" name="selectedName" />
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>
</form>
<script type="text/javascript">
	$('a#userEdit').click(function() {
		alert("button clicked");
		$('#SepLecturerAssigning').load(saveLecturerInCharge.action);
		return false;
	});

	
</script>