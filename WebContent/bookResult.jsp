<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	 <div class='col-md-6 well'>
	 <form method="post" action="issueBook">
	 <table border="1" width="100%">
		 <tr>
		   <th>Book Title</th>
		   <th>Book Author</th>
		   <th>Book Genre</th>
		   <th>Issue Book</th>
		</tr>
		   <c:forEach items="${findBookAuthor}" var="book">
		<tr>
		   <td><c:out value="${book.bookTitle}"/></td>
		   <td><c:out value="${book.bookAuthor}"/></td>
		   <td><c:out value="${book.bookGenre}"/></td>
		   <td><INPUT TYPE="radio" NAME="radios" VALUE="radio1" UNCHECKED></td>
		</tr>
		</c:forEach>
		</table>
			<input type="submit" value="Issue Book" />
			</form>
		</div>
</body>
</html>