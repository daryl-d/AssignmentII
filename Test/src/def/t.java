package def;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import database.Administrator;
import database.Cinema;
import database.Comment;
import database.Movie;
import database.MovieOfferring;
import database.Purchase;
import database.Rating;
import database.StandardUser;
import database.UserData;

/**
 * Servlet implementation class t
 */
public class t extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public t() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Rating.class);
		config.addAnnotatedClass(Comment.class);
		config.addAnnotatedClass(Cinema.class);
		config.addAnnotatedClass(Movie.class);
		config.addAnnotatedClass(MovieOfferring.class);
		config.addAnnotatedClass(StandardUser.class);
		config.addAnnotatedClass(UserData.class);
		config.addAnnotatedClass(Administrator.class);
		config.addAnnotatedClass(Purchase.class);

		config.configure();
		
		new SchemaExport(config).create(false, false);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("from database.StandardUser");
		@SuppressWarnings("unchecked")
		List<StandardUser> list = (List<StandardUser>) q.list();
		response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.write("<html>");
			out.write("<center>");
			out.write("<b>hello</b><br>");
			out.write("<b>" + "list.size() =" + list.size()  +" </b><br>");
			
			for(StandardUser u : list)	{
				
				out.write("<b> User Id is: " + u.getId() + "</b><br>");
				out.write("<b> User Name is: " + u.getUserName() + "</b><br>");
				out.write("<b> Email Address is: " + u.getEmailAddress() + "</b><br>");
				out.write("<b> Password is: " + u.getPassword() + "</b><br>");
			}
			
			
			out.write("</center>");
			out.write("</html");
		out.close();
	}

}
