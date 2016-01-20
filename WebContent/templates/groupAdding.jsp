<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<form class="form-horizontal">
	<div class="panel panel-default">
		<div class="panel-heading clearfix">
			<i class="fa fa-users pull-left"></i>
			<h3 class="panel-title pull-left">Add Group</h3>
			<div class="btn-group pull-right">
				<button class="btn btn-primary">
					<i class="fa fa-plus"></i> Add
				</button>
			</div>
		</div>
		<div class="modal-body">
			<div class="form-group">
				<label class="col-xs-3 control-label">Token Number</label>
				<div class="col-xs-9">
					<input type="text" class="form-control" placeholder="YOur Token">
				</div>
			</div>
			<ul id="tabs">
				<li><a href="#memberOne"> <i class="fa fa-user"></i> Member
						One
				</a></li>
				<li><a href="#memberTwo"> <i class="fa fa-user"></i> Member
						Two
				</a></li>
				<li><a href="#memberThree"> <i class="fa fa-user"></i>
						Member Three
				</a></li>
				<li><a href="#memberFour"> <i class="fa fa-user"></i>
						Member Four
				</a></li>
				<li><a href="#memberFive"> <i class="fa fa-user"></i>
						Member five
				</a></li>
			</ul>
			<div id="memberOne" class="tab-section">
				<jsp:include page="members/memberOne.jsp"></jsp:include>
			</div>
			<div id="memberTwo" class="tab-section">
				<jsp:include page="members/memberTwo.jsp"></jsp:include>
			</div>
			<div id="memberThree" class="tab-section">
				<jsp:include page="members/memberThree.jsp"></jsp:include>
			</div>
			<div id="memberFour" class="tab-section">
				<jsp:include page="members/memberFour.jsp"></jsp:include>
			</div>
			<div id="memberFive" class="tab-section">
				<jsp:include page="members/memberFive.jsp"></jsp:include>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	$(function() {
		$('.tab-section').hide();
		$('#tabs a').bind('click', function(e) {
			$('#tabs a.current').removeClass('current');
			$('.tab-section:visible').hide();
			$(this.hash).show();
			$(this).addClass('current');
			e.preventDefault();
		}).filter(':first').click();
	});
</script>