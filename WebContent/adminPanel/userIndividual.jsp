<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:form class="form-horizontal" action="updateUser.action"
		method="POST" enctype="multipart/form-data">
	<div class="panel panel-default">
		 <div class="panel-heading clearfix">
		 	<h3 class="panel-title pull-left">
		 	<i class="fa fa-user"></i>
		 	User Detail</h3>
			   <div class="btn-group pull-right">
			   	<s:url action="deleteExcistingUser.action" id="deleteUser" escapeAmp="false">
					<s:param name="userIdNo"><s:property value="user.userIdNo"/></s:param>
				</s:url>
			     <a class="btn btn-danger" href="<s:property value="#deleteUser"/>">
			       <i class="fa fa-trash"></i>
			       Delete
			     </a>
			     <button class="btn btn-success">
			       <i class="fa fa-check"></i>
			       Update
			     </button>
			   </div>
		 </div>
		  <div class="modal-body">
		      <div class="form-group">
		        <label class="col-xs-3 control-label">Name</label>
		        <div class="col-xs-9">
		          <input type="text" class="form-control" class="form-control" value="<s:property value="user.userName"/>" placeholder="user Name" name="userName"/>
		        </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">ID no</label>
		        <div class="col-xs-9">
		          <input type="text" name="userIdNo" class="form-control" value="<s:property value="user.userIdNo"/>"  placeholder="user ID" name="userIdNo" readonly="readonly"/>
		        </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">user CGPA</label>
		        <div class="col-xs-9">
		          <input type="text" class="form-control" value="<s:property value="user.userCGPA"/>" placeholder="user CGPA" name="userGPA"/>
		        </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">user contactNo</label>
		        <div class="col-xs-9">
		          <input type="text" class="form-control" value="<s:property value="user.userContactNo"/>" placeholder="user Contact No" name="userContactNo"/>
		        </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">user Password</label>
		        <div class="col-xs-9">
		          <input type="text" class="form-control" value="<s:property value="user.userPassword"/>" placeholder="user password" name="userPassword">
		        </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">user Email</label>
		        <div class="col-xs-9">
		          <input type="text" class="form-control" value="<s:property value="user.userEmail"/>" placeholder="user Email" name="userEmail">
		        </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">SEP</label>
		        <div class="col-xs-9">
		          <s:if test="user.isSep == true ">
		          	<input type="checkbox" name="isSep" checked/>
		          </s:if>
		          <s:else>
		          	<input type="checkbox" name="isSep"/>
		          </s:else>
		         </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">ITP</label>
		        <div class="col-xs-9">
		          <s:if test="user.isITP == true ">
		          	<input type="checkbox" name="isITP" checked/>
		          </s:if>
		          <s:else>
		          	<input type="checkbox"  name="isITP"/>
		          </s:else>
		         </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">Lecturer Incharge</label>
		        <div class="col-xs-9">
		          <s:if test="user.isLecturerInCharge == true ">
		          	<input type="checkbox" name="isLecturerInCharge" checked/>
		          </s:if>
		          <s:else>
		          	<input type="checkbox" name="isLecturerInCharge"/>
		          </s:else>
		         </div>
		      </div>
		      <div class="form-group">
		        <label class="col-xs-3 control-label">User Type</label>
		        <div class="col-xs-9">
		          <select class="form-control" name="userType" >
		          	<s:if test="user.userType == 'student'">
		          		<option value="lecturer">Lecturer</option>
			            <option value="student" selected>Student</option>
			            <option value="HOD">HOD</option>
		          	</s:if>
		          	<s:if test="user.userType == 'lecturer'">
		          		<option value="lecturer" selected>Lecturer</option>
			            <option value="student" >Student</option>
			            <option value="HOD">HOD</option>
		          	</s:if>
		          	<s:if test="user.userType == 'hod'">
		          		<option value="lecturer">Lecturer</option>
			            <option value="student" >Student</option>
			            <option value="hod" selected>HOD</option>
		          	</s:if>
		          	<s:if test="user.userType == 'admin'">
		          		<option value="lecturer">Lecturer</option>
			            <option value="student" >Student</option>
			            <option value="hod">HOD</option>
			            <option value="admin" selected>Admin</option>
		          	</s:if>
		          </select>
		        </div>
		      </div>
		  </div>
	</div>
</s:form>