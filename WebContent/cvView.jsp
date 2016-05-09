<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="includes/cssAndJsCalling.jsp" />
<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CV</title>
</head>
<body style="margin-top: 80px;">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="panel panel-default" style="margin-top:50px;">
						<div class="panel-heading clearfix">
							<i class="fa fa-1x fa fa-users pull-left"></i>
							<h3 class="panel-title pull-left">CV Displaying</h3>
						</div>
						<div class="panel-body" id="content">
	    					
		<s:iterator value="studentUsers" var="students">
			<s:url action="downloadFile" id="group" escapeAmp="false">
				<s:param name="docName">
					<s:property value="Cv.documentFileName" />
				</s:param>
			</s:url>
			<div class="col-sm-12" style="margin-top: 10px;">
				
				<div class="bootcards-list">
					<div class="panel panel-default">
					<s:if test="%{Cv!=null}">
						<div class="list-group">
							<a class="list-group-item">
								<div class="row">
									<div class="col-sm-2">
										<img src="uploads/<s:property value="photoFileName"/>"
											class="img-rounded pull-left" style="height: 50px; width: 50px;" />
									</div>
									<div class="col-sm-10">
										<h4 class="list-group-item-heading">
											<s:property value="userIdNo" />
										</h4>
										<p class="list-group-item-text">
											<strong><s:property value="Cv.documentFileName" /></strong>
										</p>
									</div>
								</div>
								<a class="btn btn-success pull-right" id="showHide" style="margin-top: 3px;" href="<s:property value="#group"/>"> <i
									class="fa fa-arrow-circle-down"></i> Download
								</a>	
							</a>
						</div>
					</s:if>
					</div>
				</div>
			</div>
		</s:iterator>
	
	  					</div>
	  				</div>
			
		</div>
		<div class="col-sm-3"></div>
	</div>
	
</body>
</html>