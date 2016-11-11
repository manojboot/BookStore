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
<body align="center">
	<div class="container"> 
			<h1>Welcome to Login Page</h1>
		 <div class='col-md-6 well'>
  			<form class="form-horizontal" method="post" action="register" >
  			    <div class="form-group">
				        <label class="col-xs-3 control-label">Username:</label>
        		    <div class="col-xs-8">
            			<input type="text" class="form-control" name="username" title = 'select your user name'>
       				 </div>
       			</div>
       			   <div class="form-group">
				        <label class="col-xs-3 control-label">Password:</label>
        		    <div class="col-xs-8">
            			<input type="password" class="form-control" name="password" title = 'select your password'>
       				 </div>
       			</div>
       			   <div class="form-group">
				        <label class="col-xs-3 control-label">FirstName:</label>
        		    <div class="col-xs-8">
            			<input type="text" class="form-control" name="firstName" title = 'select your first name'>
       				 </div>
       			</div>
			    <div class="form-group">
        				<label class="col-xs-3 control-label">LastName:</label>
        			<div class="col-xs-8">
            			<input type="text" class="form-control" name="lastName" title = 'select your last name'>
        			</div>
    			</div>
    			  <div class="form-group">
        				<label class="col-xs-3 control-label">Email ID:</label>
        			<div class="col-xs-8">
            			<input type="text" class="form-control" name="email" title = 'select your email id'>
        			</div>
    			</div>
    		    <div class="form-group">
    		    	<div class="col-xs-18">
					 <input type="submit" value="Register" />
					</div>
				</div>
			</form>
		</div>
	   </div>
</body>
</html>