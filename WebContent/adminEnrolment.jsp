<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
			<jsp:include page="includes/header.jsp"></jsp:include>
			<title>project Admin</title>
		</head>
		<body style="margin-top: 70px;">
			<div class="row">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<h1>
						<i class="fa fa-key pull-left"></i>
							Enrolment Key Managing
					</h1>
					<div class="col-sm-4">
						<div class="panel panel-default">
							  <div class="panel-heading clearfix">
							    <h3 class="panel-title pull-left">
							    	<i class="fa fa-key"></i>
							    	Enrolment Keys
							    </h3>
							  </div>
							  <div class="panel-body">
							    	<div class="bootcards-list">
								  <div class="panel panel-default">
								    <div class="list-group">
								    	<s:iterator value="enrolmentKeys">
									      <a class="list-group-item" href="#">
									        <div class="row">
										        <i class="fa fa-3x fa-key pull-left"></i>
									            <h4 class="list-group-item-heading"><s:property value="catagory"/></h4>
									            <p class="list-group-item-text"><s:property value="enrolmentKey"/></p>
									            <p class="list-group-item-text"><s:property value="loginPassword"/></p>
									        </div>
									      </a>
									     </s:iterator>
								    </div>
								  </div>
								</div>
							  </div>
						</div>
					</div>
					<div class="col-sm-8">
					
					</div>
				</div>
				<div class="col-sm-1"></div>
			</div>
		</body>
	</html>