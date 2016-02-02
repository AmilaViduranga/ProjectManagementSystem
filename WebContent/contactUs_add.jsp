<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="s" uri="/struts-tags"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="includes/cssAndJsCalling.jsp" />
	<jsp:include page="includes/header.jsp" />
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contact Us</title>
	</head>
	<body style="margin-top : 80px;">
	<div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
            	<h1>
	            	<i class="fa fa-phone-square"></i>
	            	Contact Us
            	</h1>
                <s:form name="contactus" cssClass="form-horizontal" action="addcontact" method="post" onsubmit="return checkForm(this);">
                    <div class="col-sm-8">
                        <div class="panel panel-default">
                            <div class="panel-heading clearfix">
                                <h3 class="panel-title pull-left">
                                    <i class="fa fa-phone"></i>
                                    Contact Us
                                </h3>
                                <div class="btn-group pull-right">
                                    <button class="btn btn-primary">
                                            <i class="fa fa-share-square"></i>
                                            Submit
                                    </button>
                                </div>
                                
                            </div>
	  					<div class="modal-body">
	    					<div class="form-group">
	        					<label class="col-xs-3 control-label">Name</label>
	        					<div class="col-xs-9">
	          						<input type="text" Class="form-control" name="contactInfo.userName" placeholder="your Name" required>
	        					</div>
	      					</div>
	      					<div class="form-group">
	        					<label class="col-xs-3 control-label">User Reg No</label>
	        					<div class="col-xs-9">
	          						<input type="text" Class="form-control" name="contactInfo.userRegNo"  placeholder="your Student Reg No" required >
	        					</div>
	      					</div>
	      					<div class="form-group">
	        					<label class="col-xs-3 control-label">Email</label>
	        					<div class="col-xs-9">
	          						<input type="text" Class="form-control" name="contactInfo.userEmail" placeholder="your Email" required >
	        					</div>
	      					</div>
	      					<div class="form-group">
	        					<label class="col-xs-3 control-label">Subject</label>
	        					<div class="col-xs-9">
	          						<input type="text" Class="form-control" name="contactInfo.userInquirySubject" placeholder="your Subject regarding Message/Inquiry" required>
	        					</div>
	      					</div>
	      					<div class="form-group">
	        					<label class="col-xs-3 control-label">Message / Inquiry</label>
	        					<div class="col-xs-9">
	          						<textarea rows="9" cols="10"  Class="form-control" name="contactInfo.userMessage" placeholder="your Message / Inquiry" required ></textarea>
               					</div>
                             </div>
                        </div>
                     </div>
                     </div>
                            
                     <div class="col-sm-4">
                        <div class="panel panel-default bootcards-media">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                	<i class="fa fa-google"></i>
                                     Find us on Google Map
                                </h3>
                            </div>
                            <div class="panel-body">
                                
                                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3960.7984310630836!2d79.97114011424719!3d6.914687120411626!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae256db1a6771c5%3A0x2c63e344ab9a7536!2sSri+Lanka+Institute+of+Information+Technology!5e0!3m2!1sen!2slk!4v1453287719850" width="320" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
                            	<br>
                            	<br>Sri Lanka Institute of Information Technology,
								<br>New Kandy Rd, 
								<br>Malabe.
                            </div>
                            
                            <div class="panel-footer">
                                +94 11 241 3900 / 0117544801 (Malabe)
								
                            </div>
                        </div>
                    </div>
                     
                 </s:form>
			</div>
			<div class="col-sm-1"></div>
		</div>
		
	</body>
	
	<s:if test="hasActionErrors()">
	<script type="text/javascript">
	alertify.error("Not inserted data properly, check it now");
	</script>
	</s:if>
	
</html>














