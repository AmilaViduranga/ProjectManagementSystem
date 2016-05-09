<%@taglib prefix="s" uri="/struts-tags"%>
<div class="col-sm-6" style="margin-top: 10px;">
	<div class="bootcards-list">
	  <div class="panel panel-default">
	    <div class="panel-body">
		      <form action="fielterProject.action" method="post">
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
		      </form>
	    </div>
			<s:iterator value="allProjects" var="projects">
				<s:url action="getProjectIndividual" id="group" escapeAmp="false">
   								<s:param name="projectId"><s:property value="projectId"/></s:param>
   								<s:param name="projectName"><s:property value="projectName"/></s:param>
							</s:url>
					    	<a class="list-group-item" href="<s:property value="#group"/>">
					        	<div class="row">
					        		<div class="col-sm-6">
					        			<i class="fa fa-3x fa-book pull-left"></i>
				          				<h4 class="list-group-item-heading">Id :- <s:property value="projectId"/></h4>
				          				<p class="list-group-item-text"><s:property value="projectName"/></p>
				          				<s:if test = "%{projectAcceptStatus}">
				          					<p class="list-group-item-text" style="color: #00FF00">Acepted</p>
				          				</s:if>
				          				<s:else>
				          					<p class="list-group-item-text" style="color:#FF0000">Not Accepted</p>
				          				</s:else>
					        		</div>
					        		<div class="col-sm-6">
					        			<p class="list-group-item-text">Lecturer Id :- <s:property value="lectureID"/></p>
					        			<p class="list-group-item-text">Client  :- <s:property value="clientName"/></p>
					        			<p class="list-group-item-text">Client Contact:- <s:property value="clientContactNo"/></p>
					        		</div>
				          	</div>
					      </a>
			</s:iterator>
		</div>
	</div>
</div>
<div class="col-sm-6" id="content" style="margin-top: 10px;">
	
</div>