<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="col-md-1" style="color: #ffffff; margin-left: -5px">
        <i class="fa fa-4x">PMS</i>   
    </div>
    <div class="col-md-8">
    	<ul class="nav navbar-nav navbar-inverse pull-left">
            <li>
                <a href="getAllGroups.action">
                    <h5>
                        <i class="fa fa-users" style="margin-left: 10px;"></i>
                        Group Managing
                    </h5>
                </a>
            </li>
            <li>
                <a href="#">
                    <h5>
                        <i class="fa fa-phone" style="margin-left: 10px;"></i>
                        Contact Us
                    </h5>
                </a>
            </li>
            <li>
                <a href="#">
                    <h5>
                        <i class="fa fa-info-circle" style="margin-left: 10px;"></i>
                        Help
                    </h5>
                </a>
            </li>
        </ul>   
    </div>
    <div class="col-md-3">
    	<ul class="nav navbar-nav navbar-inverse pull-right">
    		<li>
    			<a href="lecturerInchargeProfile.jsp">
    				<i class="fa fa-user"></i>
    				<s:property value="sessionMap.loggedUser"/>
    				User Profile
    			</a>
    		</li>
    	</ul>
    </div>
</nav>