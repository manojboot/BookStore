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
	<h3>Login successful!!!</h3>
    <h4>
        Hello,
        <%=session.getAttribute("username")%></h4>
        
         <!--   <h3>Choose File to Upload in Server</h3>
        <form action="uploadFile" method="post" enctype="multipart/form-data">
                <input type="file" name="file" /> 
                <input type="submit" value="upload" />
        </form>
        
        <h4>${requestScope["message"]}</h4> -->
        <div class="container" class="hidden"> 
			<h1>Search</h1>
		 <div class='col-md-6 well'>
  			<form class="form-horizontal" method="post" action="searchBook" >
  			    <div class="form-group">
				        <label class="col-xs-3 control-label">Book Title:</label>
        		    <div class="col-xs-8">
            			<input type="text" class="form-control" name="bookTitle" title = 'Book Title'>
       				 </div>
       			</div>
			    <div class="form-group">
        				<label class="col-xs-3 control-label">Book Author:</label>
        			<div class="col-xs-8">
            			<input type="text" class="form-control" name="bookAuthor" title = 'Author Name'>
        			</div>
    			</div>
    			<div class="form-group">
        				<label class="col-xs-3 control-label">Book Genre:</label>
        				<div><select type="text" class="form-control" name="bookGenre" title = 'Book Genre'>
    						 <option value="Fiction">Fiction</option>
     						 <option value="Technical">Technical</option>
     						 <option>Religious</option>
     					     <option>Science Fiction</option>
     					     <option>Drama</option>
     					     <option>Health</option>
     					     <option>CookBooks</option>
     					     <option>Autobiographies</option>
						</select></div>
        			<!--div class="col-xs-8">
            			<input type="text" class="form-control" name="bookGenre" title = 'Book Genre'>
        			</div-->
    			</div>
    		    <div class="form-group">
    		    	<div class="col-xs-18">
					 <input type="submit" value="Search" />
					</div>
				</div>
			</form>
		</div>
	
	   </div>
	   
</body>
</html>