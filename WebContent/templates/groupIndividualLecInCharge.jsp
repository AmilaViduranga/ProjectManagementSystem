<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="panel panel-default">
	<div class="panel-heading clearfix">
		<div class="row">
			<div class="col-sm-3">
				<h3 class="panel-title pull-left">
					<i class="fa fa-book"></i>
					Project Accepting
				</h3>
			</div>
			<div class="col-sm-9" style="margin-top: -15px;">
				<form action="acceptProjectForGroup.action" method="post" name="f1">
  				<input type="text" value="<s:property value="groupIdName"/>" name="groupIdName" hidden="true">
	    		<div class="form-group">
	        		<label class="col-xs-3 control-label">Accept/Not Accept</label>
	        		<div class="col-xs-9">
			        	<div class="col-sm-8">
			        		<select class="form-control" name="acceptState">
					            <option value="accept">Accept</option>
					            <option value="notAccept" selected>Not Accept</option>
				          </select>
			        	</div>
			        	<div class="col-sm-4">
			        		<div class="btn-group pull-right">
								<button class="btn btn-success" id="update">
									<i class="fa fa-plus"></i> Update
								</button>
							</div>
			        	</div>
	          		</div>
	      		</div>
			</div>
		</div>
		
		
	</div>
	<div class="list-group">
		<div class="list-group-item">
			<p class="list-group-item-text">Group NO</p>
			<h4 class="list-group-item-heading">
				SEP_
				<s:property value="groupIdName" />
			</h4>
		</div>
		<div class="list-group-item">
			<p class="list-group-item-text">Leader</p>
			<h4 class="list-group-item-heading">
				<s:property value="groupLeader" />
			</h4>
		</div>
		<div class="bootcards-list">
			<div class="panel panel-default">
				<div class="panel-heading clearfix">
					<a class="btn btn-primary btn-block pull-left" id="ViewMembers">
						<i class="fa fa-user"></i> Members List & Project Details
					</a>
				</div>
				<div class="list-group" id="memberShow" style="display: none;">
					<s:iterator value="individualMembers" var="individualMember">
						<a class="list-group-item" href="#"> <s:if
								test="photoFileName == null">
								<div class="col-sm-2">
									<i class="fa fa-2x fa-user"></i>
								</div>
							</s:if> <s:else>
								<div class="col-sm-2">
									<img src="uploads/<s:property value="photoFileName"/>"
										class="img-responsive" style="height: 30px; width: 30px;" />
								</div>
							</s:else>
							<h4 class="list-group-item-heading">
								<s:property value="userIdNo" />
							</h4>
						</a>
					</s:iterator>
					<div class="panel panel-default">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">Project Technologies &
								Comment</h3>
						</div>
						<div class="list-group-item">
							<p class="list-group-item-text">Project Language</p>
							<h4 class="list-group-item-heading">
								<s:property value="mem.technology" />
							</h4>
						</div>
						<div class="list-group-item">
							<p class="list-group-item-text">Project Technologies</p>
							<h4 class="list-group-item-heading">
								<s:property value="mem.projectComment" />
							</h4>
						</div>
					</div>

				</div>
			</div>
			<s:if test="#session.userPhoto.isLecturerInCharge == true">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">
						<s:url action="getProjectIndividual" id="project"
							escapeAmp="false">
							<s:param name="projectId">
								<s:property value="projectId" />
							</s:param>
						</s:url>
						<a class="btn btn-primary btn-block pull-left"
							href="<s:property value="#project"/>" id="showHide"> <i
							class="fa fa-book"></i> View Project
						</a>
						<div class="panel-body" id="divHideID" style="margin-top: 30px;">
						</div>
					</div>

				</div>
			</s:if>
		</div>
	</div>
</div>

<script>
	$('#showHide').click(function() {
		var page = $(this).attr('href');
		$("#divHideID").slideToggle("slow");
		$('#divHideID').load(page);
		return false;
	});

	$('#ViewMembers').click(function() {
		$("#memberShow").slideToggle("slow");
	})
	
	$('#f1').click(function() {
		$('#update')
			.click(
				function() {
					var page = $(this).attr('href');
					alertify
							.confirm(
									'Do you want to Change Accept state?',
									function(e) {
										if (e) {
											window.location = "${pageContext.request.contextPath}/acceptProjectForGroup.action";
										}
									});

				})


	})
	

	
</script>