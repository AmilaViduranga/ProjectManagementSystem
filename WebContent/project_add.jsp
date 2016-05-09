<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
		<jsp:include page="includes/header.jsp"></jsp:include>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Projects</title>
	</head>
<body style="margin-top: 100px;">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<div class="col-sm-4">
				<h1>
					<i class="fa fa-book"></i>
					Project Managing
				</h1>
					<div class="bootcards-list">
					  	<div class="panel panel-default">
					  		<div class="panel-heading clearfix">
					  			<i class="fa fa-1x fa fa-list pull-left"></i>
						    	<h3 class="panel-title pull-left">Project List Submited</h3>
						    	<div class="btn-group pull-right">
							    	<a class="btn btn-success btn-block pull-right" href="templates/lecturer/projectAdd.jsp" id="registerGroup">
		        						<i class="fa fa-plus"></i>
		        						 new Project
		      						</a>
      							</div>
						    </div>
					    	<div class="list-group" id="groupList">
									<s:iterator value="submittedProjectList" var="projectList">
										<s:if test="%{submittedProjectList == null}"></s:if>
										<s:else>
							    			<s:url action="getProjectIndividual" id="group" escapeAmp="false">
			    								<s:param name="projectId"><s:property value="projectId"/></s:param>
			    								<s:param name="projectName"><s:property value="projectName"/></s:param>
											</s:url>
									    	<a class="list-group-item" href="<s:property value="#group"/>">
									        	<div class="row">
								        		<div class="col-sm-6">
								        			<i class="fa fa-3x fa-book pull-left"></i>
							          				<h4 class="list-group-item-heading">Id :- <s:property value="projectId"/></h4>
							          				<p class="list-group-item-text"><s:property value="projectName"/></p>
							          				<s:if test = "%{projectAcceptStatus}">
							          					<p class="list-group-item-text" style="color: #00FF00">Acepted</p>
							          				</s:if>
							          				<s:else>
							          					<p class="list-group-item-text" style="color:#FF0000">Not Accepted</p>
							          				</s:else>
								        		</div>
								          	</div>
									      </a>
								      </s:else>
					    		</s:iterator>
					    	</div>
					  	</div>
					</div>
			</div>
			<div class="col-sm-8">
				<div class="panel panel-default">
					  <div class="panel-heading clearfix">
					    	<h3 class="panel-title pull-left">
					    	<i class="fa fa-book pull-left"></i>
					    	Project Manager
					    	</h3>
					  </div>
					  <div class="panel-body" id="content">
					    <p>If you want to add new project click "newproject" button and 
					    if you want to view excisting project details more, click particular 
					    project on project list</p>
					  </div>
				</div>
			</div>
			<s:if test="hasActionErrors()">
				<script type="text/javascript">
					alertify.error("Not inserted data properly, check it now");
				</script>
			</s:if>
			<script type="text/javascript">
				function validatePhone() {

					var phoneNo = document.projectForm.client_contact_no.value;
					var validatedPhoneNo = /^\+?([0-9]{2})\)?[- ]?([0-9]{3})[- ]?([0-9]{3})[- ]?([0-9]{3})$/;

					if (!phoneNo.match(validatedPhoneNo))
						alertify
								.error("Phone Number is not in valid format. It must be in +XX-XXX-XXX-XXX or +XX XXX XXX XXX format");
				}
				
				$('a.list-group-item').click(function() {
					var page = $(this).attr('href');
					$('#content').load(page);
					return false;
				});	
				$('#registerGroup').click(function() {
					var page = $(this).attr('href');
					$('#content').load(page);
					return false;
				});	
			</script>
		</div>
		<div class="col-sm-1"></div>
	</div>
</body>
</html>