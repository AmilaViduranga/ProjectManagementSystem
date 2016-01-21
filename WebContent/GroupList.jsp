<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
		<jsp:include page="includes/header.jsp"></jsp:include>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Groups</title>
	</head>
	<body style="margin-top: 80px;">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<i class="fa fa-4x fa-users pull-left"></i>
				<h1>Student Groups</h1>
				<div class="col-sm-4">
					<div class="bootcards-list">
					  	<div class="panel panel-default">
					  		<div class="panel-heading clearfix">
					  			<i class="fa fa-1x fa fa-list pull-left"></i>
						    	<h3 class="panel-title pull-left">Registered groups</h3>
						    	<div class="btn-group pull-right">
                                 <button class="btn btn-success" id="registerGroup">
                                         <i class="fa fa-plus"></i>
                                         new Register
                                 </button>
                             </div>
						    </div>
					    	<div class="list-group" id="groupList">
					    	<s:iterator value="groups" var="member">
						      <a class="list-group-item" href="#">
					        	<div class="row">
					        		<div class="col-sm-6">
					        			<i class="fa fa-3x fa-users pull-left"></i>
				          				<h4 class="list-group-item-heading"><s:property value="groupId"/></h4>
							            <p class="list-group-item-text"><s:property value="memberName"/></p>
					        		</div>
					          	</div>
						      </a>
						     </s:iterator>
					    	</div>
					  	</div>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="panel panel-default">
						<div class="panel-heading clearfix">
							<i class="fa fa-1x fa fa-users pull-left"></i>
							<h3 class="panel-title pull-left">Registered groups Individually</h3>
						</div>
						<div class="panel-body" id="content">
	    					<p>Click the group to view more details</p>
	  					</div>
	  				</div>
				</div>
			</div>
			<div class="col-sm-1">
			</div>
		</div>
	</body>
	<script type="text/javascript">
	$('div#groupList a.list-group-item').click(function() {
		var page = $(this).attr('href');
		$('#content').load('templates/groupIndividual.jsp');
		return false;
	});
	$('#registerGroup').click(function() {
		var page = $(this).attr('href');
		$('#content').load('templates/groupAdding.jsp');
		return false;
	});	
	</script>
</html>