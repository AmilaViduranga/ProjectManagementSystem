7<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
		<jsp:include page="includes/header.jsp"></jsp:include>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Project</title>
	</head>
	<body style="margin-top: 70px;">
		<div class="row">
			<div class="col-sm-1">
			</div>
			<div class="col-sm-10">
				<h1>
					<i class="fa fa-book"></i>
					Project Assigning
				</h1>
				<div class="col-sm-6">
					<div class="bootcards-list">
					<div class="panel panel-default">

						<s:iterator value="studentSelectedProjects" var="projects">
							<s:url action="getProjectIndividual" id="group" escapeAmp="false">
								<s:param name="projectId">
									<s:property value="projectId" />
								</s:param>
								<s:param name="projectName">
									<s:property value="projectName" />
								</s:param>
							</s:url>
							<a class="list-group-item" href="<s:property value="#group"/>">
								<div class="row">
									<div class="col-sm-6">
										<i class="fa fa-3x fa-book pull-left"></i>
										<h4 class="list-group-item-heading">
											Id :-
											<s:property value="projectId" />
										</h4>
										<p class="list-group-item-text">
											<s:property value="projectName" />
										</p>
										<s:if test="%{projectAcceptStatus}">
											<p class="list-group-item-text" style="color: #00FF00">Acepted</p>
										</s:if>
										<s:else>
											<p class="list-group-item-text" style="color: #FF0000">Not
												Accepted</p>
										</s:else>
									</div>
									<div class="col-sm-6">
										<p class="list-group-item-text">
											Lecturer Id :-
											<s:property value="lectureID" />
										</p>
										<p class="list-group-item-text">
											Client :-
											<s:property value="clientName" />
										</p>
										<p class="list-group-item-text">
											Client Contact:-
											<s:property value="clientContactNo" />
										</p>
									</div>
								</div>
							</a>
						</s:iterator>
					</div>
				</div>
				</div>
				<div class="col-sm-6" id="content">
					
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</body>
	<script type="text/javascript">
	$('a.list-group-item').click(function() {
		var page = $(this).attr('href');
		$('#content').load(page);
		return false;
	});	
	</script>
</html>