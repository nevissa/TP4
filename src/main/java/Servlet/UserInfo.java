package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import DAO.DAOIMPL;
import DAO.IGENERIC;
import domain.User;
import jpa.JpaTest;

@WebServlet(name = "userinfo", urlPatterns = { "/UserInfo" })
public class UserInfo extends HttpServlet {
	private IGENERIC dao=new DAOIMPL();

	public IGENERIC getDao() {
		return dao;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		User user = new User();

		user.setFirstName(request.getParameter("name"));
		user.setLastName(request.getParameter("firstname"));
		
           this.dao.creerObject(user);
    List<User>list = dao.getUsers();
    out.println("<HTML>\n<BODY>\n" +
            "<H1>Recapitulatif des informations</H1>\n");
       for(User u:list)
	
    	 
           out.println("<UL>\n" +            
           " <LI>Nom: "
                   + u.getFirstName() + "\n" +
                   " <LI>Prenom: "
                   + u.getLastName() + "\n" +
                   " <LI>Age: "
                   +u.getAge()+ "\n" +
                   "</UL>\n" +                
           "</BODY></HTML>");

    	   
    	   
    	   
    	   
    	   
       
	}

}
