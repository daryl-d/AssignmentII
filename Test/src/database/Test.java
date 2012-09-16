package database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Test {

	public static void main(String args[])	{
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
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Movie batman = new Movie();
		batman.setTitle("Batman Begins");
		batman.setActors("Christian Bale, Katie Holmes");
		batman.setSynposis("The start of the thrilling new Batman Trilogy envisioned by ...");
		batman.setReleased(2005);

		
		Cinema cinema = new Cinema();
		cinema.setAddress("55 Fake Street Sydney 2000 NSW Australia");
		cinema.setCapacity(300);
		cinema.setName("Hoyts Sydney");
				
		MovieOfferring mov = new MovieOfferring();
		mov.setCinema(cinema);
		mov.setMovie(batman);
		mov.setRemaining(300);
		
		List<MovieOfferring> m = new ArrayList<MovieOfferring>();
		m.add(mov);
		
		batman.setMovOffer(m);
		cinema.setMovOff(m);
	
		session.save(batman);
		session.save(cinema);
		session.save(mov);	
		
		UserData u = new UserData();
		u.setBirthYear(1992);
		u.setFavourites("TC NK");
		u.setFirstName("test");
		u.setGenre("horror");
		u.setLastName("test");

		
		StandardUser t = new StandardUser();
		t.setEmailAddress("test@test.com");
		t.setPassword("test");
		t.setUserName("test");
		
		t.setUserData(u);
		session.save(u);
		session.save(t);
		
		Comment c = new Comment();
		c.setComment("this movie was great");
		c.setMovie(batman);
		c.setPerson(t);
		
		session.save(c);
		
		Rating r = new Rating();
		r.setMovie(batman);
		r.setPerson(t);
		r.setRating(5);
		
		session.save(r);
		
		session.getTransaction().commit();
	}
}