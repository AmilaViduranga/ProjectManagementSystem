<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="includes/cssAndJsCalling.jsp" />
	<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Help</title>
</head>

<body style="margin-top: 80px;">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-6">
			<h1>
				<i class="fa fa-info-circle"></i>
				Help
			</h1>
			<s:form name="myform" cssClass="form-horizontal" action="add"
				method="post" onsubmit="return checkForm(this);">
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-heading clearfix">
							<h3 class="panel-title pull-left">
								<i class="fa fa-info"></i> Need Help
							</h3>
							
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="col-xs-3 control-label">How to Register to the System?</label>
								<div class="col-xs-9">
								<iframe width="400" height="200" src="https://www.youtube.com/embed/Vz8CxlR_zis" frameborder="0" allowfullscreen></iframe></div>
							</div>
							<div class="form-group">
								<label class="col-xs-3 control-label">How to Register your Group to the System</label>
								<div class="col-xs-9">
								<iframe width="400" height="200" src="https://www.youtube.com/embed/xNXK9HPzT5E" frameborder="0" allowfullscreen></iframe>	
								</div>
							</div>
							
						</div>
					</div>
				</div>
				
			</s:form>
			

		</div>
		<div class="col-sm-4" style="margin-top: 80px;">
			<div class="panel panel-default">
			  <div class="panel-heading clearfix">
			    <h3 class="panel-title pull-left">
			    <i class="fa fa-info-circle"></i>
			    Help Info</h3>
			  </div>
			  <div class="panel-body">
			    <p>Here we try to give brief idea of using this site</p>
			  </div>
			</div>
		</div>
		<div class="col-sm-1"></div>
	</div>
</body>

</html>