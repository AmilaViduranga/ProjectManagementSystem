<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="panel panel-default">
  <div class="panel-heading clearfix">
  <div class="row">
  	<div class="col-sm-3">
  		<h3 class="panel-title pull-left">
  			<i class="fa fa-file-text"></i>
    		Project ID :- <s:property value="projectId"/>
    	</h3>
  	</div>
  	<div class="col-sm-9">
  		<s:if test="#session.userType == 'lectureIncharge'">
  			<form action="changeState.action" method="post">
  				<input type="text" value="<s:property value="projectId"/>" name="projectId" hidden="true">
	    		<div class="form-group">
	        		<label class="col-xs-3 control-label">Accept/Not Accept</label>
	        		<div class="col-xs-9">
			        	<div class="col-sm-8">
			        		<select class="form-control" name="acceptState">
					            <option value="accept">Accept</option>
					            <option value="notAccept" selected>Not Accept</option>
				          </select>
			        	</div>
			        	<div class="col-sm-4">
			        		<div class="btn-group pull-right">
								<button class="btn btn-success">
									<i class="fa fa-plus"></i> Update
								</button>
							</div>
			        	</div>
	          		</div>
	      		</div>
      		</form>
    </s:if>
    <s:if test="#session.userType == 'lecture'">
      <a class="btn btn-primary pull-right" href="#">
        <i class="fa fa-pencil"></i>
        Edit
      </a>
    </s:if>
    <s:if test="#session.userType == 'student'">
    	<form action="updateAssignment" method="post">
    		<input type="text" value="<s:property value="projectId"/>" name="projectId" hidden="true">
			<div class="list-group">
				<div class="list-group-item">
		      		<p class="list-group-item-heading">Your Developing Language</p>
		      		<select class="form-control" name="language">
							<option  value="Java">Java</option>
							<option selected value="php">PHP</option>
							<option  value="perl">Perl</option>
							<option  value="c#">C#</option>
							<option  value="javascript">JavaScript</option>
					</select>
	      		</div>
		      	<div class="list-group-item">
		      		<p class="list-group-item-heading">Your preferd Technology(Frameworks)</p>
		      		<textarea class="form-control" rows="6"  name="technology" placeholder="discribe what are the techonologies and frameworks you willing to apply this project" name="comment" required>
				    </textarea>
		      	</div>
		      	<button class="btn btn-success pull-right" style="margin-top: 10px;">
					<i class="fa fa-check"></i>
					Get This Project
				</button>
			 </div>
    	</form>
    </s:if>
  	</div>
  </div>
    </div>
    <div class="list-group">
      <div class="list-group-item">
        <p class="list-group-item-text">Id</p>
        <h4 class="list-group-item-heading"><s:property value="projectId"/></h4>
      </div>
      <div class="list-group-item">
        <p class="list-group-item-text">Project Name</p>
        <h4 class="list-group-item-heading"><s:property value="project.projectName"/></h4>
      </div>
      <div class="list-group-item">
        <p class="list-group-item-text">Project Description</p>
        <h4 class="list-group-item-heading"><s:property value="project.projectDescription"/></h4>
      </div>
      <div class="list-group-item">
        <p class="list-group-item-text">Client Name</p>
        <h4 class="list-group-item-heading"><s:property value="project.clientName"/></h4>
      </div>
      <div class="list-group-item">
        <p class="list-group-item-text">Client Contact Number</p>
        <h4 class="list-group-item-heading"><s:property value="project.clientContactNo"/></h4>
      </div>
      
</div>
</div>
