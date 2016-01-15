<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <jsp:include page="cssAndJsCalling.jsp" />
        <jsp:include page="header.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Register</title>
    </head>
    <body style="margin-top : 80px;">
	<div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <s:form cssClass="form-horizontal" action="add" method="post">
                    <div class="col-sm-8">
                        <div class="panel panel-default">
                            <div class="panel-heading clearfix">
                                <h3 class="panel-title pull-left">
                                    <i class="fa fa-user"></i>
                                    USER Register
                                </h3>
                                <div class="btn-group pull-right">
                                    <button class="btn btn-primary">
                                            <i class="fa fa-plus"></i>
                                            Register
                                    </button>
                                </div>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label class="col-xs-3 control-label">User Name</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" id="empName" name="user.userIdNo" placeholder="your name" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3 control-label">E-mail</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" id="empNic" name="user.userEmail" placeholder="your Email" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Type</label>
                                    <div class="col-xs-9">
                                        <select class="form-control" name="user.userType" requir>
                                            <option selected value="student">Student</option>
                                            <option value="lecturer">Lecturer</option>
                                            <option value="lecturerIncharge">Lecturer Incharge</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Password</label>
                                    <div class="col-xs-9">
                                        <input type="password" class="form-control" name="user.userPassword" placeholder="your Password" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3 control-label"> Confirm Password</label>
                                    <div class="col-xs-9">
                                        <input type="password" class="form-control" name="confirmPassword" placeholder="confirm password" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3 control-label">Token No</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" name="user.userToken" placeholder="your token" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
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
                            <img id="upImage" src="image/sliiit_logo.jpg" class="img-responsive"/>
                            <div class="panel-footer">
                                <input type="file" class="form-control btn-" id="imgInp" name="user.userImage">
                            </div>
                        </div>
                    </div>
                </s:form>
            <script type="text/javascript">
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
            </div>
            <div class="col-sm-1"></div>
        </div>
    </body>
</html>