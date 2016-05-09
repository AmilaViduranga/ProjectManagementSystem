<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!Doctype>
	<html>
		<head>
			<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
			<jsp:include page="includes/header.jsp"></jsp:include>
			<title>Admin Home</title>
		</head>
		<body style="margin-top: 70px;">
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<h1>
						<i class="fa fa-users pull-left"></i>
							Admin :- User List
					</h1>
					<div class="col-sm-4">
						<div class="bootcards-list">
					  		<div class="panel panel-default">
						  		<div class="panel-heading clearfix">
						  			<div class="row">
						  				<div class="col-sm-3">
						  					<i class="fa fa-1x fa fa-list pull-left"></i>
							    			<h3 class="panel-title pull-left">Users</h3>
						  				</div>
						  				<div class="col-sm-9">
						  					<form action="searchUserAdmin" method="post">
							  					<input type="text" name="adminUserSearchBy" placeholder="serch" id="searchMenu"/>
							  					<Button class="btn btn-success">
							  						<i class="fa fa-search"></i>
							  					</Button>
						  					</form>
						  				</div>
						  			</div>
	                             </div>
								   <s:iterator value="adminUserList" var="user">
										<s:url action="searchUserIndividualAdmin" id="user" escapeAmp="false">
			   								<s:param name="userIdNo"><s:property value="userIdNo"/></s:param>
										</s:url>
										<a class="list-group-item" href="<s:property value="#user"/>">
											<div class="row">
												<div class="col-sm-6">
													<i class="fa fa-2x fa-user pull-left"></i>
								        			<h4 class="list-group-item-heading">Id :- <s:property value="userIdNo"/></h4>
							          				<p class="list-group-item-text"><s:property value="userName"/></p>
												</div>
							          		</div>
										</a>
									</s:iterator>
							</div>
						</div>
					</div>
					<div class="col-sm-8" id="content">
						
					</div>
				</div>
				<div class="col-sm-1"></div>
			</div>
		</body>
	</html>
	<script>
	$('a.list-group-item').click(function() {
		var page = $(this).attr('href');
		$('#content').load(page);
		return false;
	});
	</script>