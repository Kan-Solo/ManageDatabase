<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Manage Books</title>
   </head>
   <body>
      <%@ page import="java.util.List,com.tutorial.hibernate.entity.*" %>
      <h3> Available Books Details </h3>
      <%
         List<Book> books = (List<Book>)request.getAttribute("books");
       %>
      <h4> Total Number of Books are <%= books.size() %> </h4>
      <table border="1">
         <tr>
           <td> ID</td> <td>ISBN </td> <td> NAME </td> <td> AUTHOR </td> <td>PUBLISHER</td> <td> PRICE</td>
         </tr>
          <%
           for(int i=0;i<books.size();i++)
           {
           Book book = books.get(i) ;    
          %>
         <tr> 
           <td><%= book.getId() %></td>
           <td><%= book.getIsbn() %></td>
           <td><%= book.getName() %></td>
           <td><%= book.getAuthor() %></td>
           <td><%= book.getPublisher() %></td>
           <td><%= book.getPrice() %></td>
         </tr>
         <%     
         }
         %>
     </table>
      <br/>
     <a href= "index.jsp"> Main Menu </a>
    </body>
</html>