<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
	<div class="panel panel-default">
	  <div class="panel-heading clearfix">
	    <h3 class="panel-title pull-left">Group Name</h3>
	    </div>
	    <div class="list-group">
	      <div class="list-group-item">
	        <p class="list-group-item-text">Group NO</p>
	        <h4 class="list-group-item-heading">SEP_<s:property value="groupIdName"/></h4>
	      </div>
	      <div class="list-group-item">
	        <p class="list-group-item-text">Leader</p>
	        <h4 class="list-group-item-heading"><s:property value="groupLeader"/></h4>
	      </div>
	      <div class="bootcards-list">
			  <div class="panel panel-default">
			  		<div class="panel-heading clearfix">
					    <h3 class="panel-title pull-left">Members</h3>
				    </div>
				    <div class="list-group">
				    	<s:iterator value="individualMembers" var="individualMember">
					      <a class="list-group-item" href="#">
					      	<s:if test="photoFileName == null">
					      		<div class="col-sm-2">
					      			<i class="fa fa-2x fa-user"></i>
					      		</div>
					      	</s:if>
					      	<s:else>
					      		<div class="col-sm-2">
					      			<img src="uploads/<s:property value="photoFileName"/>" class="img-responsive" style="height:30px; width:30px;"/>
					      		</div>
					      	</s:else>
						        <h4 class="list-group-item-heading"><s:property value="userIdNo"/></h4>
					      </a>
					    </s:iterator>
				    </div>
			  </div>
		</div>
	    </div>
	</div>
	
	<script>
	$('#groupEdit').click(function() {
		var page = $(this).attr('href');
		$('#content').load('templates/groupEditing.jsp');
		return false;
	});
	
	</script>