<%@taglib prefix="s" uri="/struts-tags"%>
<div class="col-sm-6" style="margin-top: 10px;">
	<div class="bootcards-list">
	  <div class="panel panel-default">
	    <div class="panel-body">
		      
		        <div class="row">
		          <div class="col-xs-5">
		            <div class="form-group">
		              <input type="text" class="form-control" placeholder="Search Contacts..." name="filterBy">
		            </div>
		          </div>
		          <div class="col-xs-5">
			            <div class="form-group">
					        <label class="col-xs-3 control-label">Search by</label>
					        <div class="col-xs-9">
					          <select class="form-control" value="searchBy" name="filterType">
					            <option value="All">All</option>
					            <option value="LecturerId" selected>Lecturer ID</option>
					            <option value="title">Title</option>
					            <option value="accepted">Accepted</option>
					            <option value="notAccepted">Not Acepted</option>
					          </select>
					        </div>
					     </div>
					</div>
					<div class="col-sm-2">
						<div class="btn-group pull-right">
						      <button class="btn btn-primary">
						        <i class="fa fa-search"></i>
						        Search
						      </button>
						 </div>
					</div>
		        </div>
		      
	    </div>
			<s:iterator value="pendingProjectGroups" var="projects">
				<s:url action="getGroupIndividualLecInCharge" id="group" escapeAmp="false">
						<s:param name="projectId"><s:property value="projectId"/></s:param>
						<s:param name="groupIdName"><s:property value="GroupId"/></s:param>
						<s:param name="groupLeader"><s:property value="leaderId"/></s:param>
				</s:url>
					    	<a class="btn" href="<s:property value="#group"/>" accesskey="aceptProject" style="color:#333;">
					        	<div class="row">
					        		<div class="col-sm-6">
					        			<i class="fa fa-3x fa-users pull-left"></i>
				          				<h4 class="list-group-item-heading"> SEP_<s:property value="groupId"/></h4>
				          				<p class="list-group-item-text" style="color:#0000ff;"><s:property value="lectureInchargeStatus"/></p>
					        		</div>
					        		
				          		</div>
					      	</a>
					      	<hr style="margin-top: -5px;">
			</s:iterator>
		</div>
	</div>
</div>
<div class="col-sm-6" id="contentAcceptProject" style="margin-top: 10px;">
	
</div>