<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="col-md-1" style="color: #ffffff; margin-left: -5px">
        <i class="fa fa-4x">PMS</i>   
    </div>
    <div class="col-md-8">
    	<ul class="nav navbar-nav navbar-inverse pull-left">
            <li>
                <a href="groupPage.action">
                    <h5>
                        <i class="fa fa-users" style="margin-left: 10px;"></i>
                        Student Groups
                    </h5>
                </a>
            </li>
            <li>
                <a href="contactUs_add.jsp">
                    <h5>
                        <i class="fa fa-phone" style="margin-left: 10px;"></i>
                        Contact Us
                    </h5>
                </a>
            </li>
        </ul>   
    </div>
    <div class="col-md-3">
    	<ul class="nav navbar-nav navbar-inverse pull-right">
    		<li>
    			<a href="userProfile.jsp">
    				<i class="fa fa-user"></i>
    				<s:property value=""/>
    				User Profile
    			</a>
    		</li>
    	</ul>
    </div>
</nav>