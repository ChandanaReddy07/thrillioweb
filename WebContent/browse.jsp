<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>thrill.io</title>
</head>
<body style="font-family:Arial;font-size:20px;">
	<div style="height:80px;align:center;background:#25CCF7;font-family: Arial;color: white;"">
		<br><b>
		<a href="" style="font-family:garamond;font-size:34px;margin:0px 0px 0px 10px;color:white;text-decoration: none;">thrill.io</a></b>
		
		<div style="height:50px;background:#25CCF7;font-family: Arial;color: white;">
			<b>
			<a href="<%=request.getContextPath()%>/bookmark/mybooks" style="font-size:16px;color:white;margin-left:1150px;text-decoration:none;">My Books</a>			
			<a href="<%=request.getContextPath()%>/auth/logout" style="font-size:16px;color:white;margin-left:10px;text-decoration:none;">Logout</a>
			</b>
		</div>
	</div>
	<br><br>
	
	<table>
	   <c:forEach var = "book" items="${books}">
	     <tr>
		   <td>
		     <img src="${book.imageUrl}" width="175" height="200">
		   </td>
			    
		   <td style="color:gray;">
			 By <span style="color: #B13100;">${book.authors[0]}</span>
			 <br><br>
			 Rating: <span style="color: #B13100;">${book.amazonRating}</span>
			 <br><br>
			 Publication Year: <span style="color: #B13100;">${book.publicationYear}</span>
			 <br><br>
			 <a href = "<%=request.getContextPath()%>/bookmark/save?bid=${book.id}" style="font-size:18px;color:#0058A6;font-weight:bold;text-decoration:none">Save</a>
		   </td>
		  </tr>
		  <tr>
     	    <td>&nbsp;</td>
  		  </tr>
  		 
	   </c:forEach>
	   
	</table>

</body>
</html>