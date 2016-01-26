<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
 <form class="form-horizontal">   
 <div class="panel panel-default">
	  <div class="panel-heading clearfix">
	  		<i class="fa fa-user pull-left"></i>
	    	<h3 class="panel-title pull-left">Edit Profile</h3>
	      	<div class="btn-group pull-right" id="btnPanel">
			      <button class="btn btn-primary" id="backView" action="getUser.action">
			        <i class="fa fa-arrow-left"></i>
			        Back
			      </button>
			      <button class="btn btn-success">
			        <i class="fa fa-check"></i>
			        Update
			      </button>
    		</div>
	  </div>
	  
	  <div class="modal-body">
		  	<div class="form-group">
		        <label class="col-xs-3 control-label">user Name</label>
		        <div class="col-xs-9">
		          <input type="text" class="form-control" value="user Name" disabled>
		        </div>
	  		</div>
	  		<div class="form-group">
		        <label class="col-xs-3 control-label">E - mail</label>
		        <div class="col-xs-9">
		          <input type="text" class="form-control" placeholder="Your Email">
		        </div>
	  		</div>
	  		<div class="form-group">
		        <label class="col-xs-3 control-label" id="lblPassword">Password</label>
		        <div class="col-xs-9">
		        	<input type="Password" class="form-control" placeholder="Your Password">
		        </div>
	  		</div>
	  		<div class="form-group">
		        <label class="col-xs-3 control-label">new Password</label>
		        <div class="col-xs-9">
		          <input type="Password" class="form-control" placeholder="Your new Password" id="txtNewPassword">
		        </div>
	  		</div>
	  		<div class="form-group">
		        <label class="col-xs-3 control-label">confirm Password</label>
		        <div class="col-xs-9">
		          <input type="Password" class="form-control" placeholder="confirm new Password" id="txtConfirmPassword">
		        </div>
	  		</div>
	  		<div class="form-group">
		        <label class="col-xs-3 control-label">Image</label>
		        <div class="col-xs-9">
		          <div class="panel panel-default bootcards-media">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <i class="fa fa-image"></i>
                                    Add Image
                                </h3>
                            </div>
                            <div class="panel-body">
                                Set your profile Picture
                            </div>
                            <img id="upImage" src="image/sliiit_logo.jpg" class="img-responsive" style="width:150px; height=150px;"/>
                            <div class="panel-footer">
                                <input type="file" class="form-control btn-" id="imgInp" name="user.userImage">
                            </div>
                        </div>
		        </div>
	  		</div>
	</div>
	
</div>
</form>
<script type="text/javascript">
	$('button#backView').click(function() {
		$('#userProfile').load('templates/viewUserProfile.jsp');
		return false;
	});
	 function readURL(input) {
         if (input.files && input.files[0]) {
             var reader = new FileReader();
             reader.onload = function (e) {
                 $('#upImage').attr('src', e.target.result);
             }
             reader.readAsDataURL(input.files[0]);
         }
     }
     $("#imgInp").change(function(){
         readURL(this);
     });
</script>