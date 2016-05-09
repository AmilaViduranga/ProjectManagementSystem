<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="includes/cssAndJsCalling.jsp"></jsp:include>
		<jsp:include page="includes/header.jsp"></jsp:include>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Project</title>
	</head>
	<body style="margin-top: 70px;">
		<div class="row">
			<div class="col-sm-1">
			</div>
			<div class="col-sm-10">
				<h1>
					<i class="fa fa-book"></i>
					Project Managing
				</h1>
				<ul id="tabs">
                    <li>
                        <a href="#viewProject">
                            <i class="fa fa-book"></i>
                            View Project
                        </a>
                    </li>
                    <li>
                        <a href="#acceptProject">
                            <i class="fa fa-check"></i>
                            Accept Project
                        </a>
                    </li>
                </ul>

                <div id="viewProject" class="tab-section">
                    <jsp:include page="templates/Projects/LecInchargeViewProject.jsp" />
                </div>
                
                <div id="acceptProject" class="tab-section">
                    <jsp:include page="templates/Projects/lectureInChargeAcceptProject.jsp" />
                    
                </div>
                
                
			</div>
			<div class="col-sm-1"></div>
		</div>
	</body>
	<script type="text/javascript">
	$('a.list-group-item').click(function() {
		var page = $(this).attr('href');
		$('#content').load(page);
		return false;
	});
	
	$(function(){
	    $('.tab-section').hide();
	    $('#tabs a').bind('click', function(e){
	        $('#tabs a.current').removeClass('current');
	        $('.tab-section:visible').hide();
	        $(this.hash).show();
	        $(this).addClass('current');
	        e.preventDefault();
	    }).filter(':first').click();
	});
	
	$('a.btn').click(function() {
		var page = $(this).attr('href');
		$('#contentAcceptProject').load(page);
		return false;
	});
	</script>
</html>