<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
		<jsp:include page="includes/headerLectureIncharge.jsp"></jsp:include>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>user Profile</title>
	</head>
	<body style="margine-top: 80px;">
		<div class="row">
			<h1>User Profile</h1>
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<i class="fa fa-4x fa-user pull-left"></i>
				<h1>User Profile</h1>
				<div class="col-sm-12" id="userProfile">
					
				</div>
			</div>
			<div class="col-sm-1"></div>
		</div>
	</body>
	<script type="text/javascript">
	$('#userProfile').load("getUser.action");
	</script>
</html>
