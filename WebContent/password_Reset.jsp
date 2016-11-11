<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
		<div class="container"> 
				<h1>Welcome to Login Page</h1>
			 <div class='col-md-6 well'>
	  			<form class="form-horizontal" method="post" action="passwordReset" >
				    <div class="form-group">
	        				<label class="col-xs-3 control-label">Email Id:</label>
	        			<div class="col-xs-8">
	            			<input type="emailId" class="form-control" name="emailId" title = 'type your email Id'>
	        			</div>
	    			</div>
	    		    <div class="form-group">
	    		    	<div class="col-xs-18">
						 <input type="submit" value="Send Verification Link" />
						</div>
					</div>
				</form>
			</div>
	   </div>
</body>
</html>