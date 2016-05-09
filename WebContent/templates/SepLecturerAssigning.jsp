<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:form class="form-horizontal" action="selectLecturerInCharge.action">
	<div class="panel panel-default">
		<div class="panel-heading clearfix">
			<i class="fa fa-users pull-left"></i>
			<h3 class="panel-title pull-left">Select Lecturer In Charge</h3>
			<!-- <div class="btn-group pull-right">
				<a class="btn btn-primary pull-right" id="userEdit">
			        <i class="fa fa-pencil"></i>
			        Select Lecturer In Charge
	      		</a>
			</div> -->
			<div class="btn-group pull-right">
				<a class="btn btn-success btn-block pull-right"
					href="selectLecturerInCharge.action" id="registerGroup"> <i
					class="fa fa-plus"></i> Add new Leccture Incharge
				</a>
			</div>
		</div>
		<div class="bootcards-list">
			<div class="panel panel-default">
				<div class="list-group" id="groupList">
					<s:iterator value="lecturers" var="List">
						<s:url action="getLecturers" id="group" escapeAmp="false">
							<s:param name="userName">
								<s:property value="userName" />
							</s:param>
							<s:param name="groupLeader">
								<s:property value="userType" />
							</s:param>
						</s:url>
						<a class="list-group-item">
							<div class="row">
								<div class="col-sm-6">
									<div class="col-sm-2">
										<!-- i class="fa fa-3x fa-user pull-left"></i-->
											<img src="uploads/<s:property value="photoFileName"/>" class="img-responsive" style="height:40px; width:40px;"/>
									</div>
									<div class="col-sm-8">
										<h4 class="list-group-item-heading">
											<s:property value="userName" />
										</h4>
										<p class="list-group-item-text">
											<s:if test="%{isLecturerInCharge}">
												<div style="color:#FF0000">Lecturer In Charge</div>
											</s:if>
											<s:else>
												<div>Lecturer</div>
											</s:else>
										</p>
									</div>
								</div>
							</div>
						</a>
					</s:iterator>
				</div>
			</div>
		</div>
	</div>
</s:form>
<script type="text/javascript">
	$('a#registerGroup').click(function() {
		var page = $(this).attr('href');
		$('#content').load(page);
		return false;
	});
</script>