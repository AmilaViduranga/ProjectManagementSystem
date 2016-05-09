<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<jsp:include page="includes/cssAndJsCalling.jsp" />
			<jsp:include page="includes/header.jsp" />
		<title>Project Assigning</title>
	</head>
	<body style="margin-top: 70px;">
		<div class="row">
			<div class="col-sm-1">
			</div>
			<div class="col-sm-10">
				<h1>
					<i class="fa fa-book pull-left"></i>
					Project Assigning
				</h1>
				<s:if test="#session.isRegisteredGroup == 'registered'">
					<div class="col-sm-4">
						<div class="bootcards-list">
						  	<div class="panel panel-default">
						  		<div class="panel-heading clearfix">
						  			<i class="fa fa-1x fa fa-book pull-left"></i>
							    	<h3 class="panel-title pull-left">Projects Assigning</h3>
							    </div>
						    	<div class="list-group" id="groupList">
					    			<s:iterator value="acceptedProjects" var="regGroups">
								    	<s:url action="getProjectIndividual" id="project" escapeAmp="false">
		    								<s:param name="projectId"><s:property value="projectId"/></s:param>
										</s:url>
								    	<a class="list-group-item" href="<s:property value="#project"/>">
								        	<div class="row">
								        		<div class="col-sm-6">
								        			<i class="fa fa-3x fa-book pull-left"></i>
							          				<h4 class="list-group-item-heading"><s:property value="projectName"/></h4>
							          				<p class="list-group-item-text"><s:property value="projectDescription"/></p>
							          				<s:if test="projectState == 'pending'">
							          					<p class="list-group-item-text" style="color: #0000FF;"><s:property value="projectState"/></p>
							          				</s:if>
							          				<s:if test="projectState == 'Accepted'">
							          					<p class="list-group-item-text" style="color: #00FF00"><s:property value="projectState"/></p>
							          				</s:if>
							          				<s:if test="projectState == 'notAccepted'">
							          					<p class="list-group-item-text" style="color: #FF0000"><s:property value="projectState"/></p>
							          				</s:if>
							          			</div>
							          		</div>
								      	</a>
						    		</s:iterator>
						    	</div>
						  	</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="panel panel-default" id="content">
							<div class="panel-heading clearfix">
								<i class="fa fa-1x fa fa-users pull-left"></i>
								<h3 class="panel-title pull-left">Registered groups Individually</h3>
							</div>
							<div class="panel-body" id="content">
		    					<p>Click a project to view more details</p>
		  					</div>
		  				</div>
		  				<div class="panel panel-default">
							  <div class="panel-heading clearfix">
							    <h3 class="panel-title pull-left">
							    <i class="fa fa-exclamation-triangle"></i>
							    Notice</h3>
							  </div>
							  <div class="panel-body">
							    <p>first you have to select available projects at left side and assign a project.After the lecture inchargee
							    accepted your project only you have to work on this,after lecture incharge accepted that it will inform to you</p>
							  </div>
						</div>
					</div>
				</s:if>
				<s:else>
					<div class="panel panel-warning">
							  <div class="panel-heading clearfix">
							    <h3 class="panel-title pull-left">
							    <i class="fa fa-exclamation-triangle"></i>
							    Notice</h3>
							  </div>
							  <div class="panel-body">
							    <p>first you have to register your group</p>
							  </div>
						</div>
				</s:else>
			</div>
			<div class="col-sm-1">
			</div>
		</div>
	</body>
	<script type="text/javascript">
	$('a.list-group-item').click(function() {
		var page = $(this).attr('href');
		$('#content').load(page);
		return false;
	});	
	</script>
	<s:if test="hasActionMessage()">
	<script type="text/javascript">
		alertify.success("Successfully assigned project");
	</script>
</s:if>
<s:if test="hasActionErrors()">
	<script type="text/javascript">
		alertify.error("Not Assigned properly");
	</script>
</s:if>
</html>