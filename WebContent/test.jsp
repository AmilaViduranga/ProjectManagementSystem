<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="includes/cssAndJsCalling.jsp" />
	<jsp:include page="includes/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Help</title>
</head>

<body style="margin-top: 80px;">
	<input type="button" value="click" onclick="return myClick();"/>
	<div id="la">
	<div class="col-sm-6">
			<h1>
				<i class="icon-file-text-alt"></i> Upload CV
			</h1>
			<s:form action="addCv" method="post" enctype="multipart/form-data" onsubmit="return Validate(this);">
				<input type="text" value="<s:property  value="#session.userPhoto.userIdNo"/>" name="nowUser">
				<!--<s:submit value="Save"></s:submit> -->
				
				<div class="col-sm-4">
					<div class="panel panel-default bootcards-media">
						<div class="panel-heading">
							<h3 class="panel-title">
								<i class="fa-file-pdf-o"></i> Add CV 
							</h3>
						</div>
						<div class="panel-body">Set your CV</div>
						<img id="image" width="150" height="150" />

						<div class="panel-footer">
							<s:file id="files" name="cv.document" label="Photo"></s:file>
						</div>

					</div>
				</div>
			</s:form>


		</div>
	</div>
</body>
<script type="text/javascript">
function myClick() {
	/*var pre = document.createElement('pre');
	//custom style.
	pre.style.maxHeight = "400px";
	pre.style.overflowWrap = "break-word";
	pre.style.margin = "-16px -16px -16px 0";
	pre.style.paddingBottom = "24px";
	pre.appendChild(document.createTextNode($('#la').text()));
	//show as confirm
	alertify.confirm(pre, function(){
	        alertify.success('Accepted');
	    },function(){
	        alertify.error('Declined');
	    }).setting('labels',{'ok':'Accept', 'cancel': 'Decline'});*/
	    
	    swal("Good job!", "You clicked the button!", "success")

}


	</script>

</html>