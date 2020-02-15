package com.tutorial.hibernate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
 
import com.tutorial.hibernate.entity.Book;
import com.tutorial.hibernate.util.HibernateUtils;
/**
 * Servlet implementation class InsertBookServlet
 */
@WebServlet("/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
        String isbn = request.getParameter("isbn");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String price = request.getParameter("price");
 
        Book book = new Book();
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setName(name);
        book.setPrice(Integer.parseInt(price));
        book.setPublisher(publisher);
 
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
 
        Transaction tx = session.beginTransaction();
        session.save(book);
 
        session.flush();
        tx.commit();
        
        response.sendRedirect("GetDataServlet");
        session.close();
    }

}
