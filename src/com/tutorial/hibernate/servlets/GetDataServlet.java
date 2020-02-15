package com.tutorial.hibernate.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import javax.persistence.criteria.CriteriaQuery;

import com.tutorial.hibernate.entity.Book;
import com.tutorial.hibernate.util.HibernateUtils;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
	      SessionFactory factory = HibernateUtils.getSessionFactory();
	      Session session = factory.openSession();
	      
	      org.hibernate.Transaction tr = session.beginTransaction();
	      
	      CriteriaQuery cq = session.getCriteriaBuilder().createQuery(Book.class);
	      cq.from(Book.class);
	     
	 
	      List books = session.createQuery(cq).getResultList();
	      //session.flush();
	      tr.commit();
	      session.close();
	      request.setAttribute("books", books);
	 
	      request.getRequestDispatcher("bookDetails.jsp").forward(request, response);        
	    }

}
