<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="includes/cssAndJsCalling.jsp" />
<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="margin-top: 70px;">
	<div class="row">
		<div class="col-sm-1"></div>
		<div class="col-sm-10" style="margin-top: 10px;">
			<h1>
				<i class="fa fa-file-text"> Upload CV</i>
			</h1>
			<s:form action="addCv" method="post" enctype="multipart/form-data"
				onsubmit="return Validate(this);">
				<div class="panel panel-default">
					<div class="panel-heading clearfix">
						<h3 class="panel-title pull-left">Upload CV</h3>
						<div class="btn-group pull-right">
							<a class="btn btn-success" href="GroupList.jsp"> <i
								class="fa fa-chevron-circle-left"></i> Go Back
							</a>
							<button class="btn btn-primary">
								<i class="fa fa-upload"></i> Upload
							</button>
						</div>
					</div>
					<div class="panel-body">
						<p>Please Upload your CV Here</p>

						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<div class="col-sm-2">
										<label class="control-label pull-right">Your CV</label> <input
											type="hidden"
											value="<s:property  value="#session.userPhoto.userIdNo"/>"
											name="nowUser">
									</div>
									<p class="list-group-item-text">
										<s:property value="#session.userPhoto.cv.documentFileName" />
									</p>
									<div class="col-sm-10">
										<input type="file" Class="form-control" name="cv.document"
											placeholder="upload your CV" id="files" required>
									</div>

								</div>
							</div>
						</div>

					</div>
				</div>
			</s:form>
		</div>
		<div class="col-sm-1"></div>
	</div>
</body>
<s:if test="hasActionMessages()">
	<script type="text/javascript">
	//swal("Good job!", "You clicked the button!", "success");
	//alertify.success("Successfully inserted!!!");
	swal("Good job!", "You uploaded the CV!", "success")
	</script>
</s:if>
<s:if test="hasActionErrors()">
	<script type="text/javascript">
		alertify.error("Server Error, please wait");
	</script>
</s:if>
</html>